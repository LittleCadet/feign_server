package com.myproj.app.eventbus.service;

import com.alibaba.fastjson.JSON;
import com.google.common.eventbus.AllowConcurrentEvents;
import com.google.common.eventbus.Subscribe;
import com.myproj.app.eventbus.entity.Message;
import com.myproj.app.eventbus.entity.Messages;
import lombok.extern.slf4j.Slf4j;


/**
 * @author The flow developers
 */
@Slf4j
public class SendMessageImpl {

    /**
     * 1.eventBus会向所有的订阅者发送订阅的内容，同一种订阅者之间没有先后关系，不同种的订阅顺序是随着post的顺序的确定而确定。
     * 2.subscribe的方法有且只能有一个参数，多参会在启动加载eventBus的resiter方法时，报错：无法进入其内部的注册表
     * 3.订阅者不要设置返回值，即使设置了，也没有用，因为发布者没有直接调用订阅者，订阅者的返回值需要通过DefferredResult获得。
     *
     * 订阅者：被观察者
     */
    @Subscribe
    @AllowConcurrentEvents
    public void sendMassage(Message message){

        message.getOutput().setResult("successed to get result from message!");
        System.out.println(Thread.currentThread().getName()+"=========message:" + JSON.toJSONString(message));
    }

    /**
     * 订阅者：被观察者
     */
    @Subscribe
    @AllowConcurrentEvents
    public void sendMassage2(Message message){

        message.getOutput().setResult("successed to get result from message2!");
        System.out.println(Thread.currentThread().getName()+"=========second message:" + JSON.toJSONString(message));
    }

    /**
     * 订阅者：被观察者
     */
    @Subscribe
    @AllowConcurrentEvents
    public void sendMassages(Messages messages){

        messages.getOutput().setResult("successed to get result from messages!");
        System.out.println(Thread.currentThread().getName()+"=========messages:" + JSON.toJSONString(messages));

    }

}
