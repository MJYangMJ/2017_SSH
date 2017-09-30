package com.intergration.dao;

import com.intergration.entity.User;
import org.hibernate.SessionFactory;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by yang on 2017/9/26.
 */
public interface UserDAO {

    void save(User user);
    User get(String name);
    void delete(int id);
    void update(User user);
    User findById(int id);
    List<User> findAll();

}
