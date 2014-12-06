package com.neu.service;

import com.neu.pojo.Staff_Info;

public interface Staff_InfoService
{
    Staff_Info getStaff_InfoById(int id);
    void updateStaff_Info(Staff_Info staff_info);

    Staff_Info getStaff_InfoById(String staff_id);
}
