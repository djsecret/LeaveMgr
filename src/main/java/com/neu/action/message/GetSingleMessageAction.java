package com.neu.action.message;

import com.neu.common.Constant;
import com.neu.pojo.Leave_Info;
import com.neu.pojo.Message;
import com.neu.service.Leave_InfoService;
import com.neu.service.MessageService;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import org.springframework.stereotype.Controller;

import javax.annotation.Resource;

@Controller
public class GetSingleMessageAction extends ActionSupport
{
    private Message message;
    private Leave_Info leave_info;

    @Resource
    private MessageService messageService;

    @Resource
    private Leave_InfoService leave_infoService;

    public Leave_Info getLeave_info()
    {
        return leave_info;
    }

    public void setLeave_info(Leave_Info leave_info)
    {
        this.leave_info = leave_info;
    }

    public Message getMessage()
    {
        return message;
    }

    public void setMessage(Message message)
    {
        this.message = message;
    }

    @Override
    public String execute() throws Exception
    {
        message = messageService.getMessage(message.getId());
        if(message.getFlag() == Constant.MESSAGE_UNREAD_FLAG)
        {
            messageService.setMessageRead(message);
            int unreadNum = (Integer) ActionContext.getContext().getSession().get(Constant.UNREAD_MESSAGE_NUM);
            ActionContext.getContext().getSession().put(Constant.UNREAD_MESSAGE_NUM,unreadNum-1);
        }

        if(message.getType() == Constant.MESSAGE_LEAVE_APPLY_TYPE || message.getType() == Constant.MESSAGE_LEAVE_RESUMPTION_TYPE)
        {
            int leave_infoID = Integer.parseInt(message.getContent());
            leave_info = leave_infoService.getLeave_Info(leave_infoID);
        }

        return SUCCESS;
    }
}
