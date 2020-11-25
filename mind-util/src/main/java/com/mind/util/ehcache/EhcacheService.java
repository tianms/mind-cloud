package com.mind.util.ehcache;

import com.mind.common.constatns.CachePrefixConstant;
import com.mind.common.constatns.NumConstant;
import net.sf.ehcache.Element;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.ehcache.EhCacheCacheManager;
import org.springframework.stereotype.Service;

import java.util.List;

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
     * @param key
     * @auther: tms
     * @date: 2020/11/25 18:32
     * @return java.lang.Object
    */
    public Object get (String key) {
        Element element = cacheManager.getCacheManager().getCache(CachePrefixConstant.CACHE_KEY).get(key);
        if (element == null) {
            return null;
        } else {
            return element.getObjectValue();
        }
    }

    /**
     * 功能描述: 存入缓存，没有超时时间
     * @param key
     * @param value
     * @auther: tms
     * @date: 2020/11/25 18:32
     * @return void
    */
    public void putCacheValue (String key, Object value) {
        putWithTime(key, value, null);
    }

    /**
     * 功能描述: 存入key添加超时时间
     * @param key
     * @param value
     * @param timeOut
     * @auther: tms
     * @date: 2020/11/25 18:32
     * @return void
    */
    public void putWithTime (String key, Object value, Integer timeOut) {
        Element element = new Element(key, value);
        if (timeOut != null && timeOut > NumConstant.ZERO) {
            element.setTimeToIdle(timeOut);
            element.setTimeToLive(timeOut);
        }
        cacheManager.getCacheManager().getCache(CachePrefixConstant.CACHE_KEY).put(element);
    }

    /**
     * 功能描述: 删除key
     * @param key
     * @auther: tms
     * @date: 2020/11/25 18:32
     * @return void
    */
    public void removeKey (String key) {
        cacheManager.getCacheManager().getCache(CachePrefixConstant.CACHE_KEY).remove(key);
    }

    /**
     * 功能描述: 获取缓存中所有的key
     * @auther: tms
     * @date: 2020/11/25 18:32
     * @return java.util.List<java.lang.String>
    */
    public List<String> getKeys() {
        return cacheManager.getCacheManager().getCache(CachePrefixConstant.CACHE_KEY).getKeys();
    }

    /**
     * 功能描述: 判断key值是否存在
     * @param key
     * @auther: tms
     * @date: 2020/11/25 18:32
     * @return boolean
    */
    public boolean isExist (String key) {
        if (get(key) != null) {
            return true;
        }
        return false;
    }

}
