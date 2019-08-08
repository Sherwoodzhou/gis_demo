package com.glodon.service;

import com.csvreader.CsvReader;
import com.glodon.bean.DangerousHouse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.List;

@Service
public class SaveCsvToDatabaseService {
    @Autowired
    private DangerousHouseService dangerousHouseService;

    /**
     * 读取本地文件到数据
     *
     * @param filePath
     * @return
     */
    public Boolean saveToDatabase(String filePath) {
        try {
            ArrayList<String[]> csvList = new ArrayList<String[]>();
            CsvReader reader = new CsvReader(filePath, ',', Charset.forName("gbk"));
            //reader.readHeaders(); //跳过表头,不跳可以注释掉

            while (reader.readRecord()) {
                csvList.add(reader.getValues()); //按行读取，并把每一行的数据添加到list集合
            }
            reader.close();
            System.out.println("读取的行数：" + csvList.size());
            List<DangerousHouse> batch = new ArrayList<>();
            //判断该表中是否已经有数据了,如果有，直接返回
            if (dangerousHouseService.selectSize() > 0) {
                return true;        //状态1
            }
            for (int row = 1; row < csvList.size(); row++) {
                DangerousHouse dangerousHouse = new DangerousHouse();
                dangerousHouse.setZip_code(Integer.valueOf(csvList.get(row)[0]));
                dangerousHouse.setAddress(new String(csvList.get(row)[1].getBytes(), "utf-8"));
                dangerousHouse.setCount(Integer.valueOf(csvList.get(row)[2]));
                dangerousHouse.setLongitude(Float.parseFloat(csvList.get(row)[3]));
                dangerousHouse.setLatitude(Float.parseFloat(csvList.get(row)[4]));
                dangerousHouse.setFinished(Integer.valueOf(csvList.get(row)[5]));
                dangerousHouse.setInprocess(Integer.valueOf(csvList.get(row)[6]));
                dangerousHouse.setNostart(Integer.valueOf(csvList.get(row)[7]));
                dangerousHouse.setNofound(Integer.valueOf(csvList.get(row)[8]));
                dangerousHouse.setInappropriate(Integer.valueOf(csvList.get(row)[9]));
                dangerousHouse.setProved(Integer.valueOf(csvList.get(row)[10]));
                batch.add(dangerousHouse);
                //DangerousHouseService.addMobileEvents(dangerousHouse);      //单行插入
            }
            dangerousHouseService.batchInsert(batch);     //批量插入
        } catch (Exception e) {
            e.printStackTrace();
        }
        return true;        //状态2
    }
}
