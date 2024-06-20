package com.example.cache;


import com.example.unit.ApplicationContextUtils;
import org.apache.ibatis.cache.Cache;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.serializer.GenericJackson2JsonRedisSerializer;
import org.springframework.data.redis.serializer.StringRedisSerializer;

public class RedisCache implements Cache {
    private final String id;

    public RedisCache(String id) {
        this.id = id;
    }

    //返回缓存ID
    @Override
    public String getId() {
        return this.id;
    }

    //缓存放入
    @Override
    public void putObject(Object key, Object value) {
        // TODO: implement Redis cache put
//        System.out.println("Redis cache put: " + key + " = " + value);
        getRedisTemplate().opsForHash().put(id.toString(),key.toString(), value);
    }

    //缓存取出
    @Override
    public Object getObject(Object key) {
        // TODO: implement Redis cache get
        //使用redishash类型作为缓存类型
//        System.out.println("Redis cache get: " + key);
        return getRedisTemplate().opsForHash().get(id.toString(),key.toString());
    }

    @Override
    public Object removeObject(Object key) {
        // TODO: implement Redis cache remove 指定key的缓存 默认没有实现
        return null;
    }

    @Override
    public void clear() {
        // TODO: implement Redis cache clear
        //清空namespace下的所有缓存
        getRedisTemplate().delete(id.toString());
    }

    @Override
    public int getSize() {
        // TODO: implement Redis cache size 计算缓存大小
        //获取namespace下的缓存数量
        return getRedisTemplate().opsForHash().size(id.toString()).intValue();
    }

    private RedisTemplate getRedisTemplate() {
        RedisTemplate redisTemplate = (RedisTemplate) ApplicationContextUtils.getBean("redisTemplate");
        redisTemplate.setKeySerializer(new StringRedisSerializer());
        redisTemplate.setValueSerializer(new StringRedisSerializer());
        return redisTemplate;
    }
}
