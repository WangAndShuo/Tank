package com.shuo.tank.abstractFactory;

import com.shuo.tank.Audio;
import com.shuo.tank.TankFrame;
import com.shuo.tank.resources.ResourceMgr;

import java.awt.*;

public class RectExplode extends BaseExplode {

    private int x, y;
    public static int WIDTH = ResourceMgr.explodes[0].getWidth();
    public static int HIGHT = ResourceMgr.explodes[0].getHeight();
    private TankFrame tf;
    private int step = 0;

    public RectExplode(int x, int y, TankFrame tf) {
        this.x = x;
        this.y = y;
        this.tf = tf;
//        audio.play();
    }

    @Override
    public void paint(Graphics g) {
//        g.drawImage(ResourceMgr.explodes[step++],x,y,null);
        Color c = g.getColor();
        g.setColor(Color.red);
        g.fillRect(x,y,10*step++,10*step++);
        if(step >= 15){
            tf.explodes.remove(this);
        }
        g.setColor(c);
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
