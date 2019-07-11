package com.glodon.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

@Service
public class UploadEventsService {

    @Autowired
    ReadCsvFileService readCsvFileService;

    public Boolean saveFile(MultipartFile newFile) {

        String path = "D:\\upload\\";
        String fileName = "test.txt";
        long start = System.currentTimeMillis();
        try {
            System.out.println("开始");
            byte[] sourceByte = newFile.getBytes();
            File file = new File(path + fileName);//文件路径（路径+文件名）
            if (!file.exists()) {   //文件不存在则创建文件，先创建目录
                File dir = new File(file.getParent());
                dir.mkdirs();
                file.createNewFile();
            }
            System.out.println(file.getName());

            FileOutputStream outStream = new FileOutputStream(file); //文件输出流将数据写入文件
            //outStream.flush();
            outStream.write(sourceByte);

            outStream.close();
            System.out.println("存储路径" + path + "\\" + fileName);
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            // do something
            System.out.println("结束");
        }
        long end = System.currentTimeMillis();
        System.out.println(end-start);
        System.out.println();
        Boolean checkUpload = readCsvFileService.readCsvFile(path + fileName);
        return true;
}


}
