package com.neu.action.staff;

import com.neu.pojo.Staff_Info;
import com.neu.service.Staff_InfoService;
import com.opensymphony.xwork2.ActionSupport;
import org.springframework.stereotype.Controller;

import javax.annotation.Resource;

@Controller
public class EditStaffAction extends ActionSupport
{
    private Staff_Info staff_info;

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

    @Override
    public String execute() throws Exception
    {
        staff_infoService.updateStaff_Info(staff_info);
        return SUCCESS;
    }
}
