package com.suxia.ysyc.vo;

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
public class SuxiaUserVO implements Serializable {

    private static final long serialVersionUID = 6784815099074915220L;

    /**
     * 用户Id
     */
    private Long userId;

    /**
     * 文件Id(图片)
     */
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
