package com.mind.util.redis;

import com.mind.common.constatns.NumConstant;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.TimeUnit;

/**
 * @Auther: tianms
 * @Date: 2020/11/25 15:13
 * @Description: redis操作类
 */
@Service("redisService")
public class RedisService {

    @Autowired
    private StringRedisTemplate redisTemplate;

    /*********************************** key-value string ***************************************/

    /**
     * 功能描述: key - value 添加带超时时间的数据
     *
     * @param key   key
     * @param value 值
     * @param time  超时时间：秒
     * @return void
     * @auther: tms
     * @date: 2020/11/25 15:18
     */
    public void set(String key, String value, Long time) {
        if (time != null && time > NumConstant.ZERO) {
            this.setExpire(key, time);
        } else {
            redisTemplate.opsForValue().set(key, value);
        }
    }

    /**
     * 功能描述: key - value 添不超时数据
     *
     * @param key
     * @param value
     * @return void
     * @auther: tms
     * @date: 2020/11/25 15:21
     */
    public void set(String key, String value) {
        this.set(key, value, null);
    }

    /**
     * 功能描述: 批量添加数据
     *
     * @param map
     * @return void
     * @auther: tms
     * @date: 2020/11/25 15:35
     */
    public void multiset(Map<String, String> map) {
        redisTemplate.opsForValue().multiSet(map);
    }

    /**
     * 功能描述: key - value 获取数据
     *
     * @param key
     * @return java.lang.String
     * @auther: tms
     * @date: 2020/11/25 15:22
     */
    public String get(String key) {
        return redisTemplate.opsForValue().get(key);
    }

    /**
     * 功能描述: 判断key值是否存在
     *
     * @param key
     * @return java.lang.Boolean
     * @auther: tms
     * @date: 2020/11/25 15:26
     */
    public Boolean exist(String key) {
        String value = redisTemplate.opsForValue().get(key);
        if (StringUtils.isBlank(value)) {
            return false;
        }
        return true;
    }

    /**
     * 功能描述: 判断key值是否存在并添加
     * 如果添加失败证明key存在返回false
     * 如果添加成功返回true
     *
     * @param key
     * @param value
     * @param time
     * @return java.lang.Boolean
     * @auther: tms
     * @date: 2020/11/25 15:28
     */
    public Boolean setNx(String key, String value, Long time) {
        if (this.exist(key)) {
            return false;
        } else {
            redisTemplate.opsForValue().setIfAbsent(key, value, time, TimeUnit.SECONDS);
            return true;
        }
    }

    /**
     * 功能描述: 设置key的过期时间
     *
     * @param key
     * @param time
     * @return void
     * @auther: tms
     * @date: 2020/11/25 15:30
     */
    public void setExpire(String key, Long time) {
        redisTemplate.expire(key, time, TimeUnit.SECONDS);
    }

    /**
     * 功能描述: 返回key存活的剩余时间
     *
     * @param key
     * @return java.lang.Long
     * @auther: tms
     * @date: 2020/11/25 15:31
     */
    public Long getExpire(String key) {
        return redisTemplate.getExpire(key, TimeUnit.SECONDS);
    }

    /**
     * 功能描述: 删除指定的key
     *
     * @param key
     * @return void
     * @auther: tms
     * @date: 2020/11/25 15:33
     */
    public void delete(String key) {
        redisTemplate.delete(key);
    }

    /**
     * 功能描述: 删除多个key
     *
     * @param keys
     * @return void
     * @auther: tms
     * @date: 2020/11/25 15:33
     */
    public void deleteKeys(Collection<String> keys) {
        redisTemplate.delete(keys);
    }

    /**
     * 功能描述: 自增
     *
     * @param key
     * @param increment
     * @return java.lang.Long
     * @auther: tms
     * @date: 2020/11/25 15:36
     */
    public Long incrBy(String key, Long increment) {
        return redisTemplate.opsForValue().increment(key, increment);
    }

    /**
     * 功能描述: 自减
     *
     * @param key
     * @param decrement
     * @return java.lang.Long
     * @auther: tms
     * @date: 2020/11/25 15:36
     */
    public Long decrBy(String key, Long decrement) {
        return redisTemplate.opsForValue().decrement(key, decrement);
    }

    /*********************************** key-value string ***************************************/


    /*********************************** hKey key value hash ***************************************/

    /**
     * 功能描述: key-key-value 添加带超时时间的hash数据
     *
     * @param hKey
     * @param key
     * @param value
     * @param time
     * @return void
     * @auther: tms
     * @date: 2020/11/25 15:56
     */
    public void hSet(String hKey, String key, String value, Long time) {
        redisTemplate.opsForHash().put(hKey, key, value);
        if (time != null && time > NumConstant.ZERO) {
            this.setExpire(hKey, time);
        }
    }

    /**
     * 功能描述: key-key-value 添加不超时的hash数据
     *
     * @param hKey
     * @param key
     * @param value
     * @return void
     * @auther: tms
     * @date: 2020/11/25 15:56
     */
    public void hSet(String hKey, String key, String value) {
        this.hSet(hKey, key, value, null);
    }

    /**
     * 功能描述: hash获取数据
     *
     * @param hKey
     * @param key
     * @return java.lang.Object
     * @auther: tms
     * @date: 2020/11/25 16:00
     */
    public Object hGet(String hKey, String key) {
        return redisTemplate.opsForHash().get(hKey, key);
    }

    /**
     * 功能描述: 删除单个hash数据
     *
     * @param hKey
     * @param key
     * @return void
     * @auther: tms
     * @date: 2020/11/25 16:02
     */
    public void hDel(String hKey, String key) {
        redisTemplate.opsForHash().delete(hKey, hKey);
    }

    /**
     * 功能描述: hash hKey下删除多个数据
     *
     * @return void
     * @auther: tms
     * @date: 2020/11/25 16:02
     */
    public void hDelKeys(String hKey, String... key) {
        redisTemplate.opsForHash().delete(hKey, key);
    }

    /*********************************** hKey key value hash ***************************************/

    /**
     * 功能描述: 获取指定前缀所有的key，如果查询全部传入“*”
     *
     * @param pattern
     * @return java.util.Set<java.lang.String>
     * @auther: tms
     * @date: 2020/11/26 10:55
     */
    public Set<String> getKeys(String pattern) {
        Set<String> keys = redisTemplate.keys(pattern);
        return keys;
    }
}
