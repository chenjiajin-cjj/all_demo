package chenjiajin.utils.impl;

import chenjiajin.utils.RedisTemplates;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.Set;
import java.util.concurrent.TimeUnit;

/**
 * 懒得写了，参考文档 ：
 * https://blog.csdn.net/weixin_43835717/article/details/92802040
 */
@Service
public class RedisTemplatesImpl implements RedisTemplates {
    //        TimeUnit.DAYS          //天
    //        TimeUnit.HOURS         //小时
    //        TimeUnit.MINUTES       //分钟
    //        TimeUnit.SECONDS       //秒
    //        TimeUnit.MILLISECONDS  //毫秒
    private static Logger LOG = LoggerFactory.getLogger(RedisTemplatesImpl.class);

    @Autowired
    private RedisTemplate<String, Object> redis;

    /**
     * 存储String到redis中
     *
     * @param key
     * @param val
     * @return
     */
    @Override
    public void set(String key, String val) {
        redis.opsForValue().set(key, val);
    }

    /**
     * 存储任意类型到redis中
     *
     * @param key
     * @param val
     * @return
     */
    @Override
    public void set(String key, Object val) {
        redis.opsForValue().set(key, val);
    }

    /**
     * 根据timeunit来设置key的过期时间
     *
     * @param key
     * @param val
     * @param time
     */
    @Override
    public void set(String key, Object val, Integer time) {
        redis.opsForValue().set(key, val, time, TimeUnit.MILLISECONDS);
    }

    /**
     * 给key添加随机过期时间，默认24大于小时整
     *
     * @param key
     * @return
     */
    @Override
    public boolean setKeyTime(String key) {
        return redis.expire(key, new Random().nextInt(99999999) + 99999999 + 86400000, TimeUnit.MILLISECONDS);
    }

    /**
     * 给key灵活的设置过期时间
     *
     * @param key
     * @return
     */
    @Override
    public boolean setKeyTime(String key, Integer time, TimeUnit timeUnit) {
        return redis.expire(key, time, timeUnit);
    }

    /**
     * 给key设置自增1
     *
     * @param key
     */
    @Override
    public boolean incrKey(String key) {
        if (isInteger(key)) {
            redis.opsForValue().increment(key);
            return true;
        }
        LOG.error("key：" + key + ",自增1失败，因为这原本的值不是个整数类型");
        return false;
    }

    /**
     * 给key设置自增的值
     *
     * @param key
     * @param val
     */
    @Override
    public void incrKey(String key, Double val) {
        redis.opsForValue().increment(key, val);
    }

    /**
     * 给key设置自增的值
     *
     * @param key
     * @param val
     */
    @Override
    public boolean incrKey(String key, Integer val) {
        if (isInteger(key)) {
            redis.opsForValue().increment(key, val);
            return true;
        }
        LOG.error("key：" + key + ",自增:" + val + "失败，因为这原本的值不是个整数类型");
        return false;
    }

    /**
     * 获取key的值
     *
     * @param key
     * @return
     */
    @Override
    public Object get(String key) {
        return redis.opsForValue().get(key);
    }

    /**
     * 给指定key自减1
     *
     * @param key
     */
    @Override
    public boolean decrKey(String key) {
        if (isInteger(key)) {
            redis.opsForValue().decrement(key);
            return true;
        }
        LOG.error("key：" + key + ",自减1失败，因为这原本的值不是个整数类型");
        return false;
    }

    /**
     * 给指定key自减指定数值
     *
     * @param key
     * @param val
     */
    @Override
    public boolean decrKey(String key, Integer val) {
        if (isInteger(key)) {
            redis.opsForValue().decrement(key, val);
            return true;
        }
        LOG.error("key：" + key + ",自减:" + val + "失败，因为这原本的值不是个整数类型");
        return false;
    }

    /**
     * 删除指定key
     *
     * @param key
     * @return
     */
    @Override
    public boolean deleteKey(String key) {
        return redis.delete(key);
    }

    /**
     * 通过批量的key获取批量的val
     *
     * @param key
     * @return
     */
    @Override
    public List<Object> mGet(List<String> key) {
        return redis.opsForValue().multiGet(key);
    }

    /**
     * 批量插入
     *
     * @param map
     * @return
     */
    @Override
    public boolean mSet(Map<String, Object> map) {
        return redis.opsForValue().multiSetIfAbsent(map);
    }

    /**
     * 从右边（末尾）添加一个值到list中
     *
     * @param key
     * @param val
     */
    @Override
    public Long rPush(String key, Object val) {
        Long a = redis.opsForList().rightPush(key, val);
//        setKeyTime(key);
        return a;
    }

    /**
     * 从右边（末尾）添加很多值到list中
     *
     * @param key
     * @param val
     * @return
     */
    @Override
    public Long rPush(String key, List<Object> val) {
        long a = redis.opsForList().rightPushAll(key, val);
//        setKeyTime(key);
        return a;
    }

    /**
     * 获取指定区域内的list的数据
     *
     * @param key
     * @param page
     * @param pageSize 0 -1 代表获取全部数据 0 2 代表获取三条数据 分别是下标为 0 1 2 的三条数据
     * @return
     */
    @Override
    public List<Object> lRange(String key, Integer page, Integer pageSize) {
        if (null == page || null == pageSize) {
            page = 0;
            pageSize = -1;
        }
        return redis.opsForList().range(key, page, pageSize);
    }

    /**
     * 获取集合左边第一个数据并删除，如果没有数据，则删除整个集合
     *
     * @param key
     * @return
     */
    @Override
    public Object lPop(String key) {
        return redis.opsForList().leftPop(key);
    }

    /**
     * 在规定时间内取出数值，如果有数值就取出并且返回，否则就没有
     *
     * @param key
     * @param time
     * @return
     */
    @Override
    public Object lPop(String key, Integer time) {
        return redis.opsForList().leftPop(key, time, TimeUnit.MILLISECONDS);
    }

    /**
     * 添加值到map里
     * @param key
     * @param map
     */
    @Override
    public void hSet(String key, Map<String, Object> map) {
        redis.opsForHash().putAll(key,map);
    }

    /**
     * 获取指定key里面的所有map
     * @param key
     * @return
     */
    @Override
    public Map<Object, Object> hGetAll(String key) {
        return redis.opsForHash().entries(key);
    }

    /**
     * 获取指定map里指定key的指定值
     * @param key
     * @param field
     * @return
     */
    @Override
    public Object hGet(String key, String field) {
        return redis.opsForHash().get(key,field);
    }

    /**
     * 获取指定map里所有的key
     * @param key
     * @return
     */
    @Override
    public Set<Object> hKeys(String key) {
        return redis.opsForHash().keys(key);
    }

    /**
     * 获取指定map里所有的val
     * @param key
     * @return
     */
    @Override
    public List<Object> hVals(String key) {
        return redis.opsForHash().values(key);
    }

    /**
     * 对指定的key自增1
     * @param key
     * @param field
     */
    @Override
    public boolean hIncr(String key, String field) {
        redis.opsForHash().increment(key,field,1);
        return true;
    }

    /**
     * 对指定key值自增指定数值
     * @param key
     * @param field
     * @param number
     */
    @Override
    public boolean hIncr(String key, String field, Integer number) {
        if(number < 0){
            LOG.error("请输入大于0的数值");
            return false;
        }
        redis.opsForHash().increment(key,field,number);
        return true;
    }

    /**
     * 对指定key值自减1
     * @param key
     * @param field
     */
    @Override
    public boolean hDecr(String key, String field) {
        redis.opsForHash().increment(key,field,-1);
        return true;
    }

    /**
     * 对指定key的值自减指定数值
     * @param key
     * @param field
     * @param number
     */
    @Override
    public boolean hDecr(String key, String field, Integer number) {
        if(number < 0){
            LOG.error("请输入大于0的数值");
            return false;
        }
        redis.opsForHash().increment(key,field,-number);
        return true;
    }

    /**
     * 删除指定的键值
     * @param key
     * @param field
     */
    @Override
    public void hDelete(String key, String field) {
        redis.opsForHash().delete(key,field);
    }


    /**
     * 判断是否为整数
     *
     * @param key
     * @return
     */
    private boolean isInteger(String key) {
        Object val = get(key);
        if (val instanceof Integer || val instanceof Long || val instanceof Byte || val instanceof Short) {
            return true;
        }
        return false;
    }
}
