package com.demo.service;

import org.springframework.stereotype.Service;

import com.proto.ProtoAllServicesGrpc.ProtoAllServicesImplBase;
import com.proto.calculator.AddRequest;
import com.proto.calculator.AddResponse;
import com.proto.hello.HelloRequest;
import com.proto.hello.HelloResponse;

import io.grpc.stub.StreamObserver;

@Service
public class AllServicesImpl extends ProtoAllServicesImplBase {

    /*
     * StreamObserver: This is a interface provided by gRPC.
     * It used an object that can receive streamed responses from the server during
     * a RPC call.
     */
    
    // Override the sayHello method for get user name and return response with Hello + "User_Name"
    @Override
    public void sayHello(HelloRequest request, StreamObserver<HelloResponse> responseObserver) {

        String mssg = "Hello " + request.getName() ;

        HelloResponse response = HelloResponse.newBuilder()
                                            .setMessage(mssg)
                                            .build();
        
        responseObserver.onNext(response);
        responseObserver.onCompleted();
    }

    // Override the add method for get the addition call from client and return the desire output/ response for client
    @Override
    public void add(AddRequest request, StreamObserver<AddResponse> responseObserver) {

        int num1 = request.getNum1();
        int num2 = request.getNum2();
        int result = num1 + num2;

        AddResponse response = AddResponse.newBuilder()
                .setResult(result)
                .build();

        responseObserver.onNext(response);
        responseObserver.onCompleted();
    }

}
