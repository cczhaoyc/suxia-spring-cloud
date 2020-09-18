package com.suxia.ysyc.consumer;

import com.suxia.ysyc.common.stream.IProcessor;
import com.suxia.ysyc.exception.BusinessException;
import com.suxia.ysyc.vo.SuxiaUserVO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.messaging.Message;

/**
 * <p>
 * 消费者业务类
 * </p>
 *
 * @author cczhaoyc@163.com
 * @version v_1.0.0
 * @date 2020/9/1 16:58
 */
// 绑定消息通道
@EnableBinding(IProcessor.class)
@Slf4j
public class ConsumerService {

    // 监听IProcessor.INPUT_ORDER通道，即消费者
    @StreamListener(target = IProcessor.INPUT_ORDER)//, condition = "headers['amqp_deliveryTag']=='1001L'"
    public void input(Message<SuxiaUserVO> msg) {
        System.out.println("开始消费-----------------------------------------");
        try {
            int a = 1 / 0;
            log.info("消费者接收消息:" + msg.getPayload());
        } catch (Exception e) {
            log.error("未处理的消息:[" + msg + "]");
            log.error("消费未结束时发生异常：【" + e.getMessage() + "】");
            throw new BusinessException("消费未结束时发生异常：【" + e.getMessage() + "】");
        }
        log.info("结束消费-----------------------------------------");
    }
}
