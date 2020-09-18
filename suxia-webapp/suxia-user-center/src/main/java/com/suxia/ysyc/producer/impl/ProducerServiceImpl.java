package com.suxia.ysyc.producer.impl;

import cn.hutool.core.lang.Snowflake;
import com.suxia.ysyc.common.stream.IProcessor;
import com.suxia.ysyc.producer.ProducerService;
import com.suxia.ysyc.vo.SuxiaUserVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.messaging.Message;
import org.springframework.messaging.MessageChannel;
import org.springframework.messaging.support.MessageBuilder;

import javax.annotation.Resource;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.util.Date;

/**
 * <p>
 * 生产者消息接口实现
 * </p>
 *
 * @author cczhaoyc@163.com
 * @version v_1.0.0
 * @date 2020/9/1 17:13
 */
@EnableBinding(IProcessor.class)// 绑定消息通道
public class ProducerServiceImpl implements ProducerService {

    // IProcessor.OUTPUT_ORDER为自定义输出通道，即生产者
    @Resource(name = IProcessor.OUTPUT_ORDER)
    private MessageChannel outputOrder;

    @Autowired
    private Snowflake snowflake;

    @Override
    public Message<SuxiaUserVO> send() {
        final SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String msg = "生产者发送消息:----->" + sdf.format(new Date());
        /*Message<String> message = MessageBuilder.withPayload(msg).build();
        outputOrder.send(message);*/

        SuxiaUserVO user = new SuxiaUserVO();
        user.setUsername(msg);
        user.setUserId(snowflake.nextId());
        user.setBirthday(LocalDateTime.now());
        user.setTelephone("155555555555");
        Message<SuxiaUserVO> userMessage = MessageBuilder.withPayload(user).build();
        outputOrder.send(userMessage);

        return userMessage;
    }

}
