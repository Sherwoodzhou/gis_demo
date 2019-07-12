package com.glodon.controller;

import com.glodon.Bean.BO.GisModle;
import com.glodon.Bean.MobileEvents;
import com.glodon.service.InquiryEventsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
public class InquiryController {

    @Autowired
    private InquiryEventsService inqueryMobileEventsDir;

    @RequestMapping("/inquiry")
    @ResponseBody
    public ModelAndView inquiry() {
        List<GisModle> dir = inqueryMobileEventsDir.inquiryDir();
        for (GisModle gisModle:dir){
            System.out.println(gisModle);
        }
        ModelAndView mv = new ModelAndView();
        mv.setViewName("gis");
        mv.addObject("heatmapData", dir);
        return mv;
    }
}
