package com.demo.calculator;

import org.springframework.stereotype.Service;

import com.proto.ProtoAllServicesGrpc.ProtoAllServicesImplBase;
import com.proto.calculator.AddRequest;
import com.proto.calculator.AddResponse;

import io.grpc.stub.StreamObserver;

// @Service
public class CalculatorServiceImpl extends ProtoAllServicesImplBase {

    /*
     * StreamObserver: This is a interface provided by gRPC.
     * It used an object that can receive streamed responses from the server during
     * a RPC call.
     */

   // Override the add method for get the addition call from client and retun the desire output/ response for client
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
