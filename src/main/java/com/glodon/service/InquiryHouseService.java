package com.glodon.service;

import com.glodon.Bean.BO.CityGisModel;
import com.glodon.Bean.BO.GisModel;
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
    public List<GisModel> inquiryDir() {

        List<GisModel> gisModels = dangerousHouseService.inqueryDangerousHouse();
        //随机生成count值
        return gisModels;
    }

    public List<CityGisModel> inquiryCityDir(){
        List<CityGisModel> cityGisModel = dangerousHouseService.inqueryCityDangerousHouse();
        //随机生成count值
        return cityGisModel;
    }
}
