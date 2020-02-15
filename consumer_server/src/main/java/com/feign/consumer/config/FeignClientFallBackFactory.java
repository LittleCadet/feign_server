package com.feign.consumer.config;

import com.feign.consumer.exception.BusinessException;
import com.feign.consumer.feign.ProviderService;
import feign.hystrix.FallbackFactory;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

/**
 * FallBackFactory比FallBack的优势：前者更加灵活，比如根据不同的异常，返回不同的自定义的结果
 *
 *
 * @Author LittleCadet
 * @Date 2020/2/14
 */
@Slf4j
@Component
public class FeignClientFallBackFactory implements FallbackFactory<ProviderService>
{
    public ProviderService create(Throwable throwable)
    {
        final Throwable exception = throwable;

        return new ProviderService()
        {
            public String showInfo()
            {
                log.error("feign调用异常：couse:{}" ,exception);
                /*throw new BusinessException(10000,"10000","自定义异常");*/

                if(exception instanceof BusinessException){
                    return "消费者的hystrix的默认回退：BusinessException";
                }else{
                    return "消费者的hystrix的默认回退:hystrixTimeOutException";
                }
            }
        };
    }
}
