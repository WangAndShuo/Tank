package com.shuo.tank.strategy;

import com.shuo.tank.Audio;
import com.shuo.tank.Bullet;
import com.shuo.tank.Tank;

public class DefalutFireStrategy implements FireStrategy {
    public DefalutFireStrategy() {
    }

    @Override
    public void fire(Tank t) {
        int bx = t.x+ (t.TANK_WIGHT - Bullet.WIDTH-1)/2;
        int by = t.y + (t.TANK_HIGHT - Bullet.HIGHT)/2;
        Bullet bullet = new Bullet(bx, by, t.getDir(),t.getGroup(),t.getTf());
        new Thread( () -> {new Audio("com/shuo/tank/audio/tank_fire.wav");},"").start();
    }
}
