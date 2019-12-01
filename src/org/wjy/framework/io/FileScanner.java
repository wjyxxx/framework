package org.wjy.framework.io;

import java.io.File;
import java.util.Collections;
import java.util.concurrent.CopyOnWriteArrayList;

public class FileScanner {

    //创建线程安全的list集合,保存扫描到的java文件
    private CopyOnWriteArrayList<String> copyOnWriteArrayList = new CopyOnWriteArrayList();

    /**
     * 扫描某一路径下的文件
     * 递归
     */
    public CopyOnWriteArrayList<String> scanFile(File file){

        //file时文件时
        if(file.isFile()){
            System.out.println("\t\t\t文件名:" + file.getName()+"\n\t\t\t\t\t"
                                +"文件所在路径:" + file.getPath());
            //全类名
            String className = file.getPath().split("\\.")[0].replace("src\\","").replace("\\", ".");
            System.out.println("===全类名===:"+className);
            copyOnWriteArrayList.add(className);
        }
        //file时文件夹时
        else{
            System.out.println("当前所在文件夹:" + file.getPath());
            //获得此路径下的文件集合
            File[] files = file.listFiles();
            //判断是否有文件,并且有多个文件
            if(files != null && files.length > 0){
                //遍历文件集合
                for (File f: files) {
                    scanFile(f);
                }
            }
        }

        return copyOnWriteArrayList;

    }


}
