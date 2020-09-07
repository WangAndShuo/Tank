package com.shuo.tank.cor;

import com.shuo.tank.Bullet;
import com.shuo.tank.Explode;
import com.shuo.tank.GameObject;
import com.shuo.tank.Tank;

import java.awt.*;

public class BulletTankCollider implements Collider{
    Rectangle rect = new Rectangle();
    @Override
    public boolean collide(final GameObject o1, final GameObject o2) {
        if(o1 instanceof Bullet && o2 instanceof Tank){
            Bullet b = (Bullet)o1;
            Tank t = (Tank)o2;
            if(b.collideWith(t)) {
                return  true;
            }
//            if(b.group == t.getGroup()) return;
//
//            //TODO: 用一个rect来记录子弹的位置
//            if(rect.intersects(t.rect)){
//                b.die();
//                t.die();
//                int ex = t.getX() + (TANK_WIGHT - WIDTH)/2;
//                int ey = t.getY() + (TANK_HIGHT - HIGHT)/2;
//                gm.add(new Explode(ex,ey,gm));
//            }
        }else if (o1 instanceof Tank && o2 instanceof Bullet){
            collide(o2, o1);
            return  true;
        }else {
            return false;
        }
        return  false;
    }
}
