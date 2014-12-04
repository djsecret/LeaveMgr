package com.neu.dao.impl;

import com.neu.dao.Staff_InfoDAO;
import com.neu.pojo.Staff_Info;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;

import javax.annotation.Resource;

@Repository("staff_InfoDAO")
public class Staff_InfoDAOImpl implements Staff_InfoDAO
{
    @Resource
    private SessionFactory sessionFactory;

    @Override
    public Staff_Info getStaff_InfoById(int id)
    {
        return (Staff_Info)sessionFactory.getCurrentSession().get(Staff_Info.class,id);
    }

    @Override
    public void update(Staff_Info staff_info)
    {
        sessionFactory.getCurrentSession().update(staff_info);
    }
}
