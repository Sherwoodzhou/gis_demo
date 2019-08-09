package com.glodon.service;

import com.glodon.mapper.DynamicDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;

@Service
public class DynamicService {

    @Autowired
    private DynamicDao dynamicDao;

    /**
     * 动态传参,使用map传递参数
     *
     * @param column
     * @param table
     * @return
     */
    public List<HashMap<String, Object>> selectForMap(String column, String table) {
        System.out.println(column);
        return dynamicDao.selectForMap(column, table);
    }
}
