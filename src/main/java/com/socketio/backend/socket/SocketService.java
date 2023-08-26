package com.socketio.backend.socket;

import com.corundumstudio.socketio.SocketIOClient;
import com.corundumstudio.socketio.SocketIOServer;
import com.socketio.backend.model.Message;
import com.socketio.backend.model.MessageType;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@Slf4j
public class SocketService {

    @Autowired
    private SocketIOServer socketIOServer;
    public void sendSocketMessage(SocketIOClient senderClient, Message message, String room) {

        socketIOServer.getRoomOperations(room).getClients().stream().forEach(
                client -> client.sendEvent("read_message")
        );
//        socketIOServer.getRoomOperations(room).sendEvent("read_message");
        System.out.println("read message event : " + socketIOServer.getRoomOperations(room).getClients());
        /*for (SocketIOClient client : senderClient.getNamespace().getRoomOperations(room).getClients()) {
            if (!client.getSessionId().equals(senderClient.getSessionId())) {
                client.sendEvent("read_message", message);
            }
        }*/
    }

    public void saveMessage(SocketIOClient senderClient, String message) {
        Message storedMessage = Message.builder()
                .messageType(MessageType.CLIENT)
                .content(message)
                .room(message)
                .username(message)
                .build();
        sendSocketMessage(senderClient, storedMessage, message.getRoom());
    }

    public void saveInfoMessage(SocketIOClient senderClient, String message, String room) {
        Message storedMessage = Message.builder()
                .messageType(MessageType.SERVER)
                .content(message)
                .room(room)
                .build();
        sendSocketMessage(senderClient, storedMessage, room);
    }
}
