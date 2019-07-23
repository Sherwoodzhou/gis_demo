package com.glodon.service;

import com.glodon.Bean.BO.GisModel;
import com.glodon.Bean.DangerousHouse;
import com.glodon.mapper.DangerousHouseDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Transactional
@Service
public class DangerousHouseService {
    @Autowired
    private DangerousHouseDao dangerousHouseDao;


    /**
     * 数据库 存储
     * @param dangerousHouse
     * @return
     */
    public int addDangerousHouse(DangerousHouse dangerousHouse) {
        return dangerousHouseDao.addHouseBean(dangerousHouse);
    }

    public int batchInsert(List<DangerousHouse> batch){
        return dangerousHouseDao.batchInsert(batch);
    }

    /**
     * 数据库 经纬度查询
     * @return
     */
    public List<GisModel> inqueryDangerousHouse() {
        return dangerousHouseDao.selectAllDir();
    }

    public int selectSize(){
        return dangerousHouseDao.selectSize();
    }
}
