package com.neu.dao;


import com.neu.pojo.Message;

import java.util.List;

public interface MessageDAO
{
    Message getMessageById(int id);
    List<Message> getMessageListByReceiverId(int receiver_id);
    void addMessage(Message message);
    void updateMessage(Message message);
    void delete(int message_id);

    int getUnreadMessageNumber(int id);

    void batchDelete(Integer[] ids);

    Message getMessageByLeave_Info(int messageLeaveApplyType, String content);

    void delete(Message message);
}
