package com.example.demo.web;

import com.example.demo.domain.User;
import com.example.demo.domain.bean.SetPassword;
import com.example.demo.service.imp.UserServiceImp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;

/**
 * @ClassName UserSetController
 * @Description 用户信息设置
 * @Auther ydc
 * @Date 2019/1/11 18:19
 * @Version 1.0
 **/
@RestController
public class UserSetController  extends BaseController{
    private UserServiceImp userServiceImp;

    @Autowired
    public void setUserServiceImp(UserServiceImp userServiceImp) {
        this.userServiceImp = userServiceImp;
    }

    @RequestMapping("/userSetPassword")
    public ModelAndView userInformationSet(HttpServletRequest request, SetPassword setPassword){
        User user = getSessionUser(request);
        ModelAndView mv = new ModelAndView();
        mv.setViewName("user");
        if(user.getPassword().equals(setPassword.getOldPassword())){
            user.setPassword(setPassword.getNewPassword());
            userServiceImp.resetPassword(setPassword.getNewPassword(),user.getUserId());
            mv.addObject("success","修改密码成功");
        }
        else{
            mv.addObject("errorMsg","原密码不正确");
        }
        return mv;
    }
}
