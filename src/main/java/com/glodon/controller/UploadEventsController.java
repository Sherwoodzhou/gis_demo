package com.glodon.controller;

import com.glodon.service.ReadCsvFileService;
import com.glodon.service.UploadEventsService;
import org.apache.commons.lang.StringEscapeUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class UploadEventsController {
    @Autowired
    ReadCsvFileService readCsvFileService;
    @Autowired
    UploadEventsService uploadEventsService;

    @PostMapping("/events")
    @ResponseBody
    public ModelAndView getDir(@RequestParam("file") MultipartFile file) {
        String dir = uploadEventsService.saveFile(file);
        //System.out.println(file);
        String location=readCsvFileService.readCsvFile(dir);        //location json数据
        System.out.println(location);
        ModelAndView mv = new ModelAndView();
        String heatmapData = StringEscapeUtils.escapeJavaScript(location);
        mv.setViewName("gis");
        mv.addObject("heatmapData",heatmapData);
        return mv;
    }
}
