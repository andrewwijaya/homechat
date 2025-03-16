package com.bourchier.homechat;

import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Controller;

@Controller
public class ChatController {

    @MessageMapping("/message")
    @SendTo("/topic/chat")
    public ChatMessage sendMessage(ChatMessage message) {
        return message; // Broadcast message to all clients
    }
}
