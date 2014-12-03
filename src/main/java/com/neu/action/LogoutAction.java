package com.neu.action;

import com.neu.common.Constant;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import org.springframework.stereotype.Controller;

@Controller
public class LogoutAction extends ActionSupport
{
    @Override
    public String execute() throws Exception
    {
        ActionContext.getContext().getSession().remove(Constant.STAFF_LOGIN);

        return SUCCESS;
    }
}
