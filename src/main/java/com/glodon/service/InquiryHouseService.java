package com.glodon.service;

import com.glodon.Bean.BO.GisModle;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class InquiryHouseService {

    @Autowired
    private DangerousHouseService dangerousHouseService;

    /**
     * 经纬度查询并随机生成count值
     * @return
     */
    public List<GisModle> inquiryDir() {

        List<GisModle> gisModles = dangerousHouseService.inqueryDangerousHouse();
        //随机生成count值
        return gisModles;
    }
}
