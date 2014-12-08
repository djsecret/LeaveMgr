package com.neu.dao.impl;

import com.neu.dao.Leave_InfoDAO;
import com.neu.pojo.Leave_Info;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;

import javax.annotation.Resource;
import java.util.List;

@Repository
public class Leave_InfoDAOImpl implements Leave_InfoDAO
{
    @Resource
    private SessionFactory sessionFactory;

    @Override
    public void addLeave_Info(Leave_Info leave_info)
    {
        System.out.println(leave_info);
        sessionFactory.getCurrentSession().save(leave_info);
    }

    @Override
    public Leave_Info getLeave_InfoById(int id)
    {
        return (Leave_Info)sessionFactory.getCurrentSession().get(Leave_Info.class,id);
    }

    @Override
    public void updateLeave_Info(Leave_Info leave_info)
    {
        sessionFactory.getCurrentSession().update(leave_info);
    }

    @SuppressWarnings("unchecked")
    @Override
    public List<Leave_Info> getLeave_InfosByProposer_Id(int proposer_id)
    {
        String hql = "from Leave_Info leave where leave.proposer_id = ? order by leave.apply_time desc";
        return sessionFactory.getCurrentSession().createQuery(hql).setParameter(0, proposer_id).list();
    }

    @Override
    public void delete(Leave_Info leave_info)
    {
        sessionFactory.getCurrentSession().delete(leave_info);
    }
}
