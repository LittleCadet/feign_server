package com.feign.consumer.controller;

import com.feign.consumer.exception.BusinessException;
import com.feign.consumer.feign.ProviderServiceV2;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import com.netflix.hystrix.exception.HystrixTimeoutException;
import feign.RequestLine;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author LittleCadet
 * @Date 2020/2/4
 */
@Slf4j
@RestController
@RequestMapping("/feign")
public class ConsumerController
{

    @Autowired
    private ProviderServiceV2 providerService;

    //用HystrixCommand执行回退方法，以及如果是忽略的异常，那么不执行回退方法
    @HystrixCommand(fallbackMethod = "defaultFallBack" , ignoreExceptions = {BusinessException.class} ,
                    commandProperties = {
                        //使用信号量隔离，当并发请求超过信号量个数限制的时候，回自动打开断路器开关【默认使用线程隔离：THREAD】
                        @HystrixProperty(name = "execution.isolation.strategy" , value = "SEMAPHORE")
                    })
    @GetMapping("/consumer")
    public String showInfo(){
        return providerService.showInfo();
    }

    @GetMapping("/consumer_v2")
    public String showInfoV2(){
        return providerService.showInfo();
    }

    public String defaultFallBack(Throwable throwable){
        log.error("feign调用异常V2：" + throwable);
        throw new BusinessException(10000,"10000","自定义异常V2");
        /*return "消费者的hystrix的默认回退";*/
    }

}
