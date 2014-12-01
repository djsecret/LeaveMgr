package com.neu.dao.impl;

import com.neu.dao.UserDAO;
import com.neu.pojo.User;
import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by ubuntu on 14-10-30.
 */
@Repository("userDAO")
public class UserDAOImpl implements UserDAO
{
    @Resource(name = "sessionFactory")
    private SessionFactory sessionFactory;

    @Override
    public User getUserById(int id)
    {
//        Session session = sessionFactory.openSession();
//        Transaction tx = session.beginTransaction();
//        User user = null;
//        try
//        {
//            //user = (User)session.load(User.class,id);
//            user = (User)session.get(User.class,id);
//            tx.commit();
//        }
//        catch (Exception e)
//        {
//            if(null != tx)
//            {
//                tx.rollback();
//            }
//            e.printStackTrace();
//        }
//        finally
//        {
//            session.close();
//        }
//        return user;
        return (User)sessionFactory.getCurrentSession().get(User.class,id);
    }

    @Override
    public List<User> getUsersByName(String username)
    {
//        List<User> users = null;
//        Session session = sessionFactory.openSession();
//        Transaction tx = session.beginTransaction();
//        try
//        {
//            String hql = "from User as u where u.username = '" + username + "'";
//            Query query = session.createQuery(hql);
//            users = query.list();
//
//            tx.commit();
//        }
//        catch (Exception e)
//        {
//            e.printStackTrace();
//            if(null != tx)
//            {
//                tx.rollback();
//            }
//        }
//        finally
//        {
//            session.close();
//        }
//
//        return users;
        String hql = "from User as u where u.username = '" + username + "'";
        Query query = sessionFactory.getCurrentSession().createQuery(hql);
        return query.list();
    }

    @Override
    public void addUser(User user)
    {
//        Session session = sessionFactory.openSession();
//        Transaction tx = session.beginTransaction();
//        try
//        {
//            session.save(user);
//            tx.commit();
//            return true;
//        }
//        catch (Exception e)
//        {
//            e.printStackTrace();
//            if(null != tx)
//            {
//                tx.rollback();
//            }
//            return false;
//        }
//        finally
//        {
//            session.close();
//        }
        sessionFactory.getCurrentSession().save(user);
    }
}
