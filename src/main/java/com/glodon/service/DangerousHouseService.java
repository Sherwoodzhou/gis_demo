package com.glodon.service;

import com.glodon.bean.BO.CityGisModel;
import com.glodon.bean.BO.GisModel;
import com.glodon.bean.DangerousHouse;
import com.glodon.bean.annotation.Master;
import com.glodon.mapper.DangerousHouseDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

//@Transactional
@Service
public class DangerousHouseService {
    @Autowired
    private DangerousHouseDao dangerousHouseDao;


    /**
     * 数据库 存储
     *
     * @param dangerousHouse
     * @return
     */
    @Master
    public int addDangerousHouse(DangerousHouse dangerousHouse) {
        return dangerousHouseDao.addHouseBean(dangerousHouse);
    }
    @Master
    public int batchInsert(List<DangerousHouse> batch) {
        return dangerousHouseDao.batchInsert(batch);
    }

    /**
     * 数据库 经纬度查询
     *
     * @return
     */

    public List<GisModel> inqueryDangerousHouse() {
        return dangerousHouseDao.selectAllDir();
    }


    public int selectSize() {
        return dangerousHouseDao.selectSize();
    }


    public List<CityGisModel> inqueryCityDangerousHouse() {
        {
            return dangerousHouseDao.selectCityDir();
        }
    }
}
