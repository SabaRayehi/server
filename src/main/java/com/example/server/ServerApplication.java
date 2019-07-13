package com.example.server;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.remoting.rmi.RmiServiceExporter;
import org.springframework.scheduling.annotation.EnableAsync;

import java.net.ServerSocket;

@SpringBootApplication
@EnableAsync
public class ServerApplication {

    public static void main(String[] args) {
        SpringApplication.run(ServerApplication.class, args);
        ServerChannel serverChannel = new ServerChannel();
        serverChannel.start();
    }

    @Bean
    public RmiServiceExporter rmiServiceExporter(ServerServiceHandler serverServiceHandler) {
        RmiServiceExporter serviceExporter = new RmiServiceExporter();
        serviceExporter.setServiceName("serverService");
        serviceExporter.setRegistryPort(5050);
        serviceExporter.setServiceInterface(ServiceHandler.class);
        serviceExporter.setService(serverServiceHandler);
        return serviceExporter;
    }

}
