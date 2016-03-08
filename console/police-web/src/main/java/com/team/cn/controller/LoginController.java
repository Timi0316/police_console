package com.team.cn.controller;


import com.team.cn.service.LoginService;
import com.team.cn.vo.UserVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

/**
 * Created by pein on 2016/3/1.
 */
@Controller
@RequestMapping()
public class LoginController {

    @Autowired
    private LoginService loginService;

    @RequestMapping(value = "/login")
    public String toLogin() {

        return "/login/login";
    }

    @RequestMapping(value = "/index")
    public ModelAndView login(UserVo userVo, ModelMap map) {
        map.addAttribute("user", loginService.login(userVo.getName(),userVo.getPassword()));
        return new ModelAndView("/admin/index", map);
    }
}
