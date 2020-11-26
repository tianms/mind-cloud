package com.mind.util.ehcache;

import com.mind.common.constatns.CachePrefixConstant;
import com.mind.common.constatns.NumConstant;
import com.mind.common.utils.MapUtils;
import net.sf.ehcache.Element;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.ehcache.EhCacheCacheManager;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

/**
 * @Auther: tianms
 * @Date: 2020/11/25 18:30
 * @Description: ehcache操作类
 */
@Service("ehcacheService")
public class EhcacheService {

    @Autowired
    private EhCacheCacheManager cacheManager;

    /**
     * 功能描述: 根据key获取数据
     *
     * @param key
     * @return java.lang.Object
     * @auther: tms
     * @date: 2020/11/25 18:32
     */
    public Object get(String key) {
        Element element = cacheManager.getCacheManager().getCache(CachePrefixConstant.CACHE_KEY).get(key);
        if (element == null) {
            return null;
        } else {
            return element.getObjectValue();
        }
    }

    /**
     * 功能描述: 存入缓存，没有超时时间
     *
     * @param key
     * @param value
     * @return void
     * @auther: tms
     * @date: 2020/11/25 18:32
     */
    public void put(String key, Object value) {
        put(key, value, null);
    }

    /**
     * 功能描述: 存入key添加超时时间
     *
     * @param key
     * @param value
     * @param timeOut
     * @return void
     * @auther: tms
     * @date: 2020/11/25 18:32
     */
    public void put(String key, Object value, Long timeOut) {
        Element element = new Element(key, value);
        if (timeOut != null && timeOut > NumConstant.ZERO) {
            element.setTimeToIdle(timeOut.intValue());
            element.setTimeToLive(timeOut.intValue());
        }
        cacheManager.getCacheManager().getCache(CachePrefixConstant.CACHE_KEY).put(element);
    }

    /**
     * 功能描述: 删除key
     *
     * @param key
     * @return void
     * @auther: tms
     * @date: 2020/11/25 18:32
     */
    public void delete(String key) {
        cacheManager.getCacheManager().getCache(CachePrefixConstant.CACHE_KEY).remove(key);
    }

    /**
     * 功能描述: 获取缓存中所有的key
     *
     * @return java.util.List<java.lang.String>
     * @auther: tms
     * @date: 2020/11/25 18:32
     */
    public Set<String> getKeys() {
        return new HashSet<>(cacheManager.getCacheManager().getCache(CachePrefixConstant.CACHE_KEY).getKeys());
    }

    /**
     * 功能描述: 判断key值是否存在
     *
     * @param key
     * @return Boolean
     * @auther: tms
     * @date: 2020/11/25 18:32
     */
    public Boolean isExist(String key) {
        if (get(key) == null) {
            return false;
        }
        return true;
    }

    /**
     * 功能描述: hash存储不超时
     *
     * @param hKey
     * @param key
     * @param value
     * @return void
     * @auther: tms
     * @date: 2020/11/26 13:18
     */
    public void hPut(String hKey, String key, String value) {
        MapUtils mapUtils = new MapUtils();
        mapUtils.put(key, value);
        this.put(hKey, mapUtils);
    }

    /**
     * 功能描述: hash存储带超时时间
     *
     * @param hKey
     * @param key
     * @param value
     * @param time
     * @return void
     * @auther: tms
     * @date: 2020/11/26 13:20
     */
    public void hPut(String hKey, String key, String value, Long time) {
        MapUtils mapUtils = new MapUtils();
        mapUtils.put(key, value);
        this.put(hKey, mapUtils, time);
    }

    /**
     * 功能描述: hash获取
     *
     * @param hKey
     * @param key
     * @return java.lang.Object
     * @auther: tms
     * @date: 2020/11/26 13:22
     */
    public Object hGet(String hKey, String key) {
        MapUtils mapUtils = (MapUtils) this.get(hKey);
        return mapUtils.get(key);
    }

    /**
     * 功能描述: hash删除key
     *
     * @param hKey
     * @param key
     * @return void
     * @auther: tms
     * @date: 2020/11/26 13:28
     */
    public void hDel(String hKey, String key) {
        MapUtils mapUtils = (MapUtils) this.get(hKey);
        Iterator<Map.Entry<String, Object>> map = mapUtils.entrySet().iterator();
        while (map.hasNext()) {
            if (map.next().getKey().equals(key)) {
                map.remove();
            }
        }
        this.put(hKey, mapUtils);
    }
}
