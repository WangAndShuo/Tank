package com.shuo.tank.cor;

import com.shuo.tank.GameObject;

public interface Collider {
    boolean collide(GameObject o1, GameObject o2);
}
