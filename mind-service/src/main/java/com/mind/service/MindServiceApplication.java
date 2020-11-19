package com.mind.service;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @Auther: tianms
 * @Date: 2020/11/18 16:02
 * @Description:
 */
@SpringBootApplication(scanBasePackages = {"com.mind"})
public class MindServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(MindServiceApplication.class, args);
    }

}
