package com.uangtsui.nav.link.server.message;

import com.uangtsui.nav.link.server.model.entity.BoyEntity;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Component;

@Component
@EnableBinding(StreamClient.class)
public class StreamReceiver {

    /**
     * 接收端
     * @param boyEntity
     */
    @StreamListener(value = StreamClient.OUTPUT)
    @SendTo(StreamClient.OUTPUT_NEW)
    public String process(BoyEntity boyEntity) {
        System.out.println(boyEntity.getName());
        return "回复消息";
    }

    @StreamListener(value = StreamClient.OUTPUT_NEW)
    public void process(String message) {
        System.out.println(message);
    }
}
