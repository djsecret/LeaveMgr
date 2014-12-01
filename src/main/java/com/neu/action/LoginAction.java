package com.neu.action;

import org.springframework.stereotype.Component;

import java.util.Date;

/**
 * Created by ubuntu on 14-10-4.
 */
@Component("loginAction")
public class LoginAction
{
    private String username;
    private String passworld;
    private int age;
    private Date date;

    public String getUsername()
    {
        return username;
    }

    public void setUsername(String username)
    {
        this.username = username;
    }

    public String getPassworld()
    {
        return passworld;
    }

    public void setPassworld(String passworld)
    {
        this.passworld = passworld;
    }

    public int getAge()
    {
        return age;
    }

    public void setAge(int age)
    {
        this.age = age;
    }

    public Date getDate()
    {
        return date;
    }

    public void setDate(Date date)
    {
        this.date = date;
    }

    public String execute()
    {
        System.out.println(username);
        return "success";
    }
}
