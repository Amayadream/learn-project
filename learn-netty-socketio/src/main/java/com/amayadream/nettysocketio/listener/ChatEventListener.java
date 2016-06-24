package com.amayadream.nettysocketio.listener;

import com.amayadream.nettysocketio.bean.MessageObject;
import com.corundumstudio.socketio.AckRequest;
import com.corundumstudio.socketio.SocketIOClient;
import com.corundumstudio.socketio.SocketIOServer;
import com.corundumstudio.socketio.listener.DataListener;

/**
 * @author :  Amayadream
 * @date :  2016.06.24 09:05
 */
public class ChatEventListener implements DataListener<MessageObject> {

    private SocketIOServer server;

    @Override
    public void onData(SocketIOClient socketIOClient, MessageObject messageObject, AckRequest ackRequest) throws Exception {
        this.server.getBroadcastOperations().sendEvent("chatevent", messageObject);
    }

    public SocketIOServer getSocketIOServer() {
        return server;
    }

    public void setSocketIOServer(SocketIOServer socketIOServer) {
        this.server = socketIOServer;
    }
}
