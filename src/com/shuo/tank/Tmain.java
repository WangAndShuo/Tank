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
        int initTankCount = Integer.parseInt((String)PropertyMgr.get("initTankCount"));
        //初始化敌方坦克
        for (int i =0; i< initTankCount; i++){
            frame.tanks.add(new Tank(50 + i*75,200, Dir.DOWN, Group.BAD,frame));
        }
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
