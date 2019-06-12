package com.example.timeout.grpc;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Controller {
    @Autowired
    private GrpcClientService grpcClient;

    @RequestMapping("/grpc/call")
    public String call() {
        DemoProtocol.GrpcRequest request = DemoProtocol.GrpcRequest.newBuilder()
            .setId(2)
            .setName("Aispeech")
            .setPhone("18686868686")
            .build();
        return grpcClient.callGrpcServer(request);
    }
}
