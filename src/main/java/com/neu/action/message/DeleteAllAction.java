package com.neu.action.message;

import com.neu.service.MessageService;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import org.springframework.stereotype.Controller;

import javax.annotation.Resource;

@Controller
public class DeleteAllAction extends ActionSupport
{
    @Resource
    private MessageService messageService;

    @Override
    public String execute() throws Exception
    {
        String[] idstr = (String[])ActionContext.getContext().getParameters().get("ids");
        String[] splits = idstr[0].split(",");
        Integer[] ids = new Integer[splits.length];
        for(int i = 0; i < splits.length; ++i)
        {
            System.out.println("string:" + splits[i].trim());
            ids[i] = Integer.parseInt(splits[i].trim());
        }

        messageService.batchDelete(ids);
        return SUCCESS;
    }
}
