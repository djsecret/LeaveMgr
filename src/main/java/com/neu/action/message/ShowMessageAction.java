package com.neu.action.message;

import com.neu.common.Constant;
import com.neu.pojo.Message;
import com.neu.pojo.Staff_Job;
import com.neu.service.MessageService;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import org.springframework.stereotype.Controller;

import javax.annotation.Resource;
import java.util.List;

@Controller
public class ShowMessageAction extends ActionSupport
{
    @Resource
    private MessageService messageService;

    private List<Message> messages;

    public List<Message> getMessages()
    {
        return messages;
    }

    public void setMessages(List<Message> messages)
    {
        this.messages = messages;
    }

    @Override
    public String execute() throws Exception
    {
        Staff_Job staff = (Staff_Job) ActionContext.getContext().getSession().get(Constant.STAFF_LOGIN);

        messages = messageService.getMessageListByReceiverId(staff.getId());

        return SUCCESS;
    }
}
