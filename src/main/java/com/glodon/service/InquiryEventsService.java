package com.glodon.service;

import com.glodon.Bean.BO.GisModle;
import com.glodon.Bean.MobileEvents;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class InquiryEventsService {

    @Autowired
    private MobileEventsService mobileEventsService;


    public List<GisModle> inquiryDir(){

        List<GisModle> gisModles = mobileEventsService.inqueryMobileEventsDir();
        //随机生成count值
        for (int i=0;i<gisModles.size();i++){
            gisModles.get(i).setCount((int) (Math.random()*1000));
        }
        return gisModles;
    }
}
