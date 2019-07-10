package com.glodon.controller;


import com.glodon.service.UploadEventsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

@RestController
public class EventsController {
    @Autowired
    private  UploadEventsService uploadEventsService;

    @PostMapping("events")
    public ModelAndView  uploadFile(@RequestParam("file") MultipartFile file){
        Boolean aBoolean = uploadEventsService.saveFile(file);
        return new ModelAndView("index");
    }
}
