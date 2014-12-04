package com.neu.dao;


import com.neu.pojo.Leave_Info;

public interface Leave_InfoDAO
{
    void addLeave_Info(Leave_Info leave_info);
    Leave_Info getLeave_InfoById(int id);
    void updateLeave_Info(Leave_Info leave_info);
}
