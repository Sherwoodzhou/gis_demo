package com.glodon.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("gis")
public class GisController {

    @PostMapping()
    public String saveData(){
        return new String();
    }
}
