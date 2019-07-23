package com.glodon.controller;

import com.glodon.Bean.BO.GisModel;
import com.glodon.service.InquiryHouseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
@RequestMapping("/inquiry")
public class InquiryController {

    @Autowired
    private InquiryHouseService inquiryHouseService;

    /**
     * 查询文件，并返回热力图
     * @return
     */
    @RequestMapping("heatmap")
    @ResponseBody
    public ModelAndView inquiryHeatMap() {
        List<GisModel> dir = inquiryHouseService.   inquiryDir();
        for (GisModel gisModel : dir) {
            System.out.println(gisModel);
        }
        ModelAndView mv = new ModelAndView();
        mv.setViewName("mGis/heatmap");
        mv.addObject("heatmapData", dir);
        return mv;
    }

    /**
     * 查询文件，并返回柱状图
     * @return
     */
    @RequestMapping("gridlayer")
    @ResponseBody
    public ModelAndView inquiryGridLayer() {
/*        List<GisModel> dir = inquiryHouseService.   inquiryDir();
        for (GisModel gisModle : dir) {
            System.out.println(gisModle);
        }*/
        ModelAndView mv = new ModelAndView();
        mv.setViewName("mGis/gridlayer.html");
        return mv;
    }
}
