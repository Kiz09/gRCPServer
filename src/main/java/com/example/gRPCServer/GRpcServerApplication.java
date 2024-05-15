package com.example.gRPCServer;

import net.devh.boot.grpc.server.service.GrpcService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class GRpcServerApplication {

	public static void main(String[] args) {
		SpringApplication.run(GRpcServerApplication.class, args);
		//HelloServer hello = new HelloServer(9090);
		//hello.run();
	}

}
