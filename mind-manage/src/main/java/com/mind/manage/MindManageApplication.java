package com.mind.manage;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @Auther: tianms
 * @Date: 2020/11/18 14:31
 * @Description:
 */
@SpringBootApplication(scanBasePackages = {"com.mind"})
public class MindManageApplication {

    public static void main(String[] args) {
        SpringApplication.run(MindManageApplication.class, args);
    }

}
