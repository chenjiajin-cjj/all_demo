package chenjiajin.utils;


import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.TimeUnit;

/**
 * 懒得写了，参考文档 ：
 * https://blog.csdn.net/weixin_43835717/article/details/92802040
 */
public interface RedisTemplates {

    /**
     * 存储String到redis中
     *
     * @param key
     * @param val
     * @return
     */
    void set(String key, String val);

    /**
     * 存储任意类型到redis中
     *
     * @param key
     * @param val
     * @return
     */
    void set(String key, Object val);

    /**
     * 根据timeunit来设置key的过期时间
     *
     * @param key
     * @param val
     * @param time
     */
    void set(String key, Object val, Integer time);

    /**
     * 额外给key添加过期时间，默认24大于小时整
     *
     * @param key
     * @return
     */
    boolean setKeyTime(String key);

    /**
     * 给key灵活的设置过期时间
     *
     * @param key
     * @return
     */
    boolean setKeyTime(String key, Integer time, TimeUnit timeUnit);

    /**
     * 给key设置自增1
     *
     * @param key
     */
    boolean incrKey(String key);

    /**
     * 给key设置自增的值
     *
     * @param key
     * @param val
     */
    void incrKey(String key, Double val);

    /**
     * 给key设置自增的值
     *
     * @param key
     * @param val
     */
    boolean incrKey(String key, Integer val);

    /**
     * 获取key的值
     *
     * @param key
     * @return
     */
    Object get(String key);

    /**
     * 给指定key自减1
     *
     * @param key
     */
    boolean decrKey(String key);

    /**
     * 给指定key自减指定数值
     *
     * @param key
     */
    boolean decrKey(String key, Integer val);

    /**
     * 删除指定key
     *
     * @param key
     * @return
     */
    boolean deleteKey(String key);

    /**
     * 通过批量的key获取批量的val
     * String = key
     *
     * @return
     */
    List<Object> mGet(List<String> key);

    /**
     * 批量插入
     * String = key
     * Object = val
     *
     * @return
     */
    boolean mSet(Map<String, Object> map);

    /**
     * 从右边（末尾）添加一个值到list中
     *
     * @param key
     * @param val
     */
    Long rPush(String key, Object val);

    /**
     * 从右边（末尾）添加很多值到list中
     *
     * @param key
     * @param val
     */
    Long rPush(String key, List<Object> val);

    /**
     * 获取指定区域内的list的数据
     *
     * @param key
     * @param page
     * @param pageSize 0 -1 代表获取全部数据 0 2 代表获取三条数据 分别是下标为 0 1 2 的三条数据
     * @return
     */
    List<Object> lRange(String key, Integer page, Integer pageSize);

    /**
     * 获取集合左边第一个数据并删除，如果没有数据，则删除整个集合
     *
     * @param key
     * @return
     */
    Object lPop(String key);

    /**
     * 在规定的毫秒时间内取出数值，如有取出就删除并返回，否则没有
     * @param key
     * @param time
     * @return
     */
    Object lPop(String key,Integer time);

    /**
     * 添加值到map里
     * @param key
     * @param map
     */
    void hSet(String key,Map<String,Object> map);

    /**
     * 获取指定key里面的所有map
     * @param key
     * @return
     */
    Map<Object,Object> hGetAll(String key);

    /**
     * 获取指定map里指定key的值
     * @param key
     * @param field
     * @return
     */
    Object hGet(String key,String field);

    /**
     * 获取指定map里的所有key
     * @param key
     * @return
     */
    Set<Object> hKeys(String key);

    /**
     * 获取指定map里所有的val
     *
     * @param key
     * @return
     */
    List<Object> hVals(String key);

    /**
     * 对指定的key的值自增1
     * @param key
     * @param field
     */
    boolean hIncr(String key,String field);

    /**
     * 对指定的key自增指定数值
     * @param key
     * @param field
     * @param number
     */
    boolean hIncr(String key,String field,Integer number);

    /**
     * 对指定key的值自减1
     * @param key
     * @param field
     */
    boolean hDecr(String key,String field);
    /**
     * 对指定key的值自减指定数值
     * @param key
     * @param field
     */
    boolean hDecr(String key,String field,Integer number);

    /**
     * 删除指定的键值
     * @param key
     * @param field
     */
    void hDelete(String key,String field);
}
