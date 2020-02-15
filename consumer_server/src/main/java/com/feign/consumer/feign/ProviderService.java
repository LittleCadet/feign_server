package com.feign.consumer.feign;

import com.feign.consumer.config.FeignClientFallBack;
import com.feign.consumer.config.FeignClientFallBackFactory;
import com.feign.consumer.config.FeignConfig;
import feign.RequestLine;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

/**
 * @Author LittleCadet
 * @Date 2020/2/4
 */
//hystrix的回退在controller中用@HystrixCommond注解中使用
//@FeignClient(name = "feign-provider",configuration = {FeignConfig.class} )
//hystrix的回退用fallback回退
//@FeignClient(name = "feign-provider",configuration = {FeignConfig.class} , fallback = FeignClientFallBack.class)
//hystrix的回退用fallbackFactory回退
@FeignClient(name = "feign-provider",configuration = {FeignConfig.class} , fallbackFactory = FeignClientFallBackFactory.class)
public interface ProviderService
{

    //@PostMapping("/feign/provider")
    @RequestLine("POST /feign/provider")
    String showInfo();
}
