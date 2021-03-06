package com.neu.dao.impl;

import com.neu.common.Constant;
import com.neu.dao.MessageDAO;
import com.neu.pojo.Message;
import org.hibernate.Query;
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
        String hql = "from Message m where m.receiver_id = ? order by m.generate_time desc";
        return sessionFactory.getCurrentSession().createQuery(hql).setParameter(0, receiver_id).list();
    }

    @Override
    public void addMessage(Message message)
    {
        sessionFactory.getCurrentSession().save(message);
    }

    @Override
    public void updateMessage(Message message)
    {
        sessionFactory.getCurrentSession().update(message);
    }

    @Override
    public void delete(int message_id)
    {
        Message message = getMessageById(message_id);
        if(message != null)
        {
            sessionFactory.getCurrentSession().delete(message);
        }
    }

    @SuppressWarnings("UnnecessaryUnboxing")
    @Override
    public int getUnreadMessageNumber(int id)
    {
        String hql = "select count(*) from Message m where m.flag = " + Constant.MESSAGE_UNREAD_FLAG + " and m.receiver_id = ?";
        return ((Long)sessionFactory.getCurrentSession().createQuery(hql).setParameter(0,id).uniqueResult()).intValue();
    }

    @Override
    public void batchDelete(Integer[] ids)
    {
        String hql = "delete from Message m where m.id in (:alist)";
        Query q=sessionFactory.getCurrentSession().createQuery(hql);

        q.setParameterList("alist",ids);
        q.executeUpdate();
    }

    @Override
    public Message getMessageByLeave_Info(int messageLeaveApplyType, String content)
    {
        String hql = "from Message m where m.type = ? and m.content = ?";
        return (Message)sessionFactory.getCurrentSession().createQuery(hql).setParameter(0, messageLeaveApplyType).setParameter(1,content).uniqueResult();
    }

    @Override
    public void delete(Message message)
    {
        sessionFactory.getCurrentSession().delete(message);
    }
}
