package com.myproj.app.rocket;

import com.myproj.app.candp.RocketMessageProducer;
import com.myproj.app.constant.RocketConstants;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * @Author LittleCadet
 * @Date 2019/8/15
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class RocketTest
{
    @Autowired
    private RocketMessageProducer producer;

    @Test
    public void send() throws InterruptedException
    {
        for(int i = 1 ;i <= 5; i++){
            producer.sendAsync(RocketConstants.TOPIC_ROCKET, RocketConstants.TAG_ROCKET, "send " + i + " message");
        }

        Thread.sleep(10_000L);
    }
}
