package org.wjy.framework.ext;

import org.wjy.framework.annotation.Api;

import java.lang.reflect.Field;

public class ApiExt {

    /**
     * 为Api注解赋值:此注解只存在于字段上
     */
    public static void setValue(String clazzName){

        //根据全类名获得类对象
        try {
            Class<?> clazz = Class.forName(clazzName);
            //获得所有字段
            Field[] fields = clazz.getDeclaredFields();
            for (Field field : fields) {
                //查看字段是否有api注解
                Api api = field.getAnnotation(Api.class);
                if(api != null){
                    field.setAccessible(true);
                    try {
                        field.set(field, api.value());
                    } catch (IllegalAccessException e) {
                        e.printStackTrace();
                    }
                }
            }
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}
