package com.neu.service.impl;

import com.neu.dao.Staff_InfoDAO;
import com.neu.pojo.Staff_Info;
import com.neu.service.Staff_InfoService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;

@Service("staff_InfoService")
public class Staff_InfoServiceImpl implements Staff_InfoService
{
    @Resource
    private Staff_InfoDAO staff_infoDAO;

    @Override
    @Transactional(propagation = Propagation.SUPPORTS,readOnly = true)
    public Staff_Info getStaff_InfoById(int id)
    {
        return staff_infoDAO.getStaff_InfoById(id);
    }

    @Override
    @Transactional(propagation = Propagation.SUPPORTS)
    public void updateStaff_Info(Staff_Info staff_info)
    {
        staff_infoDAO.update(staff_info);
    }
}
