package com.glodon.controller;

import org.apache.commons.lang.StringEscapeUtils;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class EventsControllerTest {
    @RequestMapping(value="/test", method = RequestMethod.GET)
    public ModelAndView goUploadImg() {
        //跳转到 templates 目录下的 uploadimg.html
        ModelAndView mv = new ModelAndView();
        String heatmapData = "[{\"lng\": 116.191031,\"lat\": 39.988585,\"count\": 10000000000}," +
                "{\"lng\": 116.389275,\"lat\": 39.925818,\"count\": -10000000}]";
        System.out.println(heatmapData);
        System.out.println(StringEscapeUtils.unescapeJava(heatmapData));
        mv.setViewName("testview");
        //mv.addObject("heatmapData",StringEscapeUtils.unescapeJava(heatmapData));
        mv.addObject("heatmapData",heatmapData);
        return mv;
    }
}
