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
        leave_info.setApply_time(new Date(System.currentTimeMillis()));
        leave_info.setProposer_id(proposer.getId());
        leave_info.setProposer_name(proposer.getStaff_name());
        leave_info.setResult(Constant.LEAVE_INFO_ALLPY_RESULT);
        leave_info.setValid(Constant.LEAVE_INFO_INVALID);
        String dept_name = proposer.getDept_name();
        int rank = proposer.getRank();
        Staff_Job auditor;
        if(rank == Constant.DUTY_MINISTER)
        {
            auditor = staff_jobDAO.getGeneral_Manager();
            System.out.println("总经理：" + auditor.getStaff_name());
        }
        else
        {
            auditor = staff_jobDAO.getManagerByDept_name(dept_name);
            System.out.println("部门经理：" + auditor.getStaff_name());
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
        leave_query.setHandle_time(new Date(System.currentTimeMillis()));

        Staff_Job staff_job = (Staff_Job)ActionContext.getContext().getSession().get(Constant.STAFF_LOGIN);

        if(leave_query.getDays() > Constant.DAYS_THRESHOLD && staff_job.getRank() == Constant.DUTY_MINISTER && leave_query.getResult() == Constant.LEAVE_INFO_ALLPY_RESULT)//大于指定天数，且当前为部门经理初次审核，那么应该转交给总经理
        {
            leave_query.setResult(Constant.LEAVE_INFO_DELIVER_RESULT);
            Staff_Job auditor = staff_jobDAO.getGeneral_Manager();
            leave_query.setAuditor_id(auditor.getId());
            leave_infoDAO.updateLeave_Info(leave_query);

            Message message = new Message();
            message.setSender_name(leave_query.getAuditor_name());//先用原来的审核人，也就是当前用户的名字给总经理发信
            leave_query.setAuditor_name(auditor.getStaff_name());//然后将总经理的名字设为审核人
            message.setReceiver_id(auditor.getId());
            message.setGenerate_time(new Date(System.currentTimeMillis()));
            message.setMessage_name(Constant.MESSAGE_DELIVER_NAME);
            message.setType(Constant.MESSAGE_LEAVE_DELIVER_TYPE);
            message.setContent(String.valueOf(leave_info.getId()));
            message.setFlag(Constant.MESSAGE_UNREAD_FLAG);
            messageDAO.addMessage(message);
        }
        else
        {
            leave_query.setResult(Constant.LEAVE_INFO_ALLOW_RESULT);
            leave_query.setValid(Constant.LEAVE_INFO_VALID);
            leave_infoDAO.updateLeave_Info(leave_query);

            Message message = new Message();
            message.setSender_name(leave_query.getAuditor_name());
            message.setReceiver_id(leave_query.getProposer_id());
            message.setGenerate_time(new Date(System.currentTimeMillis()));
            message.setMessage_name(Constant.MESSAGE_ALLOW_NAME);
            message.setType(Constant.MESSAGE_LEAVE_ALLOW_TYPE);
            message.setContent(Constant.MESSAGE_ALLOW_CONTENT);
            message.setFlag(Constant.MESSAGE_UNREAD_FLAG);
            messageDAO.addMessage(message);
        }

        return leave_query;
    }

    @Override
    @Transactional(propagation = Propagation.SUPPORTS)
    public Leave_Info rejectLeave(Leave_Info leave_info)
    {
        Leave_Info leave_query = leave_infoDAO.getLeave_InfoById(leave_info.getId());
        leave_query.setResult(Constant.LEAVE_INFO_REJECT_RESULT);
        leave_query.setValid(Constant.LEAVE_INFO_VALID);
        leave_query.setHandle_time(new Date(System.currentTimeMillis()));
        leave_infoDAO.updateLeave_Info(leave_query);

        Message message = new Message();
        message.setSender_name(leave_query.getAuditor_name());
        message.setReceiver_id(leave_query.getProposer_id());
        message.setGenerate_time(new Date(System.currentTimeMillis()));
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

        Staff_Job staff_job = (Staff_Job)ActionContext.getContext().getSession().get(Constant.STAFF_LOGIN);
        Staff_Job receiver;
        if(staff_job.getRank() == Constant.DUTY_MINISTER)
        {
            receiver = staff_jobDAO.getGeneral_Manager();
        }
        else
        {
            receiver = staff_jobDAO.getManagerByDept_name(staff_job.getDept_name());
        }
        Message message = new Message();
        message.setSender_name(leave_info.getProposer_name());
        message.setReceiver_id(receiver.getId());
        message.setGenerate_time(new Date(System.currentTimeMillis()));
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
        Staff_Job staff_job = (Staff_Job)ActionContext.getContext().getSession().get(Constant.STAFF_LOGIN);

        message.setSender_name(staff_job.getStaff_name());
        message.setReceiver_id(leave_query.getProposer_id());
        message.setGenerate_time(new Date(System.currentTimeMillis()));
        message.setMessage_name(Constant.MESSAGE_ARCHIVE_NAME);
        message.setType(Constant.MESSAGE_LEAVE_ARCHIVE_TYPE);
        message.setContent(Constant.MESSAGE_ARCHIVE_CONTENT);
        message.setFlag(Constant.MESSAGE_UNREAD_FLAG);
        messageDAO.addMessage(message);

        return leave_query;
    }

    @Override
    @Transactional(propagation = Propagation.SUPPORTS)
    public void cancelLeave(int id)
    {
        Leave_Info leave_info = leave_infoDAO.getLeave_InfoById(id);

        //如果之前发出的申请消息还没有被查看，那么就把消息删除，然后把请假条也删了
        Message message = messageDAO.getMessageByLeave_Info(Constant.MESSAGE_LEAVE_APPLY_TYPE,String.valueOf(leave_info.getId()));

        if(message.getFlag() == Constant.MESSAGE_UNREAD_FLAG)
        {
            messageDAO.delete(message);
            leave_infoDAO.delete(leave_info);
        }
        else
        {
            leave_info.setResult(Constant.LEAVE_INFO_CANCEL_RESULT);
            leave_infoDAO.updateLeave_Info(leave_info);
        }
    }
}
