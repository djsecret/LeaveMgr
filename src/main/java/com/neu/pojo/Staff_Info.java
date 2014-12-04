package com.neu.pojo;

import java.io.Serializable;
import java.util.Date;

public class Staff_Info implements Serializable
{
    private int id;
    private String staff_id;
    private String staff_name;
    private String identity_card;
    private String gender;
    private Date entry_date;
    private String education;
    private String address;
    private String tel;
    private String email;

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

    public String getIdentity_card()
    {
        return identity_card;
    }

    public void setIdentity_card(String identity_card)
    {
        this.identity_card = identity_card;
    }

    public String getGender()
    {
        return gender;
    }

    public void setGender(String gender)
    {
        this.gender = gender;
    }

    public Date getEntry_date()
    {
        return entry_date;
    }

    public void setEntry_date(Date entry_date)
    {
        this.entry_date = entry_date;
    }

    public String getEducation()
    {
        return education;
    }

    public void setEducation(String education)
    {
        this.education = education;
    }

    public String getAddress()
    {
        return address;
    }

    public void setAddress(String address)
    {
        this.address = address;
    }

    public String getTel()
    {
        return tel;
    }

    public void setTel(String tel)
    {
        this.tel = tel;
    }

    public String getEmail()
    {
        return email;
    }

    public void setEmail(String email)
    {
        this.email = email;
    }
}
