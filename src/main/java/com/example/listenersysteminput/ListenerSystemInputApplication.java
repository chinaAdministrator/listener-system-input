package com.example.listenersysteminput;

import com.example.listenersysteminput.listener.GlobalKeyListenerExample;
import com.github.kwhat.jnativehook.GlobalScreen;
import com.github.kwhat.jnativehook.NativeHookException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.web.client.RestTemplate;

/**
 * 这是一个可以监听键盘输入和鼠标操作的java项目
 */
@SpringBootApplication
public class ListenerSystemInputApplication {

    public static void main(String[] args) {
        SpringApplication.run(ListenerSystemInputApplication.class, args);
    }
}
