package com.glodon.service;

import com.csvreader.CsvReader;
import com.glodon.Bean.MobileEvents;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.List;

@Service
public class SaveCsvToDatabaseService {
    @Autowired
    private MobileEventsService mobileEventsService;

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
            List<MobileEvents> batch = new ArrayList<>();
            for (int row = 1; row < 1000; row++) {
                MobileEvents mobileEvents = new MobileEvents();
                mobileEvents.setEvent_id(Integer.valueOf(csvList.get(row)[0]));
                mobileEvents.setDevice_id(csvList.get(row)[1]);
                mobileEvents.setTimestamp(csvList.get(row)[2]);
                mobileEvents.setLongitude(Float.parseFloat(csvList.get(row)[3]));
                mobileEvents.setLatitude(Float.parseFloat(csvList.get(row)[4]));
                batch.add(mobileEvents);
                //mobileEventsService.addMobileEvents(mobileEvents);
            }
            mobileEventsService.batchInsert(batch);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return true;
    }
}
