package com.neu.action.leave;

import com.neu.service.Leave_InfoService;
import com.opensymphony.xwork2.ActionSupport;
import org.springframework.stereotype.Controller;

import javax.annotation.Resource;

@Controller
public class CancelLeaveAction extends ActionSupport
{
    @Resource
    private Leave_InfoService leave_infoService;

    private int id;

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
        leave_infoService.cancelLeave(id);
        return SUCCESS;
    }
}
