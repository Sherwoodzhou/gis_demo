package com.glodon.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/")
public class FaceController {

    /**
     * 跳转到上传文件的页面
     * @return
     */
    @RequestMapping(value = "/uploaddata", method = RequestMethod.GET)
    public String goUploadImg() {
        return "uploaddata";
    }
}
