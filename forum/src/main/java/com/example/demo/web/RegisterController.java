package com.example.demo.web;

import com.example.demo.domain.User;
import com.example.demo.service.imp.UserServiceImp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.xml.ws.Action;
import java.util.Date;

/**
 * @ClassName RegisterController
 * @Description TODO
 * @Auther ydc
 * @Date 2019/1/11 15:30
 * @Version 1.0
 **/
@RestController
public class RegisterController  extends  BaseController{
    private UserServiceImp userServiceImp;

    @Autowired
    public void setUserServiceImp(UserServiceImp userServiceImp) {
        this.userServiceImp = userServiceImp;
    }

    @RequestMapping("/register")
    public ModelAndView register(HttpServletRequest request, User user){
        User dbUser = userServiceImp.getUserByName(user.getUserName());
        ModelAndView mv = new ModelAndView();

        mv.setViewName("register");
        if(dbUser!=null){
            mv.addObject("errorMsg","该用户已存在，请更换用户名");
        }
        else{
            user.setLastIp(request.getRemoteAddr());
            user.setLastVisit(new Date());
            user.setCredits(5);
            user.setUser_type(0);
            user.setPhoto(" ");//先设定一个默认的头像

            userServiceImp.saveUser(user);

            mv.addObject("success","注册成功，即将前往登录页面");
            mv.setViewName("login");

        }
        return  mv;
    }
}
