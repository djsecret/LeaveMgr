package com.neu.dao.impl;

import com.neu.common.Constant;
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

    /**
     * 获取总经理
     * @return 总经理
     */
    @Override
    public Staff_Job getGeneral_Manager()
    {
        String hql = "from Staff_Job staff where staff.duty_name = ?";

        return (Staff_Job)sessionFactory.getCurrentSession().createQuery(hql).setString(0, Constant.DUTY_GENERAL_MANAGER).uniqueResult();
    }

    /**
     * 获取部长或者科长
     * @param dept_name 部门名称
     * @return 部长或者科长
     */
    @Override
    public Staff_Job getManagerByDept_name(String dept_name)
    {
        String hql = "from Staff_Job staff where staff.dept_name = ? and staff.duty_name like '%长'";
        return (Staff_Job)sessionFactory.getCurrentSession().createQuery(hql).setString(0, dept_name).uniqueResult();
    }

    @Override
    public void update(Staff_Job staff)
    {
        sessionFactory.getCurrentSession().update(staff);
    }


}
