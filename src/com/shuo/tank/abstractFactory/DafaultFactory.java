package com.shuo.tank.abstractFactory;

import com.shuo.tank.Bullet;
import com.shuo.tank.Explode;
import com.shuo.tank.Tank;
import com.shuo.tank.TankFrame;
import com.shuo.tank.enums.Dir;
import com.shuo.tank.enums.Group;
import com.sun.org.apache.regexp.internal.RE;

public  class DafaultFactory  extends  GameFactory{
    @Override
    public BaseBullet createBullet(int x,  int y, Dir dir,Group group, TankFrame tf) {
        return new Bullet(x,y,dir,group,tf);
    }

    @Override
    public BaseExplode createExplode(int x, int y, TankFrame tf) {
        return new Explode(x,y,tf);
    }

    @Override
    public BaseTank createTank(int x, int y, Dir dir, Group group, TankFrame tf) {
        try {
            return new Tank(x,y,dir,group,tf);
        } catch (Exception e){
            e.printStackTrace();
        }
        return null;
    }
}
