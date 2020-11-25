package com.mind.manage;

import com.mind.util.redis.RedisService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * @Auther: tianms
 * @Date: 2020/11/18 14:45
 * @Description:
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class TestMain {

    @Autowired
    private RedisService redisService;

    @Test
    public void testRedis() {
        redisService.set("testKey1", "哈哈哈哈哈11111");
        redisService.set("testKey2", "吼吼吼吼吼22222");
        redisService.set("testKey3", "哈哈哈哈哈33333", 20l);
        redisService.set("testKey4", "哈哈哈哈哈44444", 5l);
        redisService.hSet("testHash", "testKey1", "hhhhhh吼吼吼吼吼");
        redisService.hSet("testHash", "testKey2", "hhhhhh哈哈哈哈哈");
        redisService.hSet("testHash", "testKey3", "哈哈哈哈哈3333333", 20l);
        redisService.hSet("testHash", "testKey4", "哈哈哈哈哈444444444", 5l);
        String res1 = redisService.get("testKey1");
        String res2 = redisService.get("testKey2");
        String res3 = redisService.get("testKey3");
        String res4 = redisService.get("testKey4");
        Object res5 = redisService.hGet("testHash", "testKey1");
        Object res6 = redisService.hGet("testHash", "testKey2");
        Object res7 = redisService.hGet("testHash", "testKey3");
        Object res8 = redisService.hGet("testHash", "testKey4");
        System.out.println("res1===" + res1);
        System.out.println("res2===" + res2);
        System.out.println("res3===" + res3);
        System.out.println("res4===" + res4);
        System.out.println("res5===" + res5);
        System.out.println("res6===" + res6);
        System.out.println("res7===" + res7);
        System.out.println("res8===" + res8);

        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        res1 = redisService.get("testKey1");
        res2 = redisService.get("testKey2");
        res3 = redisService.get("testKey3");
        res4 = redisService.get("testKey4");
        res5 = redisService.hGet("testHash", "testKey1");
        res6 = redisService.hGet("testHash", "testKey2");
        res7 = redisService.hGet("testHash", "testKey3");
        res8 = redisService.hGet("testHash", "testKey4");
        System.out.println("sleep ---- res1===" + res1);
        System.out.println("sleep ---- res2===" + res2);
        System.out.println("sleep ---- res3===" + res3);
        System.out.println("sleep ---- res4===" + res4);
        System.out.println("sleep ---- res5===" + res5);
        System.out.println("sleep ---- res6===" + res6);
        System.out.println("sleep ---- res7===" + res7);
        System.out.println("sleep ---- res8===" + res8);
    }

    @Test
    public void test2() {
    }
}
