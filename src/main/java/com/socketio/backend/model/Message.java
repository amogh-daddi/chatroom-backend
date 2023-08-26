package com.socketio.backend.model;

import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@ToString
@Data
@Builder
public class Message {

    private MessageType messageType;

    private String content;
    private String room;

    private String username;


}
