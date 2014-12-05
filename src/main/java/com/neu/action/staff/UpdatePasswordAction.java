package com.neu.action.staff;

import com.neu.common.Constant;
import com.neu.pojo.Staff_Job;
import com.neu.service.Staff_JobService;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import org.springframework.stereotype.Controller;

import javax.annotation.Resource;

@Controller
public class UpdatePasswordAction extends ActionSupport
{
    private String password;
    private String newPassword;
    private String rePassword;

    @Resource
    private Staff_JobService staff_jobService;

    public String getPassword()
    {
        return password;
    }

    public void setPassword(String password)
    {
        this.password = password;
    }

    public String getNewPassword()
    {
        return newPassword;
    }

    public void setNewPassword(String newPassword)
    {
        this.newPassword = newPassword;
    }

    public String getRePassword()
    {
        return rePassword;
    }

    public void setRePassword(String rePassword)
    {
        this.rePassword = rePassword;
    }

    @Override
    public String execute() throws Exception
    {
        Staff_Job staff_job = (Staff_Job)ActionContext.getContext().getSession().get(Constant.STAFF_LOGIN);
        if(staff_jobService.updatePassword(staff_job.getStaff_id(),password,newPassword))
        {
            return SUCCESS;
        }
        else
        {
            return INPUT;
        }

    }
}
