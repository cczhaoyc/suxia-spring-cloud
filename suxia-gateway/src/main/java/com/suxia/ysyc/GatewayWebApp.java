package com.suxia.ysyc;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * <p>
 * GatewayWebApp
 * </p>
 *
 * @author cczhaoyc@163.com
 * @version v_1.0.0
 * @date 2020/8/1 13:36
 */
@SpringBootApplication
@MapperScan("com.suxia.ysyc.mapper")
public class GatewayWebApp {

    public static void main(String[] args) {
        SpringApplication.run(GatewayWebApp.class, args);
    }
}
