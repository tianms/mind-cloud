package com.mind.util.cache;

import com.mind.common.constatns.BaseConstants;
import com.mind.util.ehcache.EhcacheService;
import com.mind.util.redis.RedisService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.util.Set;

/**
 * @Auther: tianms
 * @Date: 2020/11/26 09:35
 * @Description: 缓存工具类
 */
@Service
public class CacheUtils {

    // 是否启用redis，
    @Value("${cacheConfig.enableRedis}")
    private String enableRedis;

    @Autowired
    private EhcacheService ehcacheService;

    @Autowired
    private RedisService redisService;

    @PostConstruct
    public void init() {
        if (StringUtils.isBlank(enableRedis)) {
            enableRedis = BaseConstants.TrueOrFalseConstant.FALSE;
        }
    }


    /**
     * 功能描述: 根据key获取数据
     *
     * @param key
     * @return java.lang.Object
     * @auther: tms
     * @date: 2020/11/25 18:32
     */
    public Object get(String key) {
        if (Boolean.valueOf(enableRedis)) {
            return redisService.get(key);
        } else {
            return ehcacheService.get(key);
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
    public void set(String key, String value) {
        if (Boolean.valueOf(enableRedis)) {
            redisService.set(key, value);
        } else {
            ehcacheService.put(key, value);
        }
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
    public void set(String key, String value, Long timeOut) {
        if (Boolean.valueOf(enableRedis)) {
            redisService.set(key, value, timeOut);
        } else {
            ehcacheService.put(key, value, timeOut);
        }
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
        if (Boolean.valueOf(enableRedis)) {
            redisService.delete(key);
        } else {
            ehcacheService.delete(key);
        }
    }

    /**
     * 功能描述: 获取缓存中所有的key
     *
     * @return java.util.List<java.lang.String>
     * @auther: tms
     * @date: 2020/11/25 18:32
     */
    public Set<String> getKeys(String pattern) {
        if (Boolean.valueOf(enableRedis)) {
            return redisService.getKeys(pattern);
        } else {
            return ehcacheService.getKeys();
        }
    }

    /**
     * 功能描述: 判断key值是否存在
     *
     * @param key
     * @return boolean
     * @auther: tms
     * @date: 2020/11/25 18:32
     */
    public Boolean isExist(String key) {
        if (Boolean.valueOf(enableRedis)) {
            return redisService.exist(key);
        } else {
            return ehcacheService.isExist(key);
        }
    }

    /**
     * 功能描述: 存入hash不加超时时间
     *
     * @param hKey
     * @param key
     * @param value
     * @return void
     * @auther: tms
     * @date: 2020/11/25 18:32
     */
    public void hSet (String hKey, String key, String value) {
        if (Boolean.valueOf(enableRedis)) {
            redisService.hSet(hKey, key, value);
        } else {
            ehcacheService.hPut(hKey, key, value);
        }
    }

    /**
     * 功能描述: 存入hash添加超时时间
     *
     * @param hKey
     * @param key
     * @param value
     * @param time
     * @return void
     * @auther: tms
     * @date: 2020/11/25 18:32
     */
    public void hSet (String hKey, String key, String value, Long time) {
        if (Boolean.valueOf(enableRedis)) {
            redisService.hSet(hKey, key, value, time);
        } else {
            ehcacheService.hPut(hKey, key, value, time);
        }
    }

    /**
     * 功能描述: 获取hash值
     *
     * @param hKey
     * @param key
     * @return void
     * @auther: tms
     * @date: 2020/11/25 18:32
     */
    public Object hGet (String hKey, String key) {
        if (Boolean.valueOf(enableRedis)) {
            return redisService.hGet(hKey, key);
        } else {
            return ehcacheService.hGet(hKey, key);
        }
    }

    /**
     * 功能描述: 删除hash值
     *
     * @param hKey
     * @param key
     * @return void
     * @auther: tms
     * @date: 2020/11/25 18:32
     */
    public void hDel (String hKey, String key) {
        if (Boolean.valueOf(enableRedis)) {
            redisService.hDel(hKey, key);
        } else {
            ehcacheService.hDel(hKey, key);
        }
    }

}
