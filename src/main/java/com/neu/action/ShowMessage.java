package com.neu.action;

import com.opensymphony.xwork2.ActionSupport;
import org.springframework.stereotype.Controller;

@Controller
public class ShowMessage extends ActionSupport
{
    @Override
    public String execute() throws Exception
    {
        return SUCCESS;
    }
}
