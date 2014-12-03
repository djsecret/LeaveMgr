package com.neu.service.impl;

import com.neu.common.Constant;
import com.neu.dao.MessageDAO;
import com.neu.pojo.Message;
import com.neu.pojo.Staff_Job;
import com.neu.service.MessageService;
import com.opensymphony.xwork2.ActionContext;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;

@Service("messageService")
public class MessageServiceImpl implements MessageService
{
    @Resource
    private MessageDAO messageDAO;

    @Override
    @Transactional(propagation = Propagation.SUPPORTS,readOnly = true)
    public Message getMessage(int id)
    {
        return messageDAO.getMessageById(id);
    }

    @Override
    @Transactional(propagation = Propagation.SUPPORTS,readOnly = true)
    public List<Message> getMessageListByReceiverId(int receiver_id)
    {
        return messageDAO.getMessageListByReceiverId(receiver_id);
    }
}
