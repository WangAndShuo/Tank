package com.shuo.tank.abstractFactory;

import com.shuo.tank.TankFrame;
import com.shuo.tank.enums.Dir;
import com.shuo.tank.enums.Group;

public class RectFactory extends GameFactory{
    @Override
    public BaseBullet createBullet( int x,  int y,  Dir dir,  Group group,  TankFrame tf) {
        return new RectBullet(x,y,dir,group,tf);
    }

    @Override
    public BaseExplode createExplode( int x,  int y,  TankFrame tf) {
        return new RectExplode(x,y,tf);
    }

    @Override
    public BaseTank createTank( int x,  int y,  Dir dir,  Group group,  TankFrame tf) {
        return null;
    }
}
