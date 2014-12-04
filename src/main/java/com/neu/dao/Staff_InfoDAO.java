package com.neu.dao;


import com.neu.pojo.Staff_Info;

public interface Staff_InfoDAO
{
    Staff_Info getStaff_InfoById(int id);

    void update(Staff_Info staff_info);
}
