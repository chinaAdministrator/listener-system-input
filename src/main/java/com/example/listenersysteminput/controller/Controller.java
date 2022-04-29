package com.example.listenersysteminput.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Controller {

    @Autowired
    private StringRedisTemplate stringRedisTemplate;

    @GetMapping("/getRedisListByKey")
    public Object getRedisListByKey(@RequestParam String key) {
        return stringRedisTemplate.opsForList().range(key, 0, Long.MAX_VALUE);
    }
}
