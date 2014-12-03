package com.neu.action;

import com.neu.pojo.Leave_Info;
import com.opensymphony.xwork2.ActionSupport;
import org.springframework.stereotype.Controller;

@Controller
public class AddLeaveAction extends ActionSupport
{
    private Leave_Info leave_info;

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


        return SUCCESS;
    }
}
