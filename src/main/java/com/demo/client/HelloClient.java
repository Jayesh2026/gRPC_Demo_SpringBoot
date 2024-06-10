package com.demo.client;

import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;
import com.proto.hello.HelloRequest;
import com.proto.hello.HelloResponse;

import java.util.Scanner;

import com.proto.ProtoAllServicesGrpc;

public class HelloClient {

    public static void main(String[] args) {
        // Create a channel to the server
        ManagedChannel channel = ManagedChannelBuilder.forAddress("localhost", 9091)
                                                        .usePlaintext()
                                                        .build();

        // Create a blocking stub on the channel
        ProtoAllServicesGrpc.ProtoAllServicesBlockingStub stub = ProtoAllServicesGrpc.newBlockingStub(channel);

        Scanner sc = new Scanner(System.in);
        
        System.out.println("Enter your name: ");
        String name = sc.nextLine();

        // Create a HelloRequest
        HelloRequest request = HelloRequest.newBuilder()
                                            .setName(name)
                                            .build();

        // Call the service and get the response
        HelloResponse response = stub.sayHello(request);

        // Print the response
        System.out.println(response.getMessage());

        // Shutdown the channel
        channel.shutdown();

        sc.close();
    }
}
