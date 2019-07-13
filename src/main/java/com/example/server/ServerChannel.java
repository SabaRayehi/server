package com.example.server;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class ServerChannel extends Thread {
    @Override
    public void run() {
        ServerSocket serverSocket = null;
        try {
            serverSocket = new ServerSocket(12345, 5);
        } catch (IOException e) {
            e.printStackTrace();
            System.exit(-1);
        }
        while (true) {
            try {
                Socket socket = serverSocket.accept();
                byte[] data = new byte[8192];
                int size = socket.getInputStream().read(data);
                String info = new String(data, 0,size);
                System.out.println(info);
                System.out.println(size);
                String[] tokens = info.split("[,]");
                ServiceThread serviceThread = new ServiceThread(socket.getInputStream(),tokens[0], Integer.parseInt(tokens[1].trim()));
                serviceThread.start();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
