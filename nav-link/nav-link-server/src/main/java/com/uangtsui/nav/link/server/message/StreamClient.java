package com.uangtsui.nav.link.server.message;

import org.springframework.cloud.stream.annotation.Input;
import org.springframework.cloud.stream.annotation.Output;
import org.springframework.messaging.MessageChannel;
import org.springframework.messaging.SubscribableChannel;

public interface StreamClient {

    String INPUT = "myMessageInput";
    String OUTPUT = "myMessageOutput";

    String INPUT_NEW = "myMessageInputNew";
    String OUTPUT_NEW = "myMessageOutputNew";

    @Input(StreamClient.INPUT)
    SubscribableChannel input();

    @Output(StreamClient.OUTPUT)
    MessageChannel output();

    @Input(StreamClient.INPUT_NEW)
    SubscribableChannel inputNew();

    @Output(StreamClient.OUTPUT_NEW)
    MessageChannel outputNew();
}
