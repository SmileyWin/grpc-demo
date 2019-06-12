package com.example.timeout.grpc;

import io.grpc.ManagedChannel;
import net.devh.springboot.autoconfigure.grpc.client.GrpcClient;

import org.springframework.stereotype.Service;

@Service
public class GrpcClientService {
    @GrpcClient("wsl-grpc-server")
    private ManagedChannel managedChannel;

    public String callGrpcServer(DemoProtocol.GrpcRequest request) {
        System.out.println("client call gRPC server...");
        DemoServiceGrpc.DemoServiceBlockingStub stub = DemoServiceGrpc.newBlockingStub(managedChannel);
        DemoProtocol.GrpcResponse response = stub.call(request);
        System.out.println("gRPC response: " + response.getCode() + ", message: " + response.getMessage());
        return response.getMessage();
    }
}
