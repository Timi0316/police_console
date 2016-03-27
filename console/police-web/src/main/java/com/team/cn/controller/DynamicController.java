package com.team.cn.controller;

import com.team.cn.domain.Dynamic;
import com.team.cn.service.DynamicService;
import com.team.cn.utils.ConsoleUtils;
import com.team.cn.vo.BaseVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import java.io.Console;
import java.io.IOException;
import java.util.List;

/**
 * Created by pein on 2016/3/19.
 */
@Controller
@RequestMapping("/dynamic")
public class DynamicController {

    @Autowired
    private DynamicService dynamicService;

    @RequestMapping(value = "/find",method = RequestMethod.GET)
    public ModelAndView find(ModelMap map) {
        int size = dynamicService.selectDynamicSize(null, null, 10);
        List<Dynamic> dynamicList =  dynamicService.selectDynamicByPage(null, null, 1, 10);
        map.addAttribute("size", size);
        map.addAttribute("dynamicList", dynamicList);
        return new ModelAndView("/dynamic/dynamic_index", map);
    }

    @RequestMapping(value = "/add", method = RequestMethod.GET)
     public String add() {
        return "/dynamic/dynamic_add";
    }

    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public ModelAndView addDynamic(BaseVo baseVo,ModelMap map) {
        return new ModelAndView("/dynamic/index", map);
    }

    @RequestMapping(value = "/add_next", method = RequestMethod.POST)
    public ModelAndView addDynamicNext(BaseVo baseVo, ModelMap map) {
        map.addAttribute("dynamic", baseVo);
        return new ModelAndView("/dynamic/dynamic_add_next", map);
    }

    @RequestMapping(value = "/dynamic_add_submit", method = RequestMethod.POST)
    public String addDynamicSubmit(BaseVo baseVo, MultipartFile imageFile) throws IOException {
        dynamicService.addDynamic(ConsoleUtils.copySameProperties(baseVo,Dynamic.class),imageFile);
        return ("redirect:/dynamic/find.htm");
    }


    @RequestMapping(value = "/edit")
    public ModelAndView edit(String id,ModelMap map) {
        Dynamic dynamic = dynamicService.selectDynamicById(id);
        map.addAttribute("dynamic", dynamic);
        return new ModelAndView("/dynamic/dynamic_edit", map);
    }

    @RequestMapping(value = "/edit",method = RequestMethod.POST)
    public ModelAndView editDynamic(String id,ModelMap map) {
        Dynamic dynamic = dynamicService.selectDynamicById(id);
        map.addAttribute("dynamic", dynamic);
        return new ModelAndView("/dynamic/dynamic_edit_next", map);
    }

    @RequestMapping(value = "/dynamic_edit_submit", method = RequestMethod.POST)
    public String editDynamicSubmit(BaseVo baseVo, MultipartFile imageFile) throws IOException {
        dynamicService.editDynamic(ConsoleUtils.copySameProperties(baseVo, Dynamic.class), imageFile);
        return ("redirect:/dynamic/find.htm");
    }

    @RequestMapping(value = "/delete")
    public String delete(String id) {
        dynamicService.deleteDynamicById(id);
        return ("redirect:/dynamic/find.htm");
    }

    @RequestMapping(value = "/preview")
    public ModelAndView previewDynamic(String id, ModelMap map) {
        Dynamic dynamic =  dynamicService.selectDynamicById(id);
        map.addAttribute("dynamic", dynamic);
        return new ModelAndView("/dynamic/dynamic_preview",map);
    }

}
