package com.amayadream.thrift.demo;

import org.apache.thrift.TException;
import org.apache.thrift.protocol.TBinaryProtocol;
import org.apache.thrift.protocol.TProtocol;
import org.apache.thrift.transport.TSocket;
import org.apache.thrift.transport.TTransport;

/**
 * @author :  Amayadream
 * @date :  2016.10.23 20:00
 */
public class HelloServiceClient {

    public void startClient() {
        TTransport transport;
        try {
            transport = new TSocket("localhost", 1234);
            TProtocol protocol = new TBinaryProtocol(transport);
            HelloService.Client client = new HelloService.Client(protocol);
            transport.open();
            client.sayHello("world");
            transport.close();
        } catch (TException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        HelloServiceClient client = new HelloServiceClient();
        client.startClient();
    }

}
