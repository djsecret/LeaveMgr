package com.neu.pojo;

import java.io.Serializable;
import java.util.Date;

public class Message implements Serializable
{
    private int id;
    private String sender_name;
    private Date generate_time;
    private String message_name;
    private int type;
    private String content;
    private int flag;
    private Staff_Job staff_job;//many to one

    public Staff_Job getStaff_job()
    {
        return staff_job;
    }

    public void setStaff_job(Staff_Job staff_job)
    {
        this.staff_job = staff_job;
    }

    public int getId()
    {
        return id;
    }

    public void setId(int id)
    {
        this.id = id;
    }

    public String getSender_name()
    {
        return sender_name;
    }

    public void setSender_name(String sender_name)
    {
        this.sender_name = sender_name;
    }

    public Date getGenerate_time()
    {
        return generate_time;
    }

    public void setGenerate_time(Date generate_time)
    {
        this.generate_time = generate_time;
    }

    public String getMessage_name()
    {
        return message_name;
    }

    public void setMessage_name(String message_name)
    {
        this.message_name = message_name;
    }

    public int getType()
    {
        return type;
    }

    public void setType(int type)
    {
        this.type = type;
    }

    public String getContent()
    {
        return content;
    }

    public void setContent(String content)
    {
        this.content = content;
    }

    public int getFlag()
    {
        return flag;
    }

    public void setFlag(int flag)
    {
        this.flag = flag;
    }
}
