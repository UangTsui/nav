package com.uangtsui.nav.link.server.message;

import com.uangtsui.nav.link.server.model.entity.BoyEntity;
import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 发送MQ消息
 */
@RestController
@RequestMapping("/mq")
public class MqSender {

    @Autowired
    private AmqpTemplate amqpTemplate;

    @Autowired
    private StreamClient streamClient;

    // 用于 MqReceiver 类的发送
    @GetMapping("send")
    public void send(){
        //amqpTemplate.convertAndSend("myQueue", "MQ Hello Word!");
        // 分组
        amqpTemplate.convertAndSend("myExchange","my","MQ Hello Word!");
    }

    // 用于 StreamReceiver 类的发送
    @GetMapping("sendStrean")
    public void sendStrean(){
        //streamClient.output().send(MessageBuilder.withPayload("sendStrean Hello Word!").build());
        BoyEntity boyEntity = new BoyEntity();
        boyEntity.setName("张三");
        boyEntity.setAge(18);
        streamClient.output().send(MessageBuilder.withPayload(boyEntity).build());
    }
}
