package com.neu.dao;


import com.neu.pojo.Leave_Info;

import java.util.List;

public interface Leave_InfoDAO
{
    void addLeave_Info(Leave_Info leave_info);
    Leave_Info getLeave_InfoById(int id);
    void updateLeave_Info(Leave_Info leave_info);
    List<Leave_Info> getLeave_InfosByProposer_Id(int proposer_id);

    void delete(Leave_Info leave_info);
}
