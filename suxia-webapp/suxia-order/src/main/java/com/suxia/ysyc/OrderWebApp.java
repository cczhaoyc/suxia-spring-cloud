package com.suxia.ysyc;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * <p>
 * OrderWebApp
 * </p>
 *
 * @author cczhaoyc@163.com
 * @version v_1.0.0
 * @date 2020/8/6 23:27
 */
@SpringBootApplication
@MapperScan("com.suxia.ysyc.mapper")
public class OrderWebApp {

    public static void main(String[] args) {
        SpringApplication.run(OrderWebApp.class, args);
    }
}
