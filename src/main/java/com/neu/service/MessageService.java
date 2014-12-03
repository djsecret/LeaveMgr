package com.neu.service;


import com.neu.pojo.Message;

import java.util.List;

public interface MessageService
{
    Message getMessage(int id);
    List<Message> getMessageListByReceiverId(int receiver_id);
}
