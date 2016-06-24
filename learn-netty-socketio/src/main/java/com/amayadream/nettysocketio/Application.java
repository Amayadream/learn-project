package com.amayadream.nettysocketio;

import com.amayadream.nettysocketio.bean.MessageObject;
import com.amayadream.nettysocketio.listener.ChatEventListener;
import com.corundumstudio.socketio.Configuration;
import com.corundumstudio.socketio.SocketIOServer;
import org.junit.Test;

/**
 * @author :  Amayadream
 * @date :  2016.06.24 16:24
 */
public class Application {

    @Test
    public void test() throws InterruptedException {
        Configuration config = new Configuration();
        config.setHostname("localhost");
        config.setPort(9000);

        SocketIOServer server = new SocketIOServer(config);
        ChatEventListener listener = new ChatEventListener();
        listener.setSocketIOServer(server);
        //chatevent为事件名称
        server.addEventListener("chatevent", MessageObject.class, listener);
        //启动服务
        server.start();
        System.out.println("start....");
        Thread.sleep(Integer.MAX_VALUE);
        server.stop();
    }

}
