package com.shuo.tank.strategy;

import com.shuo.tank.Audio;
import com.shuo.tank.Bullet;
import com.shuo.tank.Tank;

public class DefalutFireStrategySingleton implements FireStrategy {
    private static final DefalutFireStrategySingleton INSTANCE = new DefalutFireStrategySingleton();

    private DefalutFireStrategySingleton(){}

    @Override
    public void fire(Tank t) {
        int bx = t.x+ (Tank.TANK_WIGHT - Bullet.WIDTH-1)/2;
        int by = t.y + (Tank.TANK_HIGHT - Bullet.HIGHT)/2;
        Bullet bullet = new Bullet(bx, by, t.getDir(),t.getGroup());
        new Thread( () -> {new Audio("com/shuo/tank/audio/tank_fire.wav");},"").start();
    }

    public static DefalutFireStrategySingleton getInstance(){
        return INSTANCE;
    }
}
