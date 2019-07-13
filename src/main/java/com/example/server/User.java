package com.example.server;

public class User {
    private String name;
    private String lastname;
    private String email;
    private String username;
    private String password;
    private byte[] picture;
    private boolean active;

    public User(String name, String lastname, String email, String username, String password, byte[] picture) {
        this.name = name;
        this.lastname = lastname;
        this.email = email;
        this.username = username;
        this.password = password;
        this.picture = picture;
        active = false;
    }
    public User(UpdateUserDto u) {
        this(u.getName(), u.getLastname(), null, u.getUsername(), null, u.getImage());
    }

    public  User(SignUpDto s) {
        this(s.getName(), s.getLastname(), s.getEmail(), s.getUsername(), s.getPassword(), s.getPicture());
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public byte[] getPicture() {
        return picture;
    }

    public void setPicture(byte[] picture) {
        this.picture = picture;
    }

    public boolean isActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }
}
