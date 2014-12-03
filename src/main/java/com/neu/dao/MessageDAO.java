package com.neu.dao;


import com.neu.pojo.Message;

import java.util.List;

public interface MessageDAO
{
    Message getMessageById(int id);
    List<Message> getMessageListByReceiverId(int receiver_id);
    void addMessage(Message message);
}
