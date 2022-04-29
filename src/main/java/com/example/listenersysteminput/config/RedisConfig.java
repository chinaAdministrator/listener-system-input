package com.example.listenersysteminput.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.connection.lettuce.LettuceConnectionFactory;
import org.springframework.data.redis.core.StringRedisTemplate;

@Configuration
public class RedisConfig {

//    @Bean
//    StringRedisTemplate getStringRedisTemplate(LettuceConnectionFactory connectionFactory) {
//        StringRedisTemplate stringRedisTemplate = new StringRedisTemplate();
//        stringRedisTemplate.setConnectionFactory(connectionFactory);
//        return stringRedisTemplate;
//    }
}
