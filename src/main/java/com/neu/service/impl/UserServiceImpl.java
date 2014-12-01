package com.neu.service.impl;

import com.neu.dao.UserDAO;
import com.neu.pojo.User;
import com.neu.service.UserService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by ubuntu on 14-10-30.
 */

@Service("userService")
public class UserServiceImpl implements UserService
{
    @Resource(name = "userDAO")
    private UserDAO userDAO;

    @Override
    @Transactional(propagation = Propagation.SUPPORTS,readOnly = true)
    public boolean login(User user)
    {
        if(null != user)
        {
            List<User> users = userDAO.getUsersByName(user.getUsername());

            if(users != null && users.size() > 0)
            {
                return true;
            }
        }

        return false;
    }
}
