package chenjiajin.controller;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("test")
public class TestHystrixController {

    /**
     * 熔断处理的主方法
     * 熔断的方法必须和备用方法的方法名和入参值数和顺序都要一样
     * @param json
     * @return
     */
    @PostMapping("test_hystrix")
    @HystrixCommand(fallbackMethod  = "testHystrix")
    public Object getWay(@RequestBody String json){

        Map<String, Object> msg = new HashMap<>();
        msg.put("code", 1);
        msg.put("msg", "抢到了");
        int a = 1/0;
        return msg;
    }

    /**
     * 熔断处理的备用方法
     * 方法名和入参和入参顺序要和主方法一模一样
     * @param json
     * @return
     */
    private Object testHystrix(String json){
        //监控报警
        Map<String, Object> msg = new HashMap<>();
        msg.put("code", -1);
        msg.put("msg", "抢购人数太多，您被挤出来了，稍等重试");
        return msg;
    }
}
