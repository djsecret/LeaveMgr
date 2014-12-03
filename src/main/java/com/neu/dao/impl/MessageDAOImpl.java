package com.neu.dao.impl;

import com.neu.dao.MessageDAO;
import com.neu.pojo.Message;
import com.neu.pojo.Staff_Job;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;

import javax.annotation.Resource;
import java.util.List;

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

    @SuppressWarnings("unchecked")
    @Override
    public List<Message> getMessageListByReceiverId(int receiver_id)
    {
        String hql = "from Message m where m.receiver_id = ?";
        return sessionFactory.getCurrentSession().createQuery(hql).setParameter(0, receiver_id).list();
    }

    @Override
    public void addMessage(Message message)
    {
        sessionFactory.getCurrentSession().save(message);
    }
}
