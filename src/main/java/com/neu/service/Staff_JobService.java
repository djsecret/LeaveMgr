package com.neu.service;


import com.neu.pojo.Staff_Job;

public interface Staff_JobService
{
    boolean login(Staff_Job staff_job);

    boolean updatePassword(String staff_id, String password, String newPassword);
}
