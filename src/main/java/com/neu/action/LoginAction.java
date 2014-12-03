package com.neu.action;

import com.neu.pojo.Staff_Job;
import com.neu.service.Staff_JobService;
import com.opensymphony.xwork2.ActionSupport;
import org.springframework.stereotype.Controller;

import javax.annotation.Resource;

@Controller("loginAction")
public class LoginAction extends ActionSupport
{
    private String staff_id;
    private String password;

    @Resource
    private Staff_JobService staff_jobService;

    public String execute()
    {
        System.out.println(staff_id);
        Staff_Job staff_job = new Staff_Job();
        staff_job.setStaff_id(staff_id);
        staff_job.setPassword(password);
        if(staff_jobService.login(staff_job))
        {

            return SUCCESS;
        }
        return INPUT;

    }

    public String getStaff_id()
    {
        return staff_id;
    }

    public void setStaff_id(String staff_id)
    {
        this.staff_id = staff_id;
    }

    public String getPassword()
    {
        return password;
    }

    public void setPassword(String password)
    {
        this.password = password;
    }

}
