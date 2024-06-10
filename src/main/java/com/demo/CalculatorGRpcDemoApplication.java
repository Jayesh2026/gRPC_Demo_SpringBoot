package com.demo;


import java.io.IOException;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.Bean;

import com.proto.ProtoAllServicesGrpc.ProtoAllServicesImplBase;

import io.grpc.Server;
import io.grpc.ServerBuilder;

@SpringBootApplication
public class CalculatorGRpcDemoApplication {

	/* Creating a Server for gRPC
	 * creating and configuring a gRPC server bean and register it in Application contex.
	 * 
	 * ProtoAllServicesImplBase is gRPC service passsed as parameter, for gRPC service implementation added to the server.
	*/ 
	@Bean
	public Server grpcServer(ProtoAllServicesImplBase service) {
		return ServerBuilder.forPort(9091)
				.addService(service)
				.build();
	}

    public static void main(String[] args) throws IOException, InterruptedException {
        // SpringApplication.run(CalculatorGRpcDemoApplication.class, args);
		
        ConfigurableApplicationContext context = SpringApplication.run(CalculatorGRpcDemoApplication.class, args);
		Server server = context.getBean(Server.class);
		System.out.println("Starting gRPC server on port 9091....");
		// use for starting the gRPC Server
		server.start();
		System.out.println("grpc server started and listening of port 9091");
		// USed for block the main thread termination, until the gRPC Server is terminate.
		server.awaitTermination();
	}
}
