package com.neu.action.staff;

import com.neu.common.Constant;
import com.neu.pojo.Staff_Info;
import com.neu.pojo.Staff_Job;
import com.neu.service.Staff_InfoService;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import org.springframework.stereotype.Controller;

import javax.annotation.Resource;

@Controller
public class ShowStaffAction extends ActionSupport
{
    private Staff_Info staff_info;

    private Staff_Job staff_job;

    @Resource
    private Staff_InfoService staff_infoService;

    public Staff_Info getStaff_info()
    {
        return staff_info;
    }

    public void setStaff_info(Staff_Info staff_info)
    {
        this.staff_info = staff_info;
    }

    public Staff_Job getStaff_job()
    {
        return staff_job;
    }

    public void setStaff_job(Staff_Job staff_job)
    {
        this.staff_job = staff_job;
    }

    @Override
    public String execute() throws Exception
    {
        staff_job = (Staff_Job)ActionContext.getContext().getSession().get(Constant.STAFF_LOGIN);
        staff_info = staff_infoService.getStaff_InfoById(staff_job.getStaff_id());
        return SUCCESS;
    }
}
