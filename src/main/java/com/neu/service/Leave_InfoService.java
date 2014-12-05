package com.neu.service;


import com.neu.pojo.Leave_Info;

import java.util.List;

public interface Leave_InfoService
{
    void addLeave_Info(Leave_Info leave_info);

    Leave_Info getLeave_Info(int id);

    Leave_Info allowLeave(Leave_Info leave_info);

    Leave_Info rejectLeave(Leave_Info leave_info);

    List<Leave_Info> getLeave_InfoList(int proposer_id);

    void resumptionFromLeave(int id);

    Leave_Info archiveLeave(Leave_Info leave_info);
}
