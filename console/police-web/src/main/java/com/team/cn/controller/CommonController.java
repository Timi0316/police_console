package com.team.cn.controller;

import com.team.cn.service.FileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by pein on 2016/3/27.
 */
@Controller
@RequestMapping("/common")
public class CommonController {

    @Autowired
    private FileService fileService;

    @RequestMapping(value = "/preview_image")
    public void dynamic_image(String imageUrl,HttpServletResponse response, HttpServletRequest request) throws IOException {
        response.setContentType("image/jpeg");
        response.getOutputStream().write(fileService.get(imageUrl));
    }

}
