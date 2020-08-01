package com.suxia.ysyc.controller;


import com.suxia.ysyc.service.SuxiaUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RestController;

/**
 * <p>
 * 用户表 前端控制器
 * </p>
 *
 * @author cczhaoyc@163.com
 * @since 2020-08-01
 */
@RestController
@RequestMapping("/user")
public class SuxiaUserController {

    @Autowired
    private SuxiaUserService suxiaUserService;

    @PostMapping
    public void saveUser() {

    }

}
