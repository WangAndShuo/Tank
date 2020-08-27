package com.shuo.tank.strategy;

import com.shuo.tank.Audio;
import com.shuo.tank.Bullet;
import com.shuo.tank.Tank;
import com.shuo.tank.enums.Dir;

public class FourDirFireStrategy implements FireStrategy{
    @Override
    public void fire(Tank t) {
        int bx = t.x+ (t.TANK_WIGHT - Bullet.WIDTH-1)/2;
        int by = t.y + (t.TANK_HIGHT - Bullet.HIGHT)/2;
        Dir[] dirs = Dir.values();
        for (int i = 0; i < dirs.length; i++) {
//            BaseBullet bullet =  t.getTf().gf.createBullet(bx, by,dirs[i],t.getGroup(),t.getTf());
            Bullet bullet = new Bullet(bx, by,dirs[i],t.getGroup(),t.getGm());
        }
        new Thread( () -> {new Audio("com/shuo/tank/audio/tank_fire.wav");},"").start();
    }

}
