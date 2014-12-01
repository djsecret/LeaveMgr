package com.neu.action;

import com.neu.pojo.User;
import com.neu.service.UserService;
import com.opensymphony.xwork2.ActionSupport;
import org.springframework.stereotype.Controller;

import javax.annotation.Resource;
import java.util.Date;

/**
 * Created by ubuntu on 14-10-4.
 */
@Controller("loginAction")
public class LoginAction extends ActionSupport
{
    private String username;
    private String password;

    @Resource
    private UserService userService;

    public String execute()
    {
        System.out.println(username);
        User user = new User();
        user.setUsername(username);
        user.setPassword(password);
        if(userService.login(user))
        {
            return SUCCESS;
        }
        return INPUT;

    }

    public String getUsername()
    {
        return username;
    }

    public void setUsername(String username)
    {
        this.username = username;
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
