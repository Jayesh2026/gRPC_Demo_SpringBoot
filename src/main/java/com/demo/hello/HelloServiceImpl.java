package com.demo.hello;

import org.springframework.stereotype.Service;

import com.proto.ProtoAllServicesGrpc.ProtoAllServicesImplBase;
import com.proto.hello.HelloRequest;
import com.proto.hello.HelloResponse;

import io.grpc.stub.StreamObserver;

// @Service
public class HelloServiceImpl extends ProtoAllServicesImplBase {
    
    @Override
    public void sayHello(HelloRequest request, StreamObserver<HelloResponse> responseObserver) {

        String mssg = "Hello " + request.getName() ;

        HelloResponse response = HelloResponse.newBuilder()
                                            .setMessage(mssg)
                                            .build();
        
        responseObserver.onNext(response);
        responseObserver.onCompleted();
    }

}
