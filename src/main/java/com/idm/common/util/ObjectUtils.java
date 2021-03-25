package com.idm.common.util;

import java.beans.PropertyDescriptor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by dong on 2018/4/1.
 */
public class ObjectUtils {

    public static void getMethod(Object obj) throws Exception{
        Class clazz = obj.getClass();//获得实体类名
        Field[] fields = obj.getClass().getDeclaredFields();//获得属性
        //获得Object对象中的所有方法
        for(Field field:fields){
            PropertyDescriptor pd = new PropertyDescriptor(field.getName(), clazz);
            Method getMethod = pd.getReadMethod();//获得get方法
            getMethod.invoke(obj);//此处为执行该Object对象的get方法

            Method setMethod = pd.getWriteMethod();//获得set方法
            setMethod.invoke(obj,"参数");//此处为执行该Object对象的set方法
        }
    }

    /**
     * 根据object获取字段的值
     * @param obj 对象
     * @param fields 字段列表
     * @throws Exception
     */
    public static List<String> getFeildValues(Object obj, String[] fields) throws Exception {
        Class clazz = obj.getClass();//获得实体类名
        ArrayList<String> values = new ArrayList<String>();

        //获得Object对象中的所有方法
        for(String field: fields){
            PropertyDescriptor pd = new PropertyDescriptor(field, clazz);
            Method getMethod = pd.getReadMethod();//获得get方法
            String value = getMethod.invoke(obj).toString();//此处为执行该Object对象的get方法

            values.add(value);
        }

        return values;
    }
}
