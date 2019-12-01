package org.wjy.framework.start;

import org.wjy.framework.ext.ApiExt;
import org.wjy.framework.io.FileScanner;

import java.io.File;
import java.util.concurrent.CopyOnWriteArrayList;

/**
 * SpringBoot的启动类
 */
public class SpringApplication {

    //启动方法
    public static void run(Class clazz){
        //获得当前类所在的包
        Package clazzPackage = clazz.getPackage();
        //获得当前类所在包的相对路径,在路径前面拼接src
        String packPath = clazzPackage.toString().split(" ")[1].replace(".", "\\");
        String srcPath = "src\\" + packPath;
        //获得文件对象
        File file = new File(srcPath);
        //扫描当前路径,获得当前路径下所有文件
        FileScanner fileScanner = new FileScanner();
        CopyOnWriteArrayList<String> copyOnWriteArrayList = fileScanner.scanFile(file);
        //遍历当前文件,对注解进行赋值操作
        for (String clazzName: copyOnWriteArrayList) {
            ApiExt.setValue(clazzName);
        }
    }

}
