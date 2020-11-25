package chenjiajin.controller;

import chenjiajin.feign.FeignTest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("feign_test")
public class TestController {

    /**
     * 注入feign
     */
    @Autowired
    private FeignTest feignTest;

    /**
     * 通过feign来获取接口数据
     * @return
     */
    @GetMapping("get_names")
    public Object get(){
        return feignTest.getNames();
    }
}
