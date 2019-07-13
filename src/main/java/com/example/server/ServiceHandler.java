package com.example.server;

public interface ServiceHandler {
    void register(SignUpDto signUpDto);
    boolean activeUser(String username, int activecode);
    UserBaseInfoDto login(String username, String password) throws UserNotFoundException;
    void update(UpdateUserDto updateUserDto);
}
