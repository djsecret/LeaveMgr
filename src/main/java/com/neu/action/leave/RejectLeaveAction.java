package com.neu.action.leave;

import com.neu.pojo.Leave_Info;
import com.neu.service.Leave_InfoService;
import com.opensymphony.xwork2.ActionSupport;
import org.springframework.stereotype.Controller;

import javax.annotation.Resource;

@Controller
public class RejectLeaveAction extends ActionSupport
{
    private Leave_Info leave_info;

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

    @Override
    public String execute() throws Exception
    {
        leave_info = leave_infoService.rejectLeave(leave_info);
        return SUCCESS;
    }
}
