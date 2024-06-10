package com.demo.client;

import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;
import com.proto.calculator.AddRequest;
import com.proto.calculator.AddResponse;

import java.util.Scanner;

import com.proto.ProtoAllServicesGrpc;

public class CalculatorClient {
    
    public static void main(String[] args) {

        ManagedChannel channel = ManagedChannelBuilder.forAddress("localhost", 9091)
                                                        .usePlaintext()
                                                        .build();

        ProtoAllServicesGrpc.ProtoAllServicesBlockingStub stub = ProtoAllServicesGrpc.newBlockingStub(channel);

        Scanner sc = new Scanner(System.in);

        System.out.println("Enter any two numbers: ");
        int num1 = sc.nextInt();
        int num2 = sc.nextInt();

        AddRequest request = AddRequest.newBuilder()
                                        .setNum1(num1)
                                        .setNum2(num2)
                                        .build();

        AddResponse response = stub.add(request);

        System.out.println("Sum: " + response.getResult());

        channel.shutdown();

        sc.close();
    }
}
