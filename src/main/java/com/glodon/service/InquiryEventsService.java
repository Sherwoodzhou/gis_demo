package com.glodon.service;

import com.glodon.Bean.BO.GisModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class InquiryEventsService {

    @Autowired
    private MobileEventsService mobileEventsService;


    /**
     * 经纬度查询并随机生成count值
     * @return
     */
    public List<GisModel> inquiryDir() {

        List<GisModel> gisModels = mobileEventsService.inqueryMobileEventsDir();
        //随机生成count值
        for (int i = 0; i < gisModels.size(); i++) {
            gisModels.get(i).setCount((int) (Math.random() * 1000));
        }
        return gisModels;
    }
}
