package com.team.cn.controller;


import com.team.cn.domain.Dynamic;
import com.team.cn.domain.User;
import com.team.cn.service.DynamicService;
import com.team.cn.service.LoginService;
import com.team.cn.vo.UserVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

/**
 * Created by pein on 2016/3/1.
 */
@Controller
@RequestMapping()
public class LoginController {

    @Value("${page.size}")
    private String pageSize = "10";

    @Autowired
    private LoginService loginService;

    @Autowired
    private DynamicService dynamicService;

    @RequestMapping(value = "/login")
    public String toLogin() {

        return "/login/login";
    }

    /**
     *首页
     * 登录后首屏
     * @param userVo
     * @param map
     * @return
     */
    @RequestMapping(value = "/index")
    public ModelAndView login(UserVo userVo, ModelMap map) {
        User user = loginService.login(userVo.getName(),userVo.getPassword());
        if (user == null) {
            return new ModelAndView("/login/login");
        }
        map.addAttribute("user", user);

        int size = dynamicService.selectDynamicSize(null, null, 10);
        List<Dynamic> dynamicList =  dynamicService.selectDynamicByPage(null, null, 1, 10);
        map.addAttribute("size", size);
        map.addAttribute("dynamicList", dynamicList);
        return new ModelAndView("/dynamic/dynamic_index", map);
    }

}
