package com.socketio.backend.model;


public class Message {

    private MessageType messageType;

    private String content;
    private String room;

    private String username;

    public Message() {
    }

    public Message(MessageType messageType, String content, String room, String username) {
        this.messageType = messageType;
        this.content = content;
        this.room = room;
        this.username = username;
    }

    public MessageType getMessageType() {
        return messageType;
    }

    public void setMessageType(MessageType messageType) {
        this.messageType = messageType;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getRoom() {
        return room;
    }

    public void setRoom(String room) {
        this.room = room;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }
}
