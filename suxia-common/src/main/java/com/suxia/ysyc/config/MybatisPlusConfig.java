package com.suxia.ysyc.config;

import com.baomidou.mybatisplus.extension.plugins.PaginationInterceptor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * <p>
 * MybatisPlus配置
 * </p>
 *
 * @author cczhaoyc@163.com
 * @version v_1.0.0
 * @date 2020/8/1 10:57
 */
@Configuration
public class MybatisPlusConfig {

    /**
     * <p>
     * 分页插件配置
     * </p>
     *
     * @author cczhaoyc@163.com
     * @date 2020/8/6 21:24
     */
    @Bean
    public PaginationInterceptor paginationInterceptor() {
        return new PaginationInterceptor();
    }

}
