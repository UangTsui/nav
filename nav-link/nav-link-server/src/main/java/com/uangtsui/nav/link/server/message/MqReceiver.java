package com.uangtsui.nav.link.server.message;

import org.springframework.amqp.rabbit.annotation.Exchange;
import org.springframework.amqp.rabbit.annotation.Queue;
import org.springframework.amqp.rabbit.annotation.QueueBinding;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

/**
 * 用户接收MQ的消息
 */
@Component
public class MqReceiver {

    // 1、需要到MQ中提前加入队列：myQueue
    // @RabbitListener(queues = "myQueue")
    // 2、自动创建队列
    // @RabbitListener(queuesToDeclare = @Queue("myQueue"))
    // 3、自动创建队列，Exchange和Queue绑定
    /*@RabbitListener(bindings = @QueueBinding(
            value = @Queue("myQueue"),
            exchange = @Exchange("myExchange")
    ))*/
    // 4、消息分组
    @RabbitListener(bindings = @QueueBinding(
            value = @Queue("myQueue"),
            key = "my",
            exchange = @Exchange("myExchange")
    ))
    public void process(String message){
        System.out.println(message);
    }
}
