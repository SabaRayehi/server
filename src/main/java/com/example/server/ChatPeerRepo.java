package com.example.server;

import org.springframework.stereotype.Component;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

@Component
public class ChatPeerRepo implements Repo<Chat, Integer> {
    @Override
    public void add(Chat chat) {

    }

    @Override
    public void delete(Integer i) {

    }

    @Override
    public Chat search(Integer i) {
        return null;
    }

    @Override
    public void update(Chat chat) {

    }

    public List<Chat> findAllChatsForUsername(String username) {
        List<Chat> chats = new ArrayList<>();
        PreparedStatement preparedStatement = DBUtil.createPreparedStatement("SELECT * from chat_peers where username1=? or username2=?");
        try {
            preparedStatement.setString(1, username);
            preparedStatement.setString(2, username);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                String username1 = resultSet.getString("username1");
                Chat chat;
                if (username1.equals(username)) {
                    chat = new Chat(resultSet.getString("username2"), resultSet.getInt("chat_id"));
                }
                else {
                    chat = new Chat(username1, resultSet.getInt("chat_id"));
                }
                chats.add(chat);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return chats;
    }
}
