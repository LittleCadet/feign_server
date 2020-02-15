package com.feign.consumer.config;

import com.feign.consumer.exception.BusinessException;
import com.feign.consumer.feign.ProviderServiceV2;
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
public class FeignClientFallBackFactory implements FallbackFactory<ProviderServiceV2>
{
    public ProviderServiceV2 create(Throwable throwable)
    {
        final Throwable exception = throwable;
        return new ProviderServiceV2()
        {
            public String showInfo()
            {
                log.error("feign调用异常V2：couse:{}" ,exception);
                /*throw new BusinessException(10000,"10000","自定义异常");*/

                if(exception instanceof BusinessException){
                    return "消费者的hystrix的默认回退V2：BusinessException";
                }else{
                    return "消费者的hystrix的默认回退V2:hystrixTimeOutException";
                }
            }
        };
    }
}
