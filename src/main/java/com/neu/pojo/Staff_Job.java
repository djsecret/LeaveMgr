package com.neu.pojo;


public class Staff_Job
{
    private int id;
    private String staff_id;
    private String staff_name;
    private String password;
    private String dept_name;
    private String duty_name;

    public int getId()
    {
        return id;
    }

    public void setId(int id)
    {
        this.id = id;
    }

    public String getStaff_id()
    {
        return staff_id;
    }

    public void setStaff_id(String staff_id)
    {
        this.staff_id = staff_id;
    }

    public String getStaff_name()
    {
        return staff_name;
    }

    public void setStaff_name(String staff_name)
    {
        this.staff_name = staff_name;
    }

    public String getPassword()
    {
        return password;
    }

    public void setPassword(String password)
    {
        this.password = password;
    }

    public String getDept_name()
    {
        return dept_name;
    }

    public void setDept_name(String dept_name)
    {
        this.dept_name = dept_name;
    }

    public String getDuty_name()
    {
        return duty_name;
    }

    public void setDuty_name(String duty_name)
    {
        this.duty_name = duty_name;
    }
}
