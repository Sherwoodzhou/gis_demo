package com.glodon.service;

import com.glodon.Bean.BO.GisModle;
import com.glodon.Bean.MobileEvents;
import com.glodon.mapper.MobileEventsDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Transactional
@Service
public class MobileEventsService {
    @Autowired
    private MobileEventsDao mobileEventsDao;

    /**
     * 数据库 存储
     * @param mobileEvents
     * @return
     */
    public int addMobileEvents(MobileEvents mobileEvents) {
        return mobileEventsDao.addMobileEvents(mobileEvents);
    }

    public int batchInsert(List<MobileEvents> batch){
        return mobileEventsDao.batchInsert(batch);
    }

    /**
     * 数据库 经纬度查询
     * @return
     */
    public List<GisModle> inqueryMobileEventsDir() {
        return mobileEventsDao.selectAllDir();
    }
}
