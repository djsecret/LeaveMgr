package com.neu.dao.impl;

import com.neu.dao.MessageDAO;
import com.neu.pojo.Message;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;

import javax.annotation.Resource;

@Repository("messageDAO")
public class MessageDAOImpl implements MessageDAO
{
    @Resource
    private SessionFactory sessionFactory;

    @Override
    public Message getMessageById(int id)
    {
        return (Message)sessionFactory.getCurrentSession().get(Message.class,id);
    }
}
