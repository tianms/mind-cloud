package com.mind.common.annotation;

import java.lang.annotation.*;

/**
 * @Auther: tianms
 * @Date: 2020/11/23 10:39
 * @Description: 参数日志打印
 */
@Documented
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
public @interface Log {
}
