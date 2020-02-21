package com.feign.provider;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

/**
 * @Author LittleCadet
 * @Date 2020/2/4
 */
@EnableFeignClients
@SpringBootApplication
public class FeignProviderApplicationV3
{
    public static void main(String[] args)
    {
        SpringApplication.run(FeignProviderApplicationV3.class,args);
    }
}
