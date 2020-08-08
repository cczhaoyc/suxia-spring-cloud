package com.suxia.ysyc.config;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.oas.annotations.EnableOpenApi;
import springfox.documentation.service.*;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spi.service.contexts.SecurityContext;
import springfox.documentation.spring.web.plugins.Docket;

import java.util.*;

/**
 * <p>
 * Springfox-swagger 3.0.0配置
 * </p>
 *
 * @author cczhaoyc@163.com
 * @version v_1.0.0
 * @date 2020/8/7 9:28
 */
@Configuration
@EnableOpenApi
public class SpringSwaggerConfig {

    private final Logger LOG = LoggerFactory.getLogger(this.getClass());

    @Value("${server.port}")
    private Integer port;
    @Value("${spring.application.name}")
    private String applicationName;
    @Value("${suxia.swagger.enable}")
    private Boolean enable;
    @Value("${suxia.swagger.title}")
    private String title;
    @Value("${suxia.swagger.description}")
    private String description;
    @Value("${suxia.swagger.name}")
    private String name;
    @Value("${suxia.swagger.url}")
    private String url;
    @Value("${suxia.swagger.email}")
    private String email;
    @Value("${suxia.swagger.version}")
    private String version;
    @Value("${suxia.swagger.base-package}")
    private String basePackage;

    @Bean
    public Docket createRestApi() {

        Docket docket = new Docket(DocumentationType.OAS_30)
                .pathMapping("/")
                // 定义是否开启swagger，false为关闭，可以通过变量控制
                .enable(enable)
                // 将api的元信息设置为包含在json ResourceListing响应中
                .apiInfo(this.apiInfo())
                .groupName(applicationName)
                // 选择哪些接口作为swagger的doc发布
                .select()
                .apis(RequestHandlerSelectors.basePackage(basePackage))
                .paths(PathSelectors.any())
                .build()
                // 支持的通讯协议集合
                .protocols(this.newHashSet("https", "http"))
                // 授权信息设置，必要的header token等认证信息
                .securitySchemes(this.securitySchemes())
                // 授权信息全局应用
                .securityContexts(this.securityContexts());

        LOG.info(">>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>" +
                "[Swagger初始化完成]" +
                "<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<");

        LOG.info(">>>>>>>>>>>>>>>>>>>>>>>>>>>" +
                "[Swagger地址：" + "http://localhost:" + port + "/swagger-ui/index.html]" +
                "<<<<<<<<<<<<<<<<<<<<<<<<<<<<");

        return docket;
    }

    /**
     * <p>
     * API描述信息
     * </p>
     *
     * @author cczhaoyc@163.com
     * @date 2020/8/8 9:20
     */
    private ApiInfo apiInfo() {
        return new ApiInfoBuilder()
                .title(title)
                .description(description)
                .contact(new Contact(name, url, email))
                .version(version)
                .build();
    }

    /**
     * <p>
     * 设置授权信息
     * </p>
     *
     * @author cczhaoyc@163.com
     * @date 2020/8/8 9:32
     */
    private List<SecurityScheme> securitySchemes() {
        return Collections.singletonList(new ApiKey("Authorization", "Authorization", "pass"));
    }

    /**
     * <p>
     * 授权信息全局应用
     * </p>
     *
     * @author cczhaoyc@163.com
     * @date 2020/8/8 9:32
     */
    private List<SecurityContext> securityContexts() {
        return Collections.singletonList(SecurityContext.builder()
                .securityReferences(Collections.singletonList(new SecurityReference("Authorization", new AuthorizationScope[]{new AuthorizationScope("global", "授权信息")}))).build());
    }

    /**
     * <p>
     * 支持的通讯协议
     * </p>
     *
     * @author cczhaoyc@163.com
     * @date 2020/8/8 9:32
     */
    @SafeVarargs
    private final <T> Set<T> newHashSet(T... ts) {
        if (ts.length > 0) {
            return new LinkedHashSet<>(Arrays.asList(ts));
        }
        return null;
    }
}
