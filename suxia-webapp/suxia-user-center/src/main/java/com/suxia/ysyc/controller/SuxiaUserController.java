package com.suxia.ysyc.controller;


import com.suxia.ysyc.domain.RestResult;
import com.suxia.ysyc.dto.SuxiaUserDTO;
import com.suxia.ysyc.service.SuxiaUserService;
import com.suxia.ysyc.vo.SuxiaUserVO;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * <p>
 * 用户表 前端控制器
 * </p>
 *
 * @author cczhaoyc@163.com
 * @since 2020-08-07
 */
@RestController
@RequestMapping("/user")
@Api(value = "系统用户", tags = "系统用户接口")
public class SuxiaUserController {

    @Autowired
    private SuxiaUserService suxiaUserService;

    @PostMapping
    @ApiOperation(value = "新增用户")
    public RestResult<SuxiaUserVO> saveUser(SuxiaUserDTO userDTO) {
        return RestResult.success(suxiaUserService.addSuxiaUser(userDTO));
    }

    @PutMapping
    @ApiOperation(value = "修改用户")
    public RestResult<String> saveUser(Long id, String password) {
        return RestResult.success(id + ":" + password);
    }

}