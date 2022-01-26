package com.atguigu.springcloud.service.lmpl;

import cn.hutool.Hutool;
import com.atguigu.springcloud.service.IMessageProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.messaging.Source;
import org.springframework.messaging.MessageChannel;
import org.springframework.messaging.support.MessageBuilder;

import java.util.UUID;

/**
 * @Date And @Time: 2022/1/23  23:06
 */
@EnableBinding({Source.class})
public class MessageProviderlmpl implements IMessageProvider {

    @Autowired
    private MessageChannel output;

    @Override
    public String send() {
        String substring = UUID.randomUUID().toString().substring(0, 5);
        output.send(MessageBuilder.withPayload(substring).build());
        System.out.println("send:"+substring);
        return null;
    }
}
