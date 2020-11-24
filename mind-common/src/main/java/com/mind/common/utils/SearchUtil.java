package com.mind.common.utils;

import java.beans.PropertyDescriptor;
import java.lang.reflect.Field;

/**
 * 查询条件帮助类
 *
 * @author tms
 * @create 2020-11-19
 **/
public class SearchUtil {

    public static MapUtils getSearch(Object search) {

        if (search == null) {
            return null;
        }
        Field[] fields = search.getClass().getDeclaredFields();
        MapUtils mapUtils = new MapUtils();
        for (Field field : fields) {
            try {
                PropertyDescriptor propertyDescriptor = new PropertyDescriptor(field.getName(), search.getClass());
                Object value = propertyDescriptor.getReadMethod().invoke(search);
                if (value != null) {
                    mapUtils.put(field.getName(), value);
                }
            } catch (Exception e) {
                e.fillInStackTrace();
            }
        }
        return mapUtils;
    }
}
