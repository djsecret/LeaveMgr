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
import java.util.List;

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
        leave_info.setResult(Constant.LEAVE_INFO_REJECT_RESULT);
        leave_info.setValid(Constant.LEAVE_INFO_INVALID);
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
        message.setGenerate_time(new Date(System.currentTimeMillis()));
        System.out.println(message.getGenerate_time());
        message.setMessage_name(Constant.MESSAGE_LEAVE_NAME);
        message.setType(Constant.MESSAGE_LEAVE_APPLY_TYPE);
        message.setContent(String.valueOf(leave_info.getId()));
        message.setFlag(Constant.MESSAGE_UNREAD_FLAG);
        message.setReceiver_id(auditor.getId());
        messageDAO.addMessage(message);

    }

    @Override
    @Transactional(propagation = Propagation.SUPPORTS,readOnly = true)
    public Leave_Info getLeave_Info(int id)
    {
        return leave_infoDAO.getLeave_InfoById(id);
    }

    @Override
    @Transactional(propagation = Propagation.SUPPORTS)
    public Leave_Info allowLeave(Leave_Info leave_info)
    {
        Leave_Info leave_query = leave_infoDAO.getLeave_InfoById(leave_info.getId());
        leave_query.setResult(leave_info.getResult());
        leave_query.setValid(Constant.LEAVE_INFO_VALID);
        leave_query.setHandle_time(new Date());
        leave_infoDAO.updateLeave_Info(leave_query);

        Message message = new Message();
        message.setSender_name(leave_query.getAuditor_name());
        message.setReceiver_id(leave_query.getProposer_id());
        message.setGenerate_time(new Date());
        message.setMessage_name(Constant.MESSAGE_ALLOW_NAME);
        message.setType(Constant.MESSAGE_LEAVE_ALLOW_TYPE);
        message.setContent(Constant.MESSAGE_ALLOW_CONTENT);
        message.setFlag(Constant.MESSAGE_UNREAD_FLAG);
        messageDAO.addMessage(message);

        return leave_query;
    }

    @Override
    @Transactional(propagation = Propagation.SUPPORTS)
    public Leave_Info rejectLeave(Leave_Info leave_info)
    {
        Leave_Info leave_query = leave_infoDAO.getLeave_InfoById(leave_info.getId());
        leave_query.setResult(leave_info.getResult());
        leave_query.setValid(Constant.LEAVE_INFO_VALID);
        leave_query.setHandle_time(new Date());
        leave_infoDAO.updateLeave_Info(leave_query);

        Message message = new Message();
        message.setSender_name(leave_query.getAuditor_name());
        message.setReceiver_id(leave_query.getProposer_id());
        message.setGenerate_time(new Date());
        message.setMessage_name(Constant.MESSAGE_REJECT_NAME);
        message.setType(Constant.MESSAGE_LEAVE_REJECT_TYPE);
        message.setContent(Constant.MESSAGE_REJECT_CONTENT);
        message.setFlag(Constant.MESSAGE_UNREAD_FLAG);
        messageDAO.addMessage(message);

        return leave_query;
    }

    @Override
    @Transactional(propagation = Propagation.SUPPORTS,readOnly = true)
    public List<Leave_Info> getLeave_InfoList(int proposer_id)
    {
        return leave_infoDAO.getLeave_InfosByProposer_Id(proposer_id);
    }

    @Override
    @Transactional(propagation = Propagation.SUPPORTS)
    public void resumptionFromLeave(int id)
    {
        Leave_Info leave_info = leave_infoDAO.getLeave_InfoById(id);
        leave_info.setResult(Constant.LEAVE_INFO_RESUMPTION_RESULT);
        leave_infoDAO.updateLeave_Info(leave_info);

        Message message = new Message();
        message.setSender_name(leave_info.getProposer_name());
        message.setReceiver_id(leave_info.getAuditor_id());
        message.setGenerate_time(new Date());
        message.setMessage_name(Constant.MESSAGE_RESUMPTION_NAME);
        message.setType(Constant.MESSAGE_LEAVE_RESUMPTION_TYPE);
        message.setContent(String.valueOf(leave_info.getId()));
        message.setFlag(Constant.MESSAGE_UNREAD_FLAG);
        messageDAO.addMessage(message);
    }

    @Override
    @Transactional(propagation = Propagation.SUPPORTS)
    public Leave_Info archiveLeave(Leave_Info leave_info)
    {
        Leave_Info leave_query = leave_infoDAO.getLeave_InfoById(leave_info.getId());
        leave_query.setResult(Constant.LEAVE_INFO_ARCHIVE_RESULT);
        leave_infoDAO.updateLeave_Info(leave_query);

        Message message = new Message();
        message.setSender_name(leave_query.getAuditor_name());
        message.setReceiver_id(leave_query.getProposer_id());
        message.setGenerate_time(new Date());
        message.setMessage_name(Constant.MESSAGE_ARCHIVE_NAME);
        message.setType(Constant.MESSAGE_LEAVE_ARCHIVE_TYPE);
        message.setContent(Constant.MESSAGE_ARCHIVE_CONTENT);
        message.setFlag(Constant.MESSAGE_UNREAD_FLAG);
        messageDAO.addMessage(message);

        return leave_query;
    }
}
