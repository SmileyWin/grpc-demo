package com.example.timeout.grpc;

import io.grpc.stub.StreamObserver;
import net.devh.springboot.autoconfigure.grpc.server.GrpcService;

@GrpcService(value = DemoServiceGrpc.class)
public class GrpcServerService extends DemoServiceGrpc.DemoServiceImplBase {
    @Override
    public void call(DemoProtocol.GrpcRequest request, StreamObserver<DemoProtocol.GrpcResponse> responseObserver) {
        // TODO grpc interface implement
        System.out.println("gRPC server request id: " + request.getId() + ", name: " + request.getName() + ", phone: " + request.getPhone());
        DemoProtocol.GrpcResponse.Builder builder = DemoProtocol.GrpcResponse.newBuilder()
            .setCode(200)
            .setMessage("OK, This Message Come From gRPC Server");
        responseObserver.onNext(builder.build());
        responseObserver.onCompleted();
    }
}
