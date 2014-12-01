package com.neu.dao;

import com.neu.pojo.User;

import java.util.List;

/**
 * Created by ubuntu on 14-10-30.
 */
public interface UserDAO
{
    User getUserById(int id);
    List<User> getUsersByName(String username);
    void addUser(User user);
}
