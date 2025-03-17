package com.bourchier.homechat.config;


public class ChatMessage {
    private String sender;
    private String content;
    private MessageType type;

    // Enum for message type (text, join, leave)
    public enum MessageType {
        CHAT, JOIN, LEAVE
    }

    public ChatMessage() {}

    public ChatMessage(String sender, String content, MessageType type) {
        this.sender = sender;
        this.content = content;
        this.type = type;
    }

    // Getters and Setters
    public String getSender() {
        return sender;
    }

    @Override
    public String toString() {
        return "ChatMessage{" +
                "sender='" + sender + '\'' +
                ", content='" + content + '\'' +
                ", type=" + type +
                '}';
    }

    public void setSender(String sender) {
        this.sender = sender;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public MessageType getType() {
        return type;
    }

    public void setType(MessageType type) {
        this.type = type;
    }
}