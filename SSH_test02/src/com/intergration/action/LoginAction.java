package com.intergration.action;

import com.intergration.entity.User;
import com.intergration.service.UserService;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;
import org.hibernate.sql.ordering.antlr.GeneratedOrderByLexer;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * Created by yang on 2017/9/26.
 */
public class LoginAction extends ActionSupport implements ModelDriven<User>{

    private User globalUser = new User();
    @Override
    public User getModel() {
        return globalUser;
    }

    private UserService userService;

    public void setUserService(UserService userService){
        System.out.println("IoC injection.Create a userService object which had registered in .xml file.");
        this.userService = userService;
    }

    /**
     * login implement method
     * @return
     */

    public String login(){

        System.out.println("loginAction is executing!");
        List<User> userList = null;

        System.out.println("Get:username:"+globalUser.getName()+
                            " password:"+globalUser.getPassword()+" type:"+globalUser.getType());

//        userList = (List<User>) userService.findAllUser();
//
//        User user = null;
//        Iterator<User> it = userList.iterator();
//        while(it.hasNext()){
//            user = it.next();
//            if(globalUser.getName().trim().equals(user.getName())&&
//                    globalUser.getPassword().trim().equals(user.getPassword())&&
//                    globalUser.getType().trim().equals(user.getType())){
//                return "LOGINSUCCESS";
//            }
//            else return "LOGINFAILED";
//        }

//        User user = (User)userService.findUserById(1);
//        if(user.getName().equals(globalUser.getName()))
//            return "LOGINSUCCESS";
//        else

//        User user = (User)userService.getUser("Yang");
//        if(user.getName().equals(globalUser.getName()))
//            return "LOGINSUCCESS";
//        else

        userService.saveUser(globalUser);
        User user = (User)userService.findUserById(2);
        if(user.getName().equals(globalUser.getName()))
            return "LOGINSUCCESS";
        else
        return "LOGINFAILED";
    }
}
