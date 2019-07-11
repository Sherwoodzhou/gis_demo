package com.glodon.service;

import com.csvreader.CsvReader;
import org.springframework.stereotype.Service;

import java.nio.charset.Charset;
import java.util.ArrayList;

@Service
public class ReadCsvFileService {
    public Boolean readCsvFile(String filePath) {
        try {
            ArrayList<String[]> csvList = new ArrayList<String[]>();
            CsvReader reader = new CsvReader(filePath, ',', Charset.forName("windows-1252"));
            //reader.readHeaders(); //跳过表头,不跳可以注释掉

            while (reader.readRecord()) {
                csvList.add(reader.getValues()); //按行读取，并把每一行的数据添加到list集合
            }
            reader.close();
            System.out.println("读取的行数：" + csvList.size());
/*            for (int row = 0; row < csvList.size(); row++) {
                System.out.println("-----------------");
                //打印每一行的数据
                System.out.print(csvList.get(row)[0] + ",");
                System.out.print(csvList.get(row)[1] + ",");
                System.out.print(csvList.get(row)[2] + ",");
                System.out.println(csvList.get(row)[3] + ",");
                //如果第一列（即姓名列）包含lisa，则打印出lisa的年龄
                if (csvList.get(row)[0].equals("lisa")) {
                    System.out.println("lisa的年龄为：" + csvList.get(row)[2]);
                }
            }*/
        } catch (Exception e) {
            e.printStackTrace();
        }finally {
            return true;
        }
    }
}
