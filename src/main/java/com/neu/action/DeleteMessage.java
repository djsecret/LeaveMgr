package com.neu.action;

import com.neu.service.MessageService;
import com.opensymphony.xwork2.ActionSupport;
import org.springframework.stereotype.Controller;

import javax.annotation.Resource;

@Controller
public class DeleteMessage extends ActionSupport
{
    private int id;

    @Resource
    private MessageService messageService;

    public int getId()
    {
        return id;
    }

    public void setId(int id)
    {
        this.id = id;
    }

    @Override
    public String execute() throws Exception
    {
        messageService.deleteMessage(id);
        return SUCCESS;
    }
}
