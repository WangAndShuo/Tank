package com.shuo.tank.decorator;

import com.shuo.tank.GameObject;

import java.awt.*;

public abstract class GODecorator extends GameObject{
    GameObject go;

    public GODecorator(final GameObject go) {
        this.go = go;
    }

    @Override
    public void paint(Graphics g){
        go.paint(g);
    }
}
