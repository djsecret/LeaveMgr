package com.neu.dao.impl;

import com.neu.dao.Leave_InfoDAO;
import com.neu.pojo.Leave_Info;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;

import javax.annotation.Resource;

@Repository
public class Leave_InfoDAOImpl implements Leave_InfoDAO
{
    @Resource
    private SessionFactory sessionFactory;

    @Override
    public void addLeave_Info(Leave_Info leave_info)
    {

    }
}
