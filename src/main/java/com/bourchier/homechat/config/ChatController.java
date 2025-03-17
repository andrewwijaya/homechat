package com.bourchier.homechat.config;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Controller;

import java.util.ArrayList;
import java.util.List;

@Controller
public class ChatController {

    private final List<ChatMessage> chatHistory = new ArrayList<>();

    private static final Logger logger = LoggerFactory.getLogger(ChatController.class);

    @MessageMapping("/sendMessage")
    @SendTo("/topic/chat")
    public ChatMessage sendMessage(@Payload ChatMessage message) {
        logger.info("Received message {}", message);
        chatHistory.add(message); // Store message in memory
        return message; // Broadcast message to all clients
    }

    //chat history broadcasts to all connections, this is not good.
    @MessageMapping("/history")
    @SendTo("/topic/history")
    public List<ChatMessage> getChatHistory() {
        logger.info("Received chat history request");
        logger.info("Chat history size: {}", chatHistory.size());
        return chatHistory; // Send all previous messages
    }
}
