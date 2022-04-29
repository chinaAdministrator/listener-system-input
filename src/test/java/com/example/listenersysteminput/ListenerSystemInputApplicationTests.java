package com.example.listenersysteminput;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.StringRedisTemplate;

import java.time.LocalDate;

@SpringBootTest
class ListenerSystemInputApplicationTests {

    @Autowired
    private StringRedisTemplate stringRedisTemplate;

    @Test
    void contextLoads() {
//        stringRedisTemplate.opsForValue().set("1", "1");
    }

}
