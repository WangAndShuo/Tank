package com.shuo.tank;

import java.awt.*;

public class Wall extends  GameObject{

    int w,h;

    public Wall(final int x, final int y, final int w, final int h) {
        this.x = x;
        this.y = y;
        this.w = w;
        this.h = h;
    }

    @Override
    public void paint(final Graphics g) {
        Color c = g.getColor();
        g.setColor(Color.lightGray);
        g.fillRect(x,y,w,h);
        g.setColor(c);
    }
}
