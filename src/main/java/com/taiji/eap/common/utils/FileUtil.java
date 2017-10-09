package com.taiji.eap.common.utils;

import java.io.File;
import java.io.FileOutputStream;
import java.io.OutputStreamWriter;
import java.io.Writer;

public class FileUtil {

    public static boolean writeStrToFile(String path,String fileName,String content){
        boolean flag = true;
        File file = new File(path);
        if(!file.exists()){
            file.mkdirs();
        }
        File OutFile = new File(file,fileName);
        try {
            FileOutputStream outputStream = new FileOutputStream(OutFile);
            Writer writer = new OutputStreamWriter(outputStream,"UTF-8");
            writer.write(content);
            writer.flush();
            writer.close();
        } catch (Exception e) {
            e.printStackTrace();
            flag = false;
        }
        return flag;
    }
}
