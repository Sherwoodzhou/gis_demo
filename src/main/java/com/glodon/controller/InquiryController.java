package com.glodon.controller;

import com.glodon.bean.BO.CityGisModel;
import com.glodon.bean.BO.GisModel;
import com.glodon.service.DynamicService;
import com.glodon.service.InquiryHouseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.HashMap;
import java.util.List;

@Controller
@RequestMapping("/inquiry")
public class InquiryController {

    @Autowired
    private InquiryHouseService inquiryHouseService;
    @Autowired
    private DynamicService dynamicService;

    /**
     * 查询文件，并返回热力图
     *
     * @return
     */
    @RequestMapping("info_overview")
    @ResponseBody
    public ModelAndView inquiryHeatMap() {
/*        List<GisModel> dir = inquiryHouseService.inquiryDir();
        for (GisModel gisModel : dir) {
            System.out.println(gisModel);
        }*/
        ModelAndView mv = new ModelAndView();
        mv.setViewName("mGis/info_overview");
        //mv.addObject("heatmapData", dir);
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
        ModelAndView mv = new ModelAndView();
        mv.setViewName("mGis/gridlayer");
        return mv;
    }

    /**
     * loca柱状图
     *
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
     *
     * @return
     */
    @RequestMapping(value = "flyline")
    @ResponseBody
    public ModelAndView inquiryFlyLine() {
        ModelAndView mv = new ModelAndView();
        mv.setViewName("mGis/flylinemap");
        return mv;
    }

    /**
     * 气泡图
     *
     * @return
     */
    @RequestMapping(value = "archValue")
    @ResponseBody
    public ModelAndView inquiryPaoMap() {
        ModelAndView mv = new ModelAndView();
        mv.setViewName("mGis/archValue");
        return mv;
    }

    /**
     * 企业分析
     *
     * @return
     */
    @RequestMapping(value = "capanalysis")
    @ResponseBody
    public ModelAndView inquiryCapAna() {
        List<GisModel> dir = inquiryHouseService.inquiryDir();
        ModelAndView mv = new ModelAndView();
        mv.setViewName("mGis/capanalysis");
        mv.addObject("heatmapData", dir);
        return mv;
    }

    /**
     * 两房分析
     *
     * @return
     */
    @RequestMapping(value = "house")
    @ResponseBody
    public ModelAndView inquiryHouse() {
        ModelAndView mv = new ModelAndView();
        mv.setViewName("mGis/house");
        return mv;
    }

    /**
     * 从业人员分析
     *
     * @return
     */
    @RequestMapping(value = "employee")
    @ResponseBody
    public ModelAndView inquiryEmployee() {
        ModelAndView mv = new ModelAndView();
        mv.setViewName("mGis/employee");
        return mv;
    }

    /**
     * 动态传参,使用map传递参数
     *
     * @return
     */
    @RequestMapping(value = "dynamic")
    @ResponseBody
    public List<HashMap<String, Object>> selectForMap(@RequestParam("column") String column, @RequestParam("table") String table) {
        System.out.println(column);
        List<HashMap<String, Object>> dir = dynamicService.selectForMap(column, table);
        return dir;
    }
}
