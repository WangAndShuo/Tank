package com.shuo.tank;

import java.awt.*;

public abstract class GameObject {
    public int x,y,width,height;
    public abstract void paint(Graphics g);
    public abstract int getWidth();
    public abstract int getHeight();
}
