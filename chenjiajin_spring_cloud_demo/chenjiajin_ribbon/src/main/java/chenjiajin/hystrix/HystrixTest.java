package chenjiajin.hystrix;

import chenjiajin.feign.FeignTest;
import org.springframework.stereotype.Component;

/**
 * 熔断
 * 针对商品服务，错降级处理
 */
@Component
public class HystrixTest implements FeignTest {
    @Override
    public String getNames() {
        System.out.println("feign 调用 product-service getNames 异常");
        return null;
    }
}
