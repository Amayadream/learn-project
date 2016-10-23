package com.amayadream.thrift.demo;

import org.apache.thrift.protocol.TBinaryProtocol;
import org.apache.thrift.server.TServer;
import org.apache.thrift.server.TThreadPoolServer;
import org.apache.thrift.server.TThreadPoolServer.Args;
import org.apache.thrift.transport.TServerSocket;
import org.apache.thrift.transport.TTransportException;

/**
 * @author :  Amayadream
 * @date :  2016.10.23 20:00
 */
public class HelloServiceServer {

    public void startServer() {
        try {
            TServerSocket serverTransport = new TServerSocket(1234);
            HelloService.Processor process = new HelloService.Processor(new HelloServiceImpl());
            TBinaryProtocol.Factory portFactory = new TBinaryProtocol.Factory(true, true);
            Args args = new Args(serverTransport);
            args.processor(process);
            args.protocolFactory(portFactory);
            TServer server = new TThreadPoolServer(args);
            server.serve();
        } catch (TTransportException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        HelloServiceServer server = new HelloServiceServer();
        server.startServer();
    }

}
