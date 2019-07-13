package com.example.server;

import java.io.IOException;
import java.io.InputStream;
import java.net.Socket;
import java.util.Date;

public class ServiceThread  extends Thread{
    private InputStream inputStream;
    private String username;
    private int chatId;
    private  MessageRepo messageRepo;

    public ServiceThread(InputStream inputStream, String username, int chatId) {
        this.inputStream = inputStream;
        this.username = username;
        this.chatId = chatId;
        this.messageRepo = new MessageRepo();
    }

    @Override
    public void run() {
        byte[] buffer = new byte[8192];
        int size = 0;
        while (true) {
            try {
                size = inputStream.read(buffer);
                if (size==-1) {
                    return ;
                }
                String type = new String(buffer,0, 4);
                if(type.equals("text")) {
                    String message = new String(buffer, 5 , size-5);
                    Message text = new Message(chatId,username,new Date(),message);
                    messageRepo.add(text);
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
