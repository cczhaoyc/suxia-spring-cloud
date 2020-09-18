package com.suxia.ysyc.common.stream;

import org.springframework.cloud.stream.annotation.Input;
import org.springframework.cloud.stream.annotation.Output;
import org.springframework.messaging.MessageChannel;
import org.springframework.messaging.SubscribableChannel;

/**
 * <p>
 * 自定义消息通道，包含一个生产者通道，一个消费者通道
 * </p>
 *
 * @author cczhaoyc@163.com
 * @version v_1.0.0
 * @date 2020/9/4 9:44
 */
public interface IProcessor {

    /**
     * 输出通道的名称，对应yml配置文件中spring.stream.bindings.output-order，名称必须相同
     */
    String OUTPUT_ORDER = "output-order";

    /**
     * @return 输出通道，即生产者通道
     */
    @Output(IProcessor.OUTPUT_ORDER)
    MessageChannel outputOrder();

    /**
     * 输入通道的名称，对应yml配置文件中spring.stream.bindings.input-order，名称必须相同
     */
    String INPUT_ORDER = "input-order";

    /**
     * @return 输入通道，即消费者通道
     */
    @Input(IProcessor.INPUT_ORDER)
    SubscribableChannel inputOrder();

}
