package chenjiajin.controller;

import chenjiajin.dbtest.entity.OrerInfo;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

@RestController
@RequestMapping("/redis")
public class RedisController {


    @Resource
    private RedisTemplate<String, Object> redisTemplate;



    @GetMapping("/string/string")
    public Object stringRedis() throws Exception {
        redisTemplate.opsForValue().set("tt", "val");
        redisTemplate.expire("tt",20000, TimeUnit.MILLISECONDS);
        System.out.println("333");
        return redisTemplate.opsForValue().get("tt");
    }

    @GetMapping("/string/object")
    public Object objectRedis() throws Exception {
        OrerInfo orerInfo = new OrerInfo();
        orerInfo.setOrderName("我是天才啊啊哈哈哈哈哈啊");
        redisTemplate.opsForValue().set("object", orerInfo);
        redisTemplate.expire("object",20000, TimeUnit.MILLISECONDS);
        return redisTemplate.opsForValue().get("object");
    }

    @GetMapping("/string/list")
    public Object listRedis() throws Exception {
        List<OrerInfo> list = new ArrayList<>();
        OrerInfo orerInfo = new OrerInfo();
        orerInfo.setOrderName("我是天才啊啊哈哈哈哈哈啊");
        list.add(orerInfo);
        orerInfo = new OrerInfo();
        orerInfo.setOrderName("陈嘉劲666666");
        list.add(orerInfo);
        redisTemplate.opsForValue().set("list", list);
        redisTemplate.expire("list",20000, TimeUnit.MILLISECONDS);
        return redisTemplate.opsForValue().get("list");
    }

    @GetMapping("/list/list")
    public Object listListRedis() throws Exception {
        List<OrerInfo> list = new ArrayList<>();
        OrerInfo orerInfo = new OrerInfo();
        orerInfo.setOrderName("我是天才啊啊哈哈哈哈哈啊");
        list.add(orerInfo);
        orerInfo = new OrerInfo();
        orerInfo.setOrderName("陈嘉劲666666");
        list.add(orerInfo);
        redisTemplate.opsForList().leftPush("listha", list);
        redisTemplate.expire("listha",20000, TimeUnit.MILLISECONDS);
        return redisTemplate.opsForList().range("listha",0,-1);
    }

    @GetMapping("/set/set")
    public Object setSetList() throws Exception {
        List<OrerInfo> list = new ArrayList<>();
        OrerInfo orerInfo = new OrerInfo();
        orerInfo.setOrderName("我是天才啊啊哈哈哈哈哈啊1");
        list.add(orerInfo);
        orerInfo = new OrerInfo();
        orerInfo.setOrderName("陈嘉劲666666");
        list.add(orerInfo);
        redisTemplate.opsForSet().add("setsa","ppp","ssss","222","dsasd",list);
        //设置key的过期时间，过期的时间单位为毫秒
        redisTemplate.expire("setsa",20000, TimeUnit.MILLISECONDS);
        return redisTemplate.opsForSet().members("setsa");
    }
}
