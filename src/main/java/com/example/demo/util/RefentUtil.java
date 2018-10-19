package com.example.demo.util;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * desc  反射获取get方法的值
 * @author ty
 *
 */
public class RefentUtil {
    
    public static Object  getValue(Object obj,String fieldName) {
        
       if (obj==null) {
           return null;
       }
        // 取属性首字母转大写
        String firstLetter = fieldName.substring(0, 1).toUpperCase();
        // set方法名
        String getMethodName = "get" + firstLetter + fieldName.substring(1);
        try {
            Method getMethod = obj.getClass().getDeclaredMethod(getMethodName);
            return getMethod.invoke(obj);
        } catch (SecurityException | NoSuchMethodException | IllegalAccessException | IllegalArgumentException | InvocationTargetException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return null;
    }
}
