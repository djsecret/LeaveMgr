package com.neu.service.impl;

import com.neu.common.Constant;
import com.neu.dao.MessageDAO;
import com.neu.dao.Staff_JobDAO;
import com.neu.pojo.Staff_Job;
import com.neu.service.Staff_JobService;
import com.opensymphony.xwork2.ActionContext;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.Map;

@Service("staff_jobService")
public class Staff_JobServiceImpl implements Staff_JobService
{
    @Resource
    private Staff_JobDAO staff_jobDAO;

    @Resource
    private MessageDAO messageDAO;

    @Override
    @Transactional(propagation = Propagation.SUPPORTS,readOnly = true)
    public boolean login(Staff_Job staff_job)
    {
        Staff_Job staff = staff_jobDAO.getStaff_JobByStaff_id(staff_job.getStaff_id());

        if(staff != null && staff.getPassword().equals(staff_job.getPassword()))
        {
            Map<String,Object> map = ActionContext.getContext().getSession();
            //put the stuff who login to the session
            map.put(Constant.STAFF_LOGIN,staff);

            int unreadMessageNum = messageDAO.getUnreadMessageNumber(staff.getId());
            //put total count of unread messages to the session
            map.put(Constant.UNREAD_MESSAGE_NUM,unreadMessageNum);

            return true;
        }
        return false;
    }

    @Override
    @Transactional(propagation = Propagation.SUPPORTS)
    public boolean updatePassword(String staff_id, String password, String newPassword)
    {
        Staff_Job staff = staff_jobDAO.getStaff_JobByStaff_id(staff_id);

        if(staff != null && staff.getPassword().equals(password))
        {
            staff.setPassword(newPassword);
            staff_jobDAO.update(staff);
            return true;
        }
        else
        {
            return false;
        }
    }
}
