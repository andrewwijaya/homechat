package com.bourchier.homechat.config;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.messaging.simp.SimpMessageHeaderAccessor;
import org.springframework.messaging.simp.SimpMessageType;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.stereotype.Controller;

import java.util.ArrayList;
import java.util.List;

@Controller
public class ChatController {

    private final SimpMessagingTemplate messagingTemplate;
    private final List<ChatMessage> chatHistory = new ArrayList<>();

    private static final Logger logger = LoggerFactory.getLogger(ChatController.class);

    public ChatController(SimpMessagingTemplate messagingTemplate) {
        this.messagingTemplate = messagingTemplate;
    }

    @MessageMapping("/sendMessage")
    @SendTo("/topic/chat")
    public ChatMessage sendMessage(@Payload ChatMessage message) {
        logger.info("Received message {}", message);
        chatHistory.add(message); // Store message in memory
        return message; // Broadcast message to all clients
    }

    @MessageMapping("/history")
    public void getChatHistory(SimpMessageHeaderAccessor headerAccessor) {
        String sessionId = headerAccessor.getSessionId();
        logger.info("Received chat history request");
        logger.info("Chat history size: {}", chatHistory.size());
        logger.info("SessionID: {}", sessionId);

        //https://stackoverflow.com/questions/34929578/spring-websocket-sendtosession-send-message-to-specific-session
        SimpMessageHeaderAccessor headerAccessorOut = SimpMessageHeaderAccessor
                .create(SimpMessageType.MESSAGE);
        headerAccessorOut.setSessionId(sessionId);
        headerAccessorOut.setLeaveMutable(true);

        messagingTemplate.convertAndSendToUser(sessionId, "/queue/history", chatHistory, headerAccessorOut.getMessageHeaders());
    }
}
