package com.glodon.service;

import com.glodon.Bean.MobileEvents;
import com.glodon.mapper.MobileEventsDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MobileEventsService {
    @Autowired
    private MobileEventsDao mobileEventsDao;

    public int addMobileEvents(MobileEvents mobileEvents) {
        return mobileEventsDao.addMobileEvents(mobileEvents);
    }
}
