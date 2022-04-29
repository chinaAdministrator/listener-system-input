package com.example.listenersysteminput.config;

import com.example.listenersysteminput.listener.GlobalKeyListenerExample;
import com.github.kwhat.jnativehook.GlobalScreen;
import com.github.kwhat.jnativehook.NativeHookException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.core.StringRedisTemplate;

@Configuration
public class PostConstruct {

    @Autowired
    private StringRedisTemplate stringRedisTemplate;

    @javax.annotation.PostConstruct
    public void init() {
        try {
            GlobalScreen.registerNativeHook();
        } catch (NativeHookException ex) {
            System.err.println("There was a problem registering the native hook.");
            System.err.println(ex.getMessage());
            System.exit(1);
        }
        GlobalScreen.addNativeKeyListener(new GlobalKeyListenerExample(stringRedisTemplate));
    }
}