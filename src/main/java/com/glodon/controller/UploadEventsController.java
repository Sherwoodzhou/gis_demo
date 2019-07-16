package com.glodon.controller;

import com.glodon.service.SaveCsvToDatabaseService;
        import com.glodon.service.UploadEventsService;
        import org.springframework.beans.factory.annotation.Autowired;
        import org.springframework.stereotype.Controller;
        import org.springframework.web.bind.annotation.PostMapping;
        import org.springframework.web.bind.annotation.RequestParam;
        import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class UploadEventsController {

    @Autowired
    UploadEventsService uploadEventsService;
    @Autowired
    SaveCsvToDatabaseService saveCsvToDatabaseService;

    /**
     * 存储数据，并返回成功页面
     * @param file
     * @return
     */
    @PostMapping("/upload")
    /*    @ResponseBody*//*这里不需要*/
    public ModelAndView getDir(@RequestParam("file") MultipartFile file) {
        String dir = uploadEventsService.saveFile(file);
        System.out.println("开始");
        long start = System.currentTimeMillis();
        boolean status = saveCsvToDatabaseService.saveToDatabase(dir);  //存入数据库的状态
        long end = System.currentTimeMillis();
        long time = end - start;
        System.out.println("耗时:"+ time);
        System.out.println("结束");
        ModelAndView mv = new ModelAndView();
        mv.setViewName("success");
        mv.addObject("fileName",file.getOriginalFilename());
        return mv;
    }
}
