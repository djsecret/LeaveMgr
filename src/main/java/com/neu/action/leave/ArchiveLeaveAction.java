package com.neu.action.leave;

import com.neu.common.Constant;
import com.neu.pojo.Leave_Info;
import com.neu.service.Leave_InfoService;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import org.springframework.stereotype.Controller;

import javax.annotation.Resource;
import java.util.Map;

@Controller
public class ArchiveLeaveAction extends ActionSupport
{
    private String token;

    public String getToken()
    {
        return token;
    }

    public void setToken(String token)
    {
        this.token = token;
    }

    @Resource
    private Leave_InfoService leave_infoService;

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
        Map session = ActionContext.getContext().getSession();
        String oldToken = (String)session.get(Constant.ARCHIVE_SESSION_TOKEN);
        if(token != null && token.equals(oldToken))
        {
            session.remove(Constant.ARCHIVE_SESSION_TOKEN);
            leave_info = leave_infoService.archiveLeave(leave_info);

            return SUCCESS;
        }
        else
        {
            return ERROR;
        }
    }
}
