package com.mdxq.mall.config;

import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.cache.RedisCacheConfiguration;
import org.springframework.data.redis.cache.RedisCacheManager;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.serializer.GenericJackson2JsonRedisSerializer;
import org.springframework.data.redis.serializer.RedisSerializationContext;
import org.springframework.data.redis.serializer.StringRedisSerializer;

import java.time.Duration;

@Configuration
@EnableCaching // Spring开启数据库缓存的开关
public class RedisConfig {

    // 注入一个Redis缓存管理到当前的Spring容器中，设置缓存的部分默认行为
    @Bean
    public RedisCacheManager cacheManager(RedisConnectionFactory factory) {
        RedisCacheConfiguration config = RedisCacheConfiguration.defaultCacheConfig()
                .entryTtl(Duration.ofMinutes(10))// 缓存默认10分钟过期
                // 设置键的序列化方式,会将key以utf-8的格式编码为字节数组，适用于Redis的键为字符串的情况
                .serializeKeysWith(RedisSerializationContext.SerializationPair.fromSerializer(new StringRedisSerializer()))
                // 设置值的序列化方式，委托Jackson框架以JSON格式对值进行序列化
                .serializeValuesWith(RedisSerializationContext.SerializationPair.fromSerializer(new GenericJackson2JsonRedisSerializer()));
        return RedisCacheManager.builder(factory)
                .build();
    }

    @Bean
    public RedisTemplate<String, Object> redisTemplate(RedisConnectionFactory factory) {
        RedisTemplate<String, Object> template = new RedisTemplate<>();// 实例化一个Redis模板类实例
        template.setConnectionFactory(factory);// 建立Redis连接

        // 设置键的序列化方式
        template.setKeySerializer(new StringRedisSerializer());
        // 设置值的序列化方式(委托Jackson框架来完成值的序列化，默认转换成JSON格式存储)
        template.setValueSerializer(new GenericJackson2JsonRedisSerializer());
        // 设置Hash键的序列化方式
        template.setHashKeySerializer(new StringRedisSerializer());
        // 设置Hash值的序列化方式
        template.setHashValueSerializer(new GenericJackson2JsonRedisSerializer());

        template.afterPropertiesSet();
        return template;// 返回设置完成的模板实例
    }

}
