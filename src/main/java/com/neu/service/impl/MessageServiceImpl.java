package com.neu.service.impl;

import com.neu.dao.MessageDAO;
import com.neu.pojo.Message;
import com.neu.service.MessageService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;

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
}
