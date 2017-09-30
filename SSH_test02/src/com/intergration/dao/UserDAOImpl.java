package com.intergration.dao;

import com.intergration.entity.User;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.orm.hibernate4.HibernateTemplate;
import org.springframework.orm.hibernate4.support.HibernateDaoSupport;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by yang on 2017/9/26.
 */
public class UserDAOImpl implements UserDAO {

    private SessionFactory sessionFactory;

    @Resource
    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
        System.out.println("sessionFactory in UserDAOImpl class is created...");
    }


//    private HibernateTemplate hibernateTemplate = null;
//    @Resource
//    public void setHibernateTemplate(){
//        this.hibernateTemplate = hibernateTemplate;
//    }

//    private HibernateTemplate getHibernateTemplate(){
//        if(hibernateTemplate == null)
//            hibernateTemplate = new HibernateTemplate(sessionFactory);
//        return hibernateTemplate;
//    }

    @Override
    public void save(User user) {
        Session session = sessionFactory.openSession();
        session.save(user);
    }

    @Override
    public User get(String name) {
        Session session = sessionFactory.openSession();
        String hql = "from User u where u.name='"+name+"'";
        Query query = session.createQuery(hql);
        User user = (User)query.list().get(0);
        return user;
    }

    @Override
    public void delete(int id) {
        Session session = sessionFactory.openSession();
        session.delete(findById(id));
    }

    @Override
    public void update(User user) {
        Session session = sessionFactory.openSession();
        session.update(user);
    }

    @Override
    public User findById(int id) {
        Session session = sessionFactory.openSession();
        User user = (User)session.get(User.class,id);
        return user;
    }

    @Override
    public List<User> findAll() {
        Session session = sessionFactory.openSession();
//        String hql = "from user";
        String hql = "from User";
        Query query = session.createQuery(hql);
        System.out.println("log:it is time to search all User in the database");
        List<User> list = (List<User>)query.list();
        System.out.println("log:this is UserDAOImpl executed findAll method,userList.length="+list.size());
        return list;
    }
}
