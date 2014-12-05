package com.neu.action.leave;

import com.neu.common.Constant;
import com.neu.pojo.Leave_Info;
import com.neu.pojo.Staff_Job;
import com.neu.service.Leave_InfoService;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import org.springframework.stereotype.Controller;

import javax.annotation.Resource;
import java.util.List;

@Controller
public class ShowLeaveAction extends ActionSupport
{

    @Resource
    private Leave_InfoService leave_infoService;

    private List<Leave_Info> leave_infos;

    public List<Leave_Info> getLeave_infos()
    {
        return leave_infos;
    }

    public void setLeave_infos(List<Leave_Info> leave_infos)
    {
        this.leave_infos = leave_infos;
    }

    @Override
    public String execute() throws Exception
    {
        Staff_Job staff_job = (Staff_Job)ActionContext.getContext().getSession().get(Constant.STAFF_LOGIN);
        leave_infos = leave_infoService.getLeave_InfoList(staff_job.getId());
        return SUCCESS;
    }
}
