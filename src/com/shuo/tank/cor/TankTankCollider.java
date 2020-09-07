package com.shuo.tank.cor;

import com.shuo.tank.GameObject;
import com.shuo.tank.Tank;

public class TankTankCollider implements  Collider {
    @Override
    public boolean collide(final GameObject o1, final GameObject o2) {
        if(o1 instanceof Tank && o2 instanceof  Tank){
            Tank t1 = (Tank)o1;
            Tank t2 = (Tank)o2;
            if(t1.getRect().intersects(t2.getRect())) {
                t1.stop();
            }
//            return true;
        }
        return  true;

    }
}
