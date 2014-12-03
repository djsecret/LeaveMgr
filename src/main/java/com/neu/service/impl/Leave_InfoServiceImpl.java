package com.neu.service.impl;

import com.neu.common.Constant;
import com.neu.dao.Leave_InfoDAO;
import com.neu.dao.MessageDAO;
import com.neu.dao.Staff_JobDAO;
import com.neu.pojo.Leave_Info;
import com.neu.pojo.Message;
import com.neu.pojo.Staff_Job;
import com.neu.service.Leave_InfoService;
import com.opensymphony.xwork2.ActionContext;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.Date;

@Service("leave_InfoService")
public class Leave_InfoServiceImpl implements Leave_InfoService
{
    @Resource
    private Staff_JobDAO staff_jobDAO;
    @Resource
    private Leave_InfoDAO leave_infoDAO;
    @Resource
    private MessageDAO messageDAO;

    @Override
    @Transactional(propagation = Propagation.SUPPORTS)
    public void addLeave_Info(Leave_Info leave_info)
    {
        Staff_Job proposer = (Staff_Job) ActionContext.getContext().getSession().get(Constant.STAFF_LOGIN);
        leave_info.setApply_time(new Date());
        leave_info.setProposer_id(proposer.getId());
        leave_info.setProposer_name(proposer.getStaff_name());
        leave_info.setResult(0);
        leave_info.setValid(0);
        String dept_name = proposer.getDept_name();
        String duty_name = proposer.getDuty_name();
        Staff_Job auditor;
        if(duty_name.equals(Constant.DUTY_MINISTER) || duty_name.equals(Constant.DUTY_HEAD))
        {
            auditor = staff_jobDAO.getGeneral_Manager();
        }
        else
        {
            auditor = staff_jobDAO.getManagerByDept_name(dept_name);
        }
        leave_info.setAuditor_id(auditor.getId());
        leave_info.setAuditor_name(auditor.getStaff_name());
        leave_infoDAO.addLeave_Info(leave_info);

        Message message = new Message();
        message.setSender_name(proposer.getStaff_name());
        message.setGenerate_time(new Date());
        message.setMessage_name(Constant.MESSAGE_LEAVE_NAME);
        message.setType(0);
        message.setContent(String.valueOf(leave_info.getId()));
        message.setFlag(1);
        message.setReceiver_id(auditor.getId());
        messageDAO.addMessage(message);

    }
}
