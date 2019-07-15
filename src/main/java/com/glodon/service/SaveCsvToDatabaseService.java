package com.glodon.service;

import com.csvreader.CsvReader;
import com.glodon.Bean.DangerousHouse;
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
     * @param filePath
     * @return
     */
    public Boolean saveToDatabase(String filePath) {
        try {
            ArrayList<String[]> csvList = new ArrayList<String[]>();
            CsvReader reader = new CsvReader(filePath, ',', Charset.forName("windows-1252"));
            //reader.readHeaders(); //跳过表头,不跳可以注释掉

            while (reader.readRecord()) {
                csvList.add(reader.getValues()); //按行读取，并把每一行的数据添加到list集合
            }
            reader.close();
            System.out.println("读取的行数：" + csvList.size());
            List<DangerousHouse> batch = new ArrayList<>();

            for (int row = 1; row < csvList.size(); row++) {
                DangerousHouse dangerousHouse = new DangerousHouse();
                dangerousHouse.setZip_code(Integer.valueOf(csvList.get(row)[0]));
                dangerousHouse.setAddress(csvList.get(row)[1]);
                dangerousHouse.setCount(Integer.valueOf(csvList.get(row)[2]));
                dangerousHouse.setLongitude(Float.parseFloat(csvList.get(row)[3]));
                dangerousHouse.setLatitude(Float.parseFloat(csvList.get(row)[4]));
                batch.add(dangerousHouse);
                //DangerousHouseService.addMobileEvents(dangerousHouse);      //单行插入
            }
            dangerousHouseService.batchInsert(batch);     //批量插入
        } catch (Exception e) {
            e.printStackTrace();
        }
        return true;
    }
}
