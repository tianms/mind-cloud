package com.mind.common.utils;

import java.util.List;

/**
 * @Auther: tianms
 * @Date: 2020/11/24 16:20
 * @Description: 集合工具类
 */
public class ListUtils {

    public static Boolean isEmpty(List list) {

        if (list == null || list.size() == 0) {
            return true;
        }

        return false;
    }

}
