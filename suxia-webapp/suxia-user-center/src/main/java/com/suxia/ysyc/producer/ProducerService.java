package com.suxia.ysyc.producer;

import com.suxia.ysyc.vo.SuxiaUserVO;
import org.springframework.messaging.Message;

/**
 * <p>
 * 生产者消息接口
 * </p>
 *
 * @author cczhaoyc@163.com
 * @version v_1.0.0
 * @date 2020/9/1 17:09
 */
public interface ProducerService {

    /**
     * <p>
     * 发送消息
     * </p>
     *
     * @author cczhaoyc@163.com
     * @date 2020/9/4 10:06
     */
    Message<SuxiaUserVO> send();
}
