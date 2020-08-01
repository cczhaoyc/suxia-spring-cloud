package com.suxia.ysyc;

import com.google.protobuf.Api;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * <p>
 * ApiWebApp
 * </p>
 *
 * @author cczhaoyc@163.com
 * @version v_1.0.0
 * @date 2020/8/1 13:37
 */
@SpringBootApplication
@MapperScan("com.suxia.ysyc.mapper")
public class ApiWebApp {

    public static void main(String[] args) {
        SpringApplication.run(ApiWebApp.class, args);
    }

}
