package com.neu.action;

import com.neu.pojo.Message;
import com.neu.service.MessageService;
import com.opensymphony.xwork2.ActionSupport;
import org.springframework.stereotype.Controller;

import javax.annotation.Resource;

@Controller
public class GetSingleMessage extends ActionSupport
{
    private Message message;

    @Resource
    private MessageService messageService;

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
        return SUCCESS;
    }
}
