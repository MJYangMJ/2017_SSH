package com.intergration.service;

import com.intergration.dao.UserDAO;
import com.intergration.entity.User;
import org.hibernate.SessionFactory;
import org.springframework.orm.hibernate4.HibernateTemplate;
import org.springframework.orm.hibernate4.support.HibernateDaoSupport;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by yang on 2017/9/26.
 */
public class UserServiceImpl  implements UserService {

//    private SessionFactory sessionFactory;
//    @Resource
//    public void setSessionFactory(SessionFactory sessionFactory) {
//        System.out.println("sessionFactory in UserServiceImpl class is created...");
//        this.sessionFactory = sessionFactory;
//    }

    private UserDAO userDAO;
    public void setUserDAO(UserDAO userDAO){
        System.out.println("IoC injection.Create a userDAO object which had registered in .xml file.");
        this.userDAO = userDAO;
    }
    @Override
    public void saveUser(User user) {
        if(userDAO.findById(user.getId())==null){
            userDAO.save(user);
        }
    }

    @Override
    public User getUser(String name) {
        return userDAO.get(name);
    }

    @Override
    public void deleteUser(int id) {
        if(userDAO.findById(id)!=null){
            userDAO.delete(id);
        }
    }

    @Override
    public void updateUser(User user) {
        if(userDAO.findById(user.getId())!=null){
            userDAO.update(user);
        }
    }

    @Override
    public User findUserById(int id) {
        return userDAO.findById(id);
    }

    @Override
    public List<User> findAllUser() {
        System.out.println("log:userServiceImpl.findAllUser is executed!");
        return userDAO.findAll();
    }
}
