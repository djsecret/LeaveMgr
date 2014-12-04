package com.neu.service;


import com.neu.pojo.Leave_Info;

public interface Leave_InfoService
{
    void addLeave_Info(Leave_Info leave_info);
    Leave_Info getLeave_Info(int id);
    Leave_Info allowLeave(Leave_Info leave_info);
    Leave_Info rejectLeave(Leave_Info leave_info);
}
