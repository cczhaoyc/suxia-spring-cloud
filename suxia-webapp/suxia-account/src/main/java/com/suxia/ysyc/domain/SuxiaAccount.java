package com.suxia.ysyc.domain;

import java.math.BigDecimal;
import com.baomidou.mybatisplus.extension.activerecord.Model;
import java.time.LocalDateTime;
import com.baomidou.mybatisplus.annotation.TableLogic;
import java.io.Serializable;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

/**
 * <p>
 * 账户表
 * </p>
 *
 * @author cczhaoyc@163.com
 * @since 2020-08-07
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
public class SuxiaAccount extends Model<SuxiaAccount> {

    private static final long serialVersionUID = 1L;

    /**
     * 账户Id
     */
    private Long accountId;

    /**
     * 用户Id
     */
    private String userId;

    /**
     * 金额
     */
    private BigDecimal money;

    /**
     * 说明
     */
    private String remark;

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
        return this.accountId;
    }

}
