package com.suxia.ysyc.service;

import com.suxia.ysyc.domain.SuxiaUser;
import com.baomidou.mybatisplus.extension.service.IService;
import com.suxia.ysyc.dto.SuxiaUserDTO;
import com.suxia.ysyc.vo.SuxiaUserVO;

/**
 * <p>
 * 用户表 服务类
 * </p>
 *
 * @author cczhaoyc@163.com
 * @since 2020-08-07
 */
public interface SuxiaUserService extends IService<SuxiaUser> {

    /**
     * <p>
     * 新增用户
     * </p>
     *
     * @author cczhaoyc@163.com
     * @date 2020/9/11 14:24
     */
    SuxiaUserVO addSuxiaUser(SuxiaUserDTO userDTO);
}
