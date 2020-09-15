package com.shuo.tank.strategy;

import com.shuo.tank.Audio;
import com.shuo.tank.Bullet;
import com.shuo.tank.GameModel;
import com.shuo.tank.Tank;
import com.shuo.tank.decorator.RectDecorator;
import com.shuo.tank.decorator.TailDecorator;

public class DefalutFireStrategy implements FireStrategy {
    public DefalutFireStrategy() {
    }

    @Override
    public void fire(Tank t) {
        int bx = t.x+ (Tank.TANK_WIGHT - Bullet.WIDTH-1)/2;
        int by = t.y + (Tank.TANK_HIGHT - Bullet.HIGHT)/2;
        GameModel.getInstance().add(      new TailDecorator( new RectDecorator( new Bullet(bx, by, t.getDir(),t.getGroup()))));
        new Thread( () -> {new Audio("com/shuo/tank/audio/tank_fire.wav");},"").start();
    }
}
