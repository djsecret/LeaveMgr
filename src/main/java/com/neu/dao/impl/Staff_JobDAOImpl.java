package com.neu.dao.impl;

import com.neu.dao.Staff_JobDAO;
import com.neu.pojo.Staff_Job;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;

import javax.annotation.Resource;

@Repository("staff_jobDAO")
public class Staff_JobDAOImpl implements Staff_JobDAO
{
    @Resource
    private SessionFactory sessionFactory;

    @Override
    public Staff_Job getStaff_JobByStaff_id(String staff_id)
    {
        String hql = "from Staff_Job staff where staff.staff_id = ?";
        return (Staff_Job)sessionFactory.getCurrentSession().createQuery(hql).setParameter(0,staff_id).uniqueResult();
    }
}
