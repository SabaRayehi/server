package com.example.server;

import java.util.Date;

public class Message {
    private int chatid;
    private String username;
    private Date date;
    private String message;
    private byte[] file;

    public Message(int chatid, String username, Date date, byte[] file) {
        this.chatid = chatid;
        this.username = username;
        this.date = date;
        this.file = file;
    }
    public Message(int chatid, String username, Date date, String message) {
        this.chatid = chatid;
        this.username = username;
        this.date = date;
        this.message = message;
    }

    public int getChatid() {
        return chatid;
    }

    public void setChatid(int chatid) {
        this.chatid = chatid;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public byte[] getFile() {
        return file;
    }

    public void setFile(byte[] file) {
        this.file = file;
    }


}
