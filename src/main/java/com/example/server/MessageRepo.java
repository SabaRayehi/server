package com.example.server;

import com.mysql.cj.jdbc.Blob;

import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Timestamp;

public class MessageRepo implements Repo<Message, Integer> {
    @Override
    public void add(Message message) {
        if(message.getMessage() != null) {
            PreparedStatement preparedStatement = DBUtil.createPreparedStatement("INSERT INTO messages(chatid,username,date,message) values(?,?,?,?)");
            try {
                preparedStatement.setInt(1, message.getChatid());
                preparedStatement.setString(2, message.getUsername());
                preparedStatement.setTimestamp(3 , new Timestamp(message.getDate().getTime()));
                preparedStatement.setString(4,message.getMessage());
                preparedStatement.execute();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        } else {
            PreparedStatement preparedStatement = DBUtil.createPreparedStatement("INSERT INTO messages(chatid,username,date,file) values(?,?,?,?)");
            try {
                preparedStatement.setInt(1, message.getChatid());
                preparedStatement.setString(2, message.getUsername());
                preparedStatement.setTimestamp(3 , new Timestamp(message.getDate().getTime()));
                preparedStatement.setBlob(4,new Blob(message.getFile() , null));
                preparedStatement.execute();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

    }

    @Override
    public void delete(Integer integer) {

    }

    @Override
    public Message search(Integer integer) {
        return null;
    }

    @Override
    public void update(Message message) {

    }
}
