package com.intergration.service;

import com.intergration.entity.User;

import java.util.List;

/**
 * Created by yang on 2017/9/26.
 */
public interface UserService {

    void saveUser(User user);
    User getUser(String name);
    void deleteUser(int id);
    void updateUser(User user);
    User findUserById(int id);
    List<User> findAllUser();

}
