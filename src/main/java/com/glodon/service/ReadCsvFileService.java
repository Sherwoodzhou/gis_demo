package com.glodon.service;

import com.csvreader.CsvReader;
import com.glodon.Bean.MobileEvents;
import com.glodon.util.JSONUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.Random;

@Service
public class ReadCsvFileService {
    @Autowired
    private MobileEventsService mobileEventsService;

    public String readCsvFile(String filePath) {
        String jsonString="[";
        try {
            ArrayList<String[]> csvList = new ArrayList<String[]>();
            CsvReader reader = new CsvReader(filePath, ',', Charset.forName("windows-1252"));
            //reader.readHeaders(); //跳过表头,不跳可以注释掉

            while (reader.readRecord()) {
                csvList.add(reader.getValues()); //按行读取，并把每一行的数据添加到list集合
            }
            reader.close();
            System.out.println("读取的行数：" + csvList.size());

            int count=0;
            for (int row = 1; row < 5; row++) {
                //for (int row = 1; row < csvList.size(); row++) {
                MobileEvents mobileEvents=new MobileEvents();
                mobileEvents.setEvent_id(Integer.valueOf(csvList.get(row)[0]));
                mobileEvents.setDevice_id(csvList.get(row)[1]);
                mobileEvents.setTimestamp(csvList.get(row)[2]);
                mobileEvents.setLongitude(Float.parseFloat(csvList.get(row)[3]));
                mobileEvents.setLatitude(Float.parseFloat(csvList.get(row)[4]));
                mobileEventsService.addMobileEvents(mobileEvents);
                count=new Random().nextInt(1000);
/*                jsonString+= JSONUtil.getJSONString(Integer.valueOf(csvList.get(row)[0]),
                                                    csvList.get(row)[1],
                                                    csvList.get(row)[2],
                                                    Float.parseFloat(csvList.get(row)[3]),
                                                    Float.parseFloat(csvList.get(row)[4]));*/
                jsonString+= JSONUtil.getJSONString(Float.parseFloat(csvList.get(row)[3]),
                        Float.parseFloat(csvList.get(row)[4]),
                        count)+",";

            }
            jsonString+=JSONUtil.getJSONString(Float.parseFloat(csvList.get(5)[3]),
                    Float.parseFloat(csvList.get(5)[4]),
                    count)+"]";
        } catch (Exception e) {
            e.printStackTrace();
        }

        return jsonString;
    }

}
