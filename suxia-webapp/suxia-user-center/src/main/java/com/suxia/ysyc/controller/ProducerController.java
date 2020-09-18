package com.suxia.ysyc.controller;

import com.suxia.ysyc.domain.RestResult;
import com.suxia.ysyc.producer.ProducerService;
import com.suxia.ysyc.vo.SuxiaUserVO;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.Message;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * <p>
 * 生产者消息
 * </p>
 *
 * @author cczhaoyc@163.com
 * @version v_1.0.0
 * @date 2020/9/1 17:28
 */
@RestController
@RequestMapping("/msg")
@Api(value = "生产者消息", tags = "生产者消息接口")
public class ProducerController {

    @Autowired
    private ProducerService producerService;

    @GetMapping("/send")
    public RestResult<Message<SuxiaUserVO>> send() {
        return RestResult.success(producerService.send());
    }
}
