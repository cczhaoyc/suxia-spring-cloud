package com.suxia.ysyc.domain;

import com.baomidou.mybatisplus.extension.activerecord.Model;
import java.time.LocalDateTime;
import com.baomidou.mybatisplus.annotation.TableLogic;
import java.io.Serializable;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

/**
 * <p>
 * 用户表
 * </p>
 *
 * @author cczhaoyc@163.com
 * @since 2020-08-01
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
public class SuxiaUser extends Model<SuxiaUser> {

    private static final long serialVersionUID = 1L;

    /**
     * 用户ID
     */
    private Long userId;

    /**
     * 文件ID(图片)
     */
    private Long fileId;

    /**
     * 五笔
     */
    private String wubi;

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
     * 说明
     */
    private String remark;

    /**
     * 拼音
     */
    private String pinyin;

    /**
     * 停用标志（0:在用 1:停用）
     */
    private Boolean isStopped;

    /**
     * 是否删除(0:否 1:是)
     */
    @TableLogic
    private Boolean isDeleted;

    /**
     * 创建人
     */
    private Long createdUserId;

    /**
     * 创建时间
     */
    private LocalDateTime createdTime;

    /**
     * 最后更新人
     */
    private Long updateUserId;

    /**
     * 最后更新时间
     */
    private LocalDateTime updateTime;


    @Override
    protected Serializable pkVal() {
        return this.userId;
    }

}
