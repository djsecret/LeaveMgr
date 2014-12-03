package com.neu.pojo;

import java.io.Serializable;
import java.util.Date;


public class Leave_Info implements Serializable
{
    private int id;
    private Date begin_time;
    private int days;
    private Date apply_time;
    private String reason;
    private int result;
    private Date handle_time;
    private int valid;

    private int proposer_id;
    private String proposer_name;
    private int auditor_id;
    private String auditor_name;

    public int getId()
    {
        return id;
    }

    public void setId(int id)
    {
        this.id = id;
    }

    public Date getBegin_time()
    {
        return begin_time;
    }

    public void setBegin_time(Date begin_time)
    {
        this.begin_time = begin_time;
    }

    public int getDays()
    {
        return days;
    }

    public void setDays(int days)
    {
        this.days = days;
    }

    public Date getApply_time()
    {
        return apply_time;
    }

    public void setApply_time(Date apply_time)
    {
        this.apply_time = apply_time;
    }

    public String getReason()
    {
        return reason;
    }

    public void setReason(String reason)
    {
        this.reason = reason;
    }

    public int getProposer_id()
    {
        return proposer_id;
    }

    public void setProposer_id(int proposer_id)
    {
        this.proposer_id = proposer_id;
    }

    public String getProposer_name()
    {
        return proposer_name;
    }

    public void setProposer_name(String proposer_name)
    {
        this.proposer_name = proposer_name;
    }

    public int getAuditor_id()
    {
        return auditor_id;
    }

    public void setAuditor_id(int auditor_id)
    {
        this.auditor_id = auditor_id;
    }

    public String getAuditor_name()
    {
        return auditor_name;
    }

    public void setAuditor_name(String auditor_name)
    {
        this.auditor_name = auditor_name;
    }

    public int getResult()
    {
        return result;
    }

    public void setResult(int result)
    {
        this.result = result;
    }

    public Date getHandle_time()
    {
        return handle_time;
    }

    public void setHandle_time(Date handle_time)
    {
        this.handle_time = handle_time;
    }

    public int getValid()
    {
        return valid;
    }

    public void setValid(int valid)
    {
        this.valid = valid;
    }

    @Override
    public String toString()
    {
        return "Leave_Info{" +
                "id=" + id +
                ", begin_time=" + begin_time +
                ", days=" + days +
                ", apply_time=" + apply_time +
                ", reason='" + reason + '\'' +
                ", result=" + result +
                ", handle_time=" + handle_time +
                ", valid=" + valid +
                ", proposer_id=" + proposer_id +
                ", proposer_name='" + proposer_name + '\'' +
                ", auditor_id=" + auditor_id +
                ", auditor_name='" + auditor_name + '\'' +
                '}';
    }
}
