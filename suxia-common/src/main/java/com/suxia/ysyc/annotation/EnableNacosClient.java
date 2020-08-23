package com.suxia.ysyc.annotation;

import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * <p>
 * 启用nacos自动注册本地服务
 * </p>
 *
 * @author cczhaoyc@163.com
 * @version v_1.0.0
 * @date 2020/8/22 15:38
 */
@EnableDiscoveryClient
public @interface EnableNacosClient {

}
