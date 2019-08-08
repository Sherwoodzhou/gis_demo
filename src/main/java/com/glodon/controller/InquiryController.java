package com.glodon.controller;

import com.glodon.bean.BO.CityGisModel;
import com.glodon.bean.BO.GisModel;
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
      *
     * @return
     */
    @RequestMapping("heatmap")
    @ResponseBody
    public ModelAndView inquiryHeatMap() {
        List<GisModel> dir = inquiryHouseService.inquiryDir();
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
     *
     * @return
     */
    @RequestMapping(value = "gridlayer")
    @ResponseBody
    public ModelAndView inquiryGridLayer() {
/*        List<GisModel> dir = inquiryHouseService.   inquiryDir();
        for (GisModel gisModle : dir) {
            System.out.println(gisModle);
        }*/
        ModelAndView mv = new ModelAndView();
        mv.setViewName("mGis/gridlayer");
        return mv;
    }

    /**
     * loca柱状图
     * @return
     */
    @RequestMapping(value = "loca")
    @ResponseBody
    public ModelAndView inquiryLoca() {
        List<CityGisModel> dir = inquiryHouseService.inquiryCityDir();
        for (CityGisModel gisModle : dir) {
            System.out.println(gisModle);
        }
        ModelAndView mv = new ModelAndView();
        mv.setViewName("mGis/loca");
        mv.addObject("heatmapData", dir);
        return mv;
    }

    /**
     * 飞线图
     * @return
     */
    @RequestMapping(value = "flyline")
    @ResponseBody
    public ModelAndView inquiryFlyLine() {
/*        List<CityGisModel> dir = inquiryHouseService.inquiryCityDir();
        for (CityGisModel gisModle : dir) {
            System.out.println(gisModle);
        }*/
        ModelAndView mv = new ModelAndView();
        mv.setViewName("mGis/flylinemap");
        //mv.addObject("heatmapData", dir);
        return mv;
    }

    /**
     * 气泡图
     * @return
     */
    @RequestMapping(value = "paomap")
    @ResponseBody
    public ModelAndView inquiryPaoMap() {
/*        List<CityGisModel> dir = inquiryHouseService.inquiryCityDir();
        for (CityGisModel gisModle : dir) {
            System.out.println(gisModle);
        }*/
        ModelAndView mv = new ModelAndView();
        mv.setViewName("mGis/paomap");
        //mv.addObject("heatmapData", dir);
        return mv;
    }

}
