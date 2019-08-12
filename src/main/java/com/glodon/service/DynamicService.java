package com.glodon.service;

import com.glodon.bean.annotation.Master;
import com.glodon.mapper.DynamicDao;
import org.omg.CORBA.PUBLIC_MEMBER;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

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


    @Master
    public void createTable(String columnMessage, String tableName) {
        dynamicDao.createTable(columnMessage, tableName);
    }

    @Master
    public void insertForMap( Map<String, String> map,String tableName){
        dynamicDao.insertForMap(map,tableName);
    }
}
