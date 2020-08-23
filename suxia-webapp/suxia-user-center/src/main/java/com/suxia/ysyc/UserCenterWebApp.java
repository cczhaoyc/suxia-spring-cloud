package com.suxia.ysyc;

import com.suxia.ysyc.annotation.EnableNacosClient;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * <p>
 * UserCenterWebApp
 * </p>
 *
 * @author cczhaoyc@163.com
 * @version v_1.0.0
 * @date 2020/8/1 10:16
 */
@SpringBootApplication
@MapperScan("com.suxia.ysyc.mapper")
@EnableNacosClient
public class UserCenterWebApp {

    public static void main(String[] args) {
        System.setProperty("es.set.netty.runtime.available.processors", "false");
        SpringApplication.run(UserCenterWebApp.class, args);
    }
}
