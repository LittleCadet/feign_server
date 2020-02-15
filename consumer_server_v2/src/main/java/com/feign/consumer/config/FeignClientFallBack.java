package com.feign.consumer.config;

import com.feign.consumer.exception.BusinessException;
import com.feign.consumer.feign.ProviderServiceV2;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

/**
 * @Author LittleCadet
 * @Date 2020/2/14
 */
@Slf4j
@Component
public class FeignClientFallBack implements ProviderServiceV2
{

    public String showInfo()
    {
        log.error("feign调用异常V2：");
        /*throw new BusinessException(10000,"10000","自定义异常");*/
        return "消费者的hystrix的默认回退V2";
    }
}
