package com.example.gRPCServer;

import io.grpc.Server;
import io.grpc.ServerBuilder;
import java.io.IOException;
import java.util.concurrent.TimeUnit;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class HelloServer implements Runnable{

    private Server server;

    public HelloServer(int port) {
        log.info("Building server on port {}", port);
        server = ServerBuilder.forPort(port)
                .addService(new HelloServiceImpl())
                .build();
    }

    public void shutdown() {
        log.info("Shutting down gRPC server");
        if (server != null) {
            try {
                server.shutdown().awaitTermination(30, TimeUnit.SECONDS);
            } catch (InterruptedException e) {
                log.error("InterruptedException ", e);
                Thread.currentThread().interrupt();
            }
        }
    }

    @Override
    public void run() {
        try{
            server.start();
            log.info("Server started, listening on: "+ server.getPort());
        }catch (IOException e){
            log.error("IOException ", e);
        }

        try{
            server.awaitTermination();
        }catch (InterruptedException e){
            log.error("InterruptedException", e);
            Thread.currentThread().interrupt();
        }
    }
}
