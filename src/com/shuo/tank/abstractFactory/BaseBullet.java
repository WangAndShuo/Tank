package com.shuo.tank.abstractFactory;

import com.shuo.tank.Tank;

import java.awt.*;

public abstract class BaseBullet {
   public abstract void paint(Graphics g);
   public abstract void collideWith(Tank tank);
}
