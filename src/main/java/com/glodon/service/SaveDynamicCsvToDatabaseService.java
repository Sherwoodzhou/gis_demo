package com.glodon.service;

import com.csvreader.CsvReader;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

@Service
public class SaveDynamicCsvToDatabaseService {

    @Autowired
    DynamicService dynamicService;

    /**
     * 读取本地文件到数据
     *
     * @param filePath
     * @return
     */
    public Boolean saveToDatabase(String filePath, String fileName) {
        try {

            //1.文件读取
            ArrayList<String[]> csvList = new ArrayList<String[]>();
            CsvReader reader = new CsvReader(filePath, ',', Charset.forName("gbk"));
            //reader.readHeaders(); //跳过表头,不跳可以注释掉

            while (reader.readRecord()) {
                csvList.add(reader.getValues()); //按行读取，并把每一行的数据添加到list集合
            }
            reader.close();
            System.out.println("读取的行数：" + csvList.size());

            //2.动态建表
            String columnMessage = "";
            for (int column = 0; column < csvList.get(0).length; column++) {
                columnMessage += csvList.get(0)[column] + " varchar(30)";
                if (column < csvList.get(0).length - 1) {
                    columnMessage += ",";  //将所有的字段都设置为varchar类型
                }
            }
            int dot = fileName.lastIndexOf('.');
            fileName = fileName.substring(0,dot);
            System.out.println(fileName);
            dynamicService.createTable(columnMessage,fileName);

            //3.动态存入
            for (int row = 1; row < csvList.size(); row++) {
                Map<String, String> map = new HashMap<>();
                for (int column = 0; column < csvList.get(0).length; column++) {
                    map.put(csvList.get(0)[column], csvList.get(row)[column]);
                }
                dynamicService.insertForMap(map, fileName);
            }


        } catch (Exception e) {
            e.printStackTrace();
        }
        return true;        //状态2
    }
}
