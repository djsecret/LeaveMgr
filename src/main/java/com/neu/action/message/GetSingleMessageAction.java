package com.neu.action.message;

import com.neu.common.Constant;
import com.neu.pojo.Leave_Info;
import com.neu.pojo.Message;
import com.neu.service.Leave_InfoService;
import com.neu.service.MessageService;
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
        messageService.setMessageRead(message);
        if(message.getType() == Constant.MESSAGE_LEAVE_APPLY_TYPE)
        {
            int leave_infoID = Integer.parseInt(message.getContent());
            leave_info = leave_infoService.getLeave_Info(leave_infoID);
        }
        return SUCCESS;
    }
}
