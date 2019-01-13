package com.example.demo.web;

import com.example.demo.cons.Constantion;
import com.example.demo.domain.User;
import com.example.demo.service.imp.UserServiceImp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import java.util.Date;

/**
 * @ClassName LoginController
 * @Description TODO
 * @Auther ydc
 * @Date 2019/1/10 21:19
 * @Version 1.0
 **/
@RestController
public class LoginController extends BaseController{

    private UserServiceImp userServiceImp;

    @Autowired
    public void setUserServiceImp(UserServiceImp userServiceImp) {
        this.userServiceImp = userServiceImp;
    }

    @RequestMapping("login")
    public ModelAndView login(HttpServletRequest request,User user){
        System.out.println(user.getUserName());
        User dbUser = userServiceImp.getUserByName(user.getUserName());
        System.out.println(dbUser);
        System.out.println("login start");
        ModelAndView mv = new ModelAndView();

        mv.setViewName("login");
        if(dbUser==null){
            System.out.println("1");
            mv.addObject("errorMsg","用户名不存在");
        }
        else if(!dbUser.getPassword().equals(user.getPassword())){
            System.out.println("2");
            mv.addObject("errorMsg","密码错误");
        }

        else if(dbUser.getLocked()==User.user_locked){
            System.out.println("'3");
            mv.addObject("errorMsg","该用户名已被锁定，请等待管理员解锁");
        }
        else{
            System.out.println("'4");
            dbUser.setLastIp(request.getRemoteAddr());
            dbUser.setLastVisit(new Date());
            userServiceImp.loginSuccess(dbUser);
            setSessionUser(request,dbUser);
            String toUrl = (String)request.getSession().getAttribute(Constantion.LOGIN_TO_URL);//记忆化历史浏览记录
            request.getSession().removeAttribute(Constantion.LOGIN_TO_URL);
            if(toUrl==null){
                toUrl = "login";
            }
            mv.setViewName("redirect:"+toUrl);
        }
        System.out.println(mv.getViewName());
        return mv;
    }

    @RequestMapping("index")
    public ModelAndView Index(){
        ModelAndView mv = new ModelAndView();
        mv.setViewName("index");
        mv.addObject("index","hi00000");
        return mv;
    }

    @RequestMapping("loginDo")
    public ModelAndView log(){
        ModelAndView mv = new ModelAndView();
        mv.setViewName("login");
        mv.addObject("index","hi00000");
        return mv;
    }
}
