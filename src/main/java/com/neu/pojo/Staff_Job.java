package com.neu.pojo;


import java.io.Serializable;
import java.util.Set;

public class Staff_Job implements Serializable
{
    private int id;
    private String staff_id;
    private String staff_name;
    private String password;
    private String dept_name;
    private int rank;

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

    public int getRank()
    {
        return rank;
    }

    public void setRank(int rank)
    {
        this.rank = rank;
    }

    @Override
    public String toString()
    {
        return "Staff_Job{" +
                "id=" + id +
                ", staff_id='" + staff_id + '\'' +
                ", staff_name='" + staff_name + '\'' +
                ", password='" + password + '\'' +
                ", dept_name='" + dept_name + '\'' +
                ", rank='" + rank + '\'' +
                '}';
    }
}
