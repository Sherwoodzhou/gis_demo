package com.glodon.controller;


import com.glodon.service.UploadEventsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

@Controller("events")
public class EventsController {
    @Autowired
    UploadEventsService uploadEventsService;

    @PostMapping
    public String uploadFile(@RequestParam("file") MultipartFile file){
        uploadEventsService.saveFile(file);
        return new String("2");
    }
}
