package com.mind.common.utils;

import java.util.HashMap;

/**
 * @Auther: tianms
 * @Date: 2020/11/18 15:01
 * @Description:
 */
public class MapUtils extends HashMap<String, Object> {

    public MapUtils() {
    }

    public MapUtils(String key, Object value) {
        this.put(key, value);
    }

    public MapUtils put(String key, Object value) {
        super.put(key, value);
        return this;
    }
}
