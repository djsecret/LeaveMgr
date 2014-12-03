package com.neu.action;

import com.opensymphony.xwork2.ActionSupport;
import org.springframework.stereotype.Controller;

@Controller
public class DeleteMessage extends ActionSupport
{
    private int id;

    public int getId()
    {
        return id;
    }

    public void setId(int id)
    {
        this.id = id;
    }

    @Override
    public String execute() throws Exception
    {
        System.out.println(id);
        return SUCCESS;
    }
}
