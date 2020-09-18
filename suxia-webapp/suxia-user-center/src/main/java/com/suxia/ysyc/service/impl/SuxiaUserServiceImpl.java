package com.suxia.ysyc.service.impl;

import cn.hutool.core.lang.Snowflake;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.suxia.ysyc.domain.SuxiaUser;
import com.suxia.ysyc.dto.SuxiaUserDTO;
import com.suxia.ysyc.exception.BusinessException;
import com.suxia.ysyc.exception.enums.BusinessExceptionEnum;
import com.suxia.ysyc.mapper.SuxiaUserMapper;
import com.suxia.ysyc.service.SuxiaUserService;
import com.suxia.ysyc.vo.SuxiaUserVO;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 用户表 服务实现类
 * </p>
 *
 * @author cczhaoyc@163.com
 * @since 2020-08-07
 */
@Service
public class SuxiaUserServiceImpl extends ServiceImpl<SuxiaUserMapper, SuxiaUser> implements SuxiaUserService {

    @Autowired
    private Snowflake snowflake;

    @Override
    public SuxiaUserVO addSuxiaUser(SuxiaUserDTO userDTO) {
        if (StringUtils.isBlank(userDTO.getUsername())) {
            throw new BusinessException(BusinessExceptionEnum.EX_80001);
        }
        SuxiaUser user = new SuxiaUser();
        BeanUtils.copyProperties(userDTO, user);
        user.setUserId(snowflake.nextId());
        this.save(user);

        SuxiaUserVO userVO = new SuxiaUserVO();
        BeanUtils.copyProperties(user, userVO);
        return userVO;
    }
}
