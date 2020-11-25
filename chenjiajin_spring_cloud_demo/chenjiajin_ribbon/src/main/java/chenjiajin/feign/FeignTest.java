package chenjiajin.feign;

import chenjiajin.hystrix.HystrixTest;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * feign
 * 获得其他工程的数据
 */
//先在注册中心获得服务名         后面指定调用服务失败走的类

@FeignClient(name = "product-service",fallback = HystrixTest.class)
public interface FeignTest {

    @GetMapping("/product/get_product_name")//获得对应接口名
    String getNames();//获得返回值
}
