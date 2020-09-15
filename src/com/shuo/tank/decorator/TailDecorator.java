package com.shuo.tank.decorator;

import com.shuo.tank.GameObject;

import java.awt.*;

public class TailDecorator  extends GODecorator{


    public TailDecorator(GameObject go) {
        super(go);
    }

    @Override
    public void paint(Graphics g){
        this.x = go.x;
        this.y = go.y;
        go.paint(g);
        Color c = g.getColor();
        g.setColor(Color.white);
        g.drawLine(x, y,x+go.getWidth()+2,y+go.getHeight()+2);
        g.setColor(c);
    }

    @Override
    public int getWidth() {
        return 0;
    }

    @Override
    public int getHeight() {
        return 0;
    }
}
