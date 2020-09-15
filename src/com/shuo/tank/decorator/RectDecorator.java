package com.shuo.tank.decorator;

import com.shuo.tank.GameObject;

import java.awt.*;

public class RectDecorator extends GODecorator{


    public RectDecorator( GameObject go) {
        super(go);
    }

    @Override
    public void paint(Graphics g){
        this.x = go.x;
        this.y = go.y;
        go.paint(g);
        Color c = g.getColor();
        g.setColor(Color.white);
        g.drawRect(go.x, go.y,go.getWidth()+2,go.getHeight()+2);
        g.setColor(c);
    }

    @Override
    public int getWidth() {
        return super.go.getWidth();
    }

    @Override
    public int getHeight() {
        return super.go.getHeight();
    }
}
