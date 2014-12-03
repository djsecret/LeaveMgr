package com.neu.service.impl;

import com.neu.common.Constant;
import com.neu.dao.Staff_JobDAO;
import com.neu.pojo.Staff_Job;
import com.neu.service.Staff_JobService;
import com.opensymphony.xwork2.ActionContext;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;

@Service("staff_jobService")
public class Staff_JobServiceImpl implements Staff_JobService
{
    @Resource
    private Staff_JobDAO staff_jobDAO;

    @Override
    @Transactional(propagation = Propagation.SUPPORTS,readOnly = true)
    public boolean login(Staff_Job staff_job)
    {
        Staff_Job query = staff_jobDAO.getStaff_JobByStaff_id(staff_job.getStaff_id());

        if(query != null && query.getPassword().equals(staff_job.getPassword()))
        {
            ActionContext.getContext().getSession().put(Constant.STAFF_LOGIN,query);
            return true;
        }
        return false;
    }
}
