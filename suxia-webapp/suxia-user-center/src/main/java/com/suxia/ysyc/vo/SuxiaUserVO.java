package com.suxia.ysyc.vo;

import cn.hutool.core.date.DatePattern;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.databind.ser.std.ToStringSerializer;
import lombok.Data;

import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * <p>
 * 用户表
 * </p>
 *
 * @author cczhaoyc@163.com
 * @version v_1.0.0
 * @date 2020/8/7 14:53
 */
@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
public class SuxiaUserVO implements Serializable {

    private static final long serialVersionUID = 6784815099074915220L;

    /**
     * 用户Id
     */
    @JsonSerialize(using = ToStringSerializer.class)
    private Long userId;

    /**
     * 文件Id(图片)
     */
    @JsonSerialize(using = ToStringSerializer.class)
    private Long fileId;

    /**
     * 用户账号
     */
    private String username;

    /**
     * 用户密码
     */
    private String password;

    /**
     * 用户性别代码
     */
    private String sexCode;

    /**
     * 证件类型代码
     */
    private String idTypeCode;

    /**
     * 证件号码
     */
    private String idNumber;

    /**
     * 出生日期
     */
    @JsonFormat(pattern = DatePattern.NORM_DATETIME_PATTERN, timezone = "GMT+8")
    private LocalDateTime birthday;

    /**
     * 联系电话
     */
    private String telephone;

    /**
     * 五笔
     */
    private String wubi;

    /**
     * 拼音
     */
    private String pinyin;

    /**
     * 停用标志（0:在用 1:停用）
     */
    private Boolean isStopped;

    /**
     * 说明
     */
    private String remark;

    /**
     * 创建时间
     */
    private LocalDateTime createdTime;

    /**
     * 最后更新时间
     */
    private LocalDateTime updateTime;

}
