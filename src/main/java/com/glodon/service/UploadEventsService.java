package com.glodon.service;

import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

@Service
public class UploadEventsService {

    /**
     * 数据上传到本地硬盘
     * @param newFile
     * @return
     */
    public String saveFile(MultipartFile newFile) {
        String path = "D:\\upload";
        String fileName = newFile.getOriginalFilename();
        try {
            //System.out.println("开始");
            byte[] sourceByte = newFile.getBytes();         //以原始文件名作为文件名
            File file = new File(path + "\\" + fileName);//文件路径（路径+文件名）
            if (!file.exists()) {   //文件不存在则创建文件，先创建目录
                File dir = new File(file.getParent());
                dir.mkdirs();
                file.createNewFile();

                FileOutputStream outStream = new FileOutputStream(file); //文件输出流将数据写入文件
                outStream.write(sourceByte);
                outStream.close();
            }
            //System.out.println("存储路径"+path+"\\"+fileName);
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            // do something
        }
        return path + "\\" + fileName;
    }

}
