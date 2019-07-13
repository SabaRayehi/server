 package com.example.server;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

 @Component
public class ServerServiceHandler implements ServiceHandler {

    @Autowired
    ServerMailSender ServerMailSender;
    @Autowired
    UserRepo userRepo;
    @Autowired
    ChatPeerRepo chatPeerRepo;
    @Override
    public void register(SignUpDto signUpDto) {
        User user = new User(signUpDto);
        userRepo.add(user);
        try {
            int activationcode = userRepo.activeCodeForUser(user);
            ServerMailSender.sendEmailActivationCode(user.getUsername(), activationcode, user.getEmail());
        } catch (ActivationCodeGenerationFailedException e) {
            e.printStackTrace();
            System.out.println("can not create active code");
        }

    }

    @Override
    public boolean activeUser(String username, int activecode) {
        return userRepo.activeUser(username, activecode);
    }

    @Override
    public UserBaseInfoDto login(String username, String password) throws UserNotFoundException {
        User user = userRepo.search(username);
        if(user== null) throw new UserNotFoundException();
        if(!user.getPassword().equals(password)) throw new UserNotFoundException();
        UserBaseInfoDto userBaseInfoDto = new UserBaseInfoDto(user.getName(), user.getLastname(), user.getPicture(), user.getUsername());
        List<Chat> chatList = chatPeerRepo.findAllChatsForUsername(username);
        for(Chat chat: chatList) {
            User temp = userRepo.search(chat.getUsername());
            chat.setName(temp.getName());
            chat.setLastname(temp.getLastname());
            chat.setPicture(temp.getPicture());
        }
        userBaseInfoDto.setChats(chatList);
        return userBaseInfoDto;
    }

     @Override
     public void update(UpdateUserDto updateUserDto) {
         User user = new User(updateUserDto);
         userRepo.update(user);
     }
 }
