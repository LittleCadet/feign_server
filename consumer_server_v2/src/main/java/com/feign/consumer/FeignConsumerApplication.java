package com.feign.consumer;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.hystrix.EnableHystrix;
import org.springframework.cloud.netflix.hystrix.dashboard.EnableHystrixDashboard;
import org.springframework.cloud.openfeign.EnableFeignClients;

/**
 * @Author LittleCadet
 * @Date 2020/2/4
 */
@EnableFeignClients
@SpringBootApplication
public class FeignConsumerApplication
{

    public static void main(String[] args)
    {
        SpringApplication.run(FeignConsumerApplication.class,args);
    }
}
