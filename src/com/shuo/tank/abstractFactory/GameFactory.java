package com.shuo.tank.abstractFactory;

import com.shuo.tank.TankFrame;
import com.shuo.tank.enums.Dir;
import com.shuo.tank.enums.Group;

public abstract class GameFactory{
    public abstract BaseBullet createBullet(int x,  int y, Dir dir,Group group, TankFrame tf);
    public abstract BaseExplode createExplode(int x, int y, TankFrame tf);
    public abstract BaseTank createTank(int x, int y, Dir dir, Group group, TankFrame tf);

}
