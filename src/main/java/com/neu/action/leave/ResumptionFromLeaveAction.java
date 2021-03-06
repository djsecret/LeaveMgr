package com.neu.action.leave;

import com.neu.service.Leave_InfoService;
import com.opensymphony.xwork2.ActionSupport;
import org.springframework.stereotype.Controller;

import javax.annotation.Resource;

@Controller
public class ResumptionFromLeaveAction extends ActionSupport
{
    private int id;

    @Resource
    private Leave_InfoService leave_infoService;

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
        leave_infoService.resumptionFromLeave(id);
        return SUCCESS;
    }
}
