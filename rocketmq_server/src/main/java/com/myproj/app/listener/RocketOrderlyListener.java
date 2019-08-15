package com.myproj.app.listener;

import com.myproj.app.service.RocketOrderlyService;
import lombok.extern.slf4j.Slf4j;
import org.apache.rocketmq.client.consumer.listener.*;
import org.apache.rocketmq.common.message.MessageExt;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.concurrent.TimeUnit;

/**
 * rocket 监听器
 *
 */
@Slf4j
public class RocketOrderlyListener implements MessageListenerOrderly
{
    @Autowired
    private RocketOrderlyService rocketService;

    @Override
    public ConsumeOrderlyStatus consumeMessage(List<MessageExt> list, ConsumeOrderlyContext consumeOrderlyContext)
    {
        log.info("Consume message: {}", list.size());

        //批量消费，保证吞吐量
        for (MessageExt msg : list)
        {
            String text = new String(msg.getBody());
            rocketService.getMwssage(text, msg.getTags());
        }

        return ConsumeOrderlyStatus.SUCCESS;
    }

}
