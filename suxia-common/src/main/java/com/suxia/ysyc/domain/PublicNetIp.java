package com.suxia.ysyc.domain;

import lombok.Data;

import java.io.Serializable;

/**
 * <p>
 * 获取本机外网ip {"cip": "127.0.0.1", "cid": "330000", "cname": "浙江省"}
 * </p>
 *
 * @author cczhaoyc@163.com
 * @version v_1.0.0
 * @date 2020/8/9 13:39
 */
@Data
public class PublicNetIp implements Serializable {

    private static final long serialVersionUID = 7545277716817455077L;

    private String cip;
    private String cid;
    private String cname;

}
