package chenjiajin.concurrency.service.impl;

import chenjiajin.concurrency.domain.OrderId;
import chenjiajin.concurrency.service.IGetAllOrderService;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.util.*;
import java.util.concurrent.*;

@Service
public class GetAllOrderServiceImpl implements IGetAllOrderService {


    //阻塞队列 把并发的1000个请求组装成若各干请求直接发送给远程第三方接口
    LinkedBlockingQueue<OrderId> queue = new LinkedBlockingQueue<>();

    @Override
    public Map<String, Object> getAllOrder() throws Exception {
        //TODO 还不算正式调用查询接口 组装进去和返回的标识id  如果有入参 也可以塞进去 到时候再查询接口拿出来
        OrderId orderId = new OrderId();
        orderId.setId(UUID.randomUUID().toString());
        CompletableFuture<Map<String, Object>> future = new CompletableFuture<>();
        orderId.setFuture(future);
        //把接收到前端的参数 把请求参数放到阻塞队列里头
        queue.add(orderId);
        //不断监听自己的线程有没有返回值： 阻塞
        Map<String, Object> map = future.get();
        return map;
    }

    public List<Map<String, Object>> getAllStudent(List<Map<String, String>> params) {
        // TODO 假装操作数据库拿到数据了
        List<Map<String, Object>> result = new ArrayList<>();
        for (Map<String, String> param : params) {
            HashMap<String, Object> hashMap = new HashMap<String, Object>();
            hashMap.put("studentId", new Random().nextInt(9999));
            hashMap.put("id", param.get("id"));
            hashMap.put("商品名", "陈嘉劲");
            hashMap.put("时间", new Date());
            result.add(hashMap);
        }
        return result;
    }

    /**
     * 监听阻塞队列
     */
    @PostConstruct
    public void init() {
        /**
         * 声明定时任务池
         * 第一个参数是线程
         * 第二个如果是0代表启动项目的时候执行 如果是1000  根据第四个参数的单位 代表启动1000毫秒后执行
         * 第三个参数每间隔多久执行一次 由于单位是毫秒 所以代表每10毫秒执行一次
         * 第四个参数是单位 毫秒 和前两个相关联
         */
        ScheduledExecutorService scheduled = Executors.newScheduledThreadPool(1);
        scheduled.scheduleAtFixedRate(() -> {
            int size = queue.size();
            if (size > 0) {
                //拼装批量的请求参数，根据接口来拼装
                List<OrderId> requests = new ArrayList<>();
                List<Map<String, String>> params = new ArrayList<>();
                for (int i = 0; i < size; i++) {
                    //取出阻塞队列的数据
                    OrderId orderId = queue.poll();
                    requests.add(orderId);
                    //拼装批量参数
                    Map<String, String> map = new HashMap<>();
                    map.put("id", orderId.getId());
                    params.add(map);
                }
                System.out.println("批量处理数据:" + size);
                //批量的去请求接口得到返回值  到这里才算是真正的调用了接口
                List<Map<String, Object>> reponses = getAllStudent(params);
                for (OrderId orderId : requests) {
                    //请求前的唯一id
                    String id = orderId.getId();
                    for (Map<String, Object> reponse : reponses) {
                        //如果请求前的id和返回结果后回来的id一样，那么就可以返回到原先的请求的地址过去
                        if (id.equals(reponse.get("id").toString())) {
                            //相当于 把请求到的值返回回去
                            //对应   future.get()
                            orderId.getFuture().complete(reponse);
                            //但是方法体不会return 也没必要接着匹配 所以
                            break;
                        }
                    }
                }
            }
        }, 0, 10, TimeUnit.MILLISECONDS);
    }
}
