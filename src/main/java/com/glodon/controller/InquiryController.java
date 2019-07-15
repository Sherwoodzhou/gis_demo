package com.glodon.controller;

import com.glodon.Bean.BO.GisModle;
import com.glodon.service.InquiryEventsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
public class InquiryController {

    @Autowired
    private InquiryEventsService inqueryMobileEventsDir;

    /**
     * 查询文件，并返回热力图
     * @return
     */
    @RequestMapping("/inquiry")
    @ResponseBody
    public ModelAndView inquiry() {
        List<GisModle> dir = inqueryMobileEventsDir.inquiryDir();
        for (GisModle gisModle : dir) {
            System.out.println(gisModle);
        }
        ModelAndView mv = new ModelAndView();
        mv.setViewName("gis");
        mv.addObject("heatmapData", dir);
        return mv;
    }
}
