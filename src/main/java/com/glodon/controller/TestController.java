package com.glodon.controller;


import com.glodon.service.DynamicService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.HashMap;
import java.util.Map;

@Controller

public class TestController {

    @Autowired
    private DynamicService dynamicService;

    @RequestMapping("/test")
    public String createTable() {
        //dynamicService.createTable();
        Map<String, String> map = new HashMap<>();
        map.put("`zip_code`","10");
        map.put("`address`","NewYork");
        dynamicService.insertForMap(map,"test");
        return "success";
    }
}
/*
  `zip_code` int(15) NOT NULL,
          `address` varchar(30) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
          `count` int(30) NOT NULL,
          `longitude` float NOT NULL,
          `latitude` float NOT NULL,
          `finished` int(15) NOT NULL,
          `inprocess` int(15) NOT NULL,
          `nostart` int(15) NOT NULL,
          `nofound` int(15) NOT NULL,
          `inappropriate` int(15) NOT NULL,
          `proved` int(15) NOT NULL,*/
