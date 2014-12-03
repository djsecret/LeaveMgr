package com.neu.dao;


import com.neu.pojo.Staff_Job;

public interface Staff_JobDAO
{
    Staff_Job getStaff_JobByStaff_id(String staff_id);
    Staff_Job getGeneral_Manager();
    Staff_Job getManagerByDept_name(String dept_name);
}
