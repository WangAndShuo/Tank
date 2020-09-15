package com.shuo.tank;

import com.shuo.tank.resources.ResourceMgr;

import java.awt.*;

/**
 * 爆炸类
 */
public class Explode  extends GameObject{

    public static int WIDTH = ResourceMgr.explodes[0].getWidth();
    public static int HIGHT = ResourceMgr.explodes[0].getHeight();
    Audio audio =  new Audio("com/shuo/tank/audio/explode.wav");
    private int step = 0;

    public Explode(int x, int y) {
        this.x = x;
        this.y = y;
//        audio.play();
    }

    @Override
    public void paint(Graphics g) {
       g.drawImage(ResourceMgr.explodes[step++],x,y,null);
       if(step >= ResourceMgr.explodes.length){
           GameModel.getInstance().remove(this);
       }
    }

    @Override
    public int getWidth() {
        return width;
    }

    @Override
    public int getHeight() {
        return height;
    }

    public int getX() {
        return x;
    }

    public void setX(final int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(final int y) {
        this.y = y;
    }

}
