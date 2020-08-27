package com.shuo.tank;

import com.shuo.tank.enums.Dir;
import com.shuo.tank.enums.Group;
import com.shuo.tank.resources.PropertyMgr;

import java.awt.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class Tmain {
    public static void main(String[] args) throws Exception{
        TankFrame  frame = new TankFrame();

        //启动音乐
//        new Thread(() -> {
//            Audio a = new Audio("com/shuo/tank/audio/war1.wav");
//            a.loop();
//        }).start();
        while (true){
            Thread.sleep(100);
            frame.repaint();
        }

    }
}
