package com.glodon.controller;

import com.glodon.Bean.BO.GisModle;
import com.glodon.service.InquiryHouseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
public class InquiryController {

    @Autowired
    private InquiryHouseService inquiryHouseService;

    /**
     * 查询文件，并返回热力图
     * @return
     */
    @RequestMapping("/inquiry")

    @ResponseBody
    public ModelAndView inquiry() {
        List<GisModle> dir = inquiryHouseService.   inquiryDir();
        for (GisModle gisModle : dir) {
            System.out.println(gisModle);
        }
        ModelAndView mv = new ModelAndView();
        //mv.setViewName("gis");
        mv.setViewName("mGis/histogram_01.html");

        mv.addObject("heatmapData", dir);
        return mv;
    }
}
