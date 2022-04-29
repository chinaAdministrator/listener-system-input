package com.example.listenersysteminput.listener;

import com.github.kwhat.jnativehook.GlobalScreen;
import com.github.kwhat.jnativehook.NativeHookException;
import com.github.kwhat.jnativehook.mouse.NativeMouseEvent;
import com.github.kwhat.jnativehook.mouse.NativeMouseInputListener;

/**
 * 监听鼠标移动
 */
public class GlobalMouseListenerExample implements NativeMouseInputListener {

    /**
     * 鼠标单击事件 单击次数
     */
    @Override
    public void nativeMouseClicked(NativeMouseEvent e) {
        System.out.println("Mouse Clicked: " + e.getClickCount());
    }

    /**
     * 鼠标按下事件
     */
    @Override
    public void nativeMousePressed(NativeMouseEvent e) {
        System.out.println("Mouse Pressed: " + e.getButton());
    }

    /**
     * 鼠标释放事件
     */
    @Override
    public void nativeMouseReleased(NativeMouseEvent e) {
        System.out.println("Mouse Released: " + e.getButton());
    }

    /**
     * 鼠标移动  e.getX()是横轴  e.getY()是纵轴
     */
    @Override
    public void nativeMouseMoved(NativeMouseEvent e) {
        System.out.println("Mouse Moved: " + e.getX() + ", " + e.getY());
    }

    /**
     * 鼠标拖拽 e.getX()是横轴  e.getY()是纵轴
     */
    @Override
    public void nativeMouseDragged(NativeMouseEvent e) {
        System.out.println("Mouse Dragged: " + e.getX() + ", " + e.getY());
    }

    public static void main(String[] args) {
        try {
            GlobalScreen.registerNativeHook();
        } catch (NativeHookException ex) {
            System.err.println("There was a problem registering the native hook.");
            System.err.println(ex.getMessage());

            System.exit(1);
        }

        // 创建监听实例
        GlobalMouseListenerExample example = new GlobalMouseListenerExample();

        //开启 {单击 按下 释放} 监听
//        GlobalScreen.addNativeMouseListener(example);
        //开启 {拖拽 移动} 监听
        GlobalScreen.addNativeMouseMotionListener(example);
    }
}
