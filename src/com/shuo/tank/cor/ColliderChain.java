package com.shuo.tank.cor;

import com.shuo.tank.GameObject;

import java.util.LinkedList;
import java.util.List;

public class ColliderChain {
    private List<Collider> colliders = new LinkedList<>();

    public ColliderChain() {
        add(new BulletTankCollider());
        add(new TankTankCollider());
    }

    public void add(Collider c){
        colliders.add(c);
    }

    public boolean collider( GameObject o1, final GameObject o2) {
        for (int i = 0; i < colliders.size(); i++) {
            if(colliders.get(i).collide(o1, o2)) {
                return  false;
            }
        }
        return true;
    }
}
