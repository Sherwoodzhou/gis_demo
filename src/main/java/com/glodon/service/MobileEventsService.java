package com.glodon.service;

import com.glodon.Bean.BO.GisModle;
import com.glodon.Bean.MobileEvents;
import com.glodon.mapper.MobileEventsDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MobileEventsService {
    @Autowired
    private MobileEventsDao mobileEventsDao;

    public int addMobileEvents(MobileEvents mobileEvents) {
        return mobileEventsDao.addMobileEvents(mobileEvents);
    }

    public List<GisModle> inqueryMobileEventsDir (){
        return mobileEventsDao.selectAllDir();
    }
}
