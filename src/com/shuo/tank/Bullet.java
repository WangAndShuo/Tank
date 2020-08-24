package com.shuo.tank;

import com.shuo.tank.abstractFactory.BaseBullet;
import com.shuo.tank.enums.Dir;
import com.shuo.tank.enums.Group;
import com.shuo.tank.resources.ResourceMgr;

import java.awt.*;

/**
 * 子弹类
 */
public class Bullet extends BaseBullet{
    private static final int SPEED =  20;
    private int x,y;
    private Dir dir;
    public static int WIDTH = ResourceMgr.bulletL.getWidth();
    public static int HIGHT = ResourceMgr.bulletL.getHeight();
    private final int TANK_WIGHT = ResourceMgr.goodtankD.getWidth();
    private final int TANK_HIGHT = ResourceMgr.goodtankD.getHeight();
    private Group group = Group.BAD;
    private boolean living = true;
    private  TankFrame tf;
    Rectangle rect = new Rectangle();
    public Bullet(int x,  int y, Dir dir,Group group, TankFrame tf) {
        this.x = x;
        this.y = y;
        this.dir = dir;
        this.tf = tf;
        this.group = group;
        rect.x = this.x;
        rect.y = this.y;
        rect.width = WIDTH;
        rect.height = HIGHT;
        tf.bullet.add(this);
    }

    public void paint(Graphics g){
        if(!this.living){
            tf.bullet.remove(this);
        }
        setBulletDir(g);
        move();
    }
    public void setBulletDir(Graphics g){
        switch (dir){
            case  LEFT:
                g.drawImage(ResourceMgr.bulletL,x-10,y,null);
                break;
            case  RIGHT:
                g.drawImage(ResourceMgr.bulletR,x+10,y+2,null);
                break;
            case  UP:
                g.drawImage(ResourceMgr.bulletU,x+2,y-10,null);
                break;
            case  DOWN:
                g.drawImage(ResourceMgr.bulletD,x,y+10,null);
                break;
            default:
                break;
        }

    }

    public void collideWith(Tank tank){
        if(this.group == tank.getGroup()) return;

        //TODO: 用一个rect来记录子弹的位置
//        Rectangle rect1 = new Rectangle(this.x,this.y,WIDTH,HIGHT);
//        Rectangle rect2 = new Rectangle(tank.getX(),tank.getY(),TANK_WIGHT,TANK_HIGHT);
        if(rect.intersects(tank.rect)){
            this.die();
            tank.die();
            int ex = tank.getX() + (TANK_WIGHT - WIDTH)/2;
            int ey = tank.getY() + (TANK_HIGHT - HIGHT)/2;
            tf.explodes.add(tf.gf.createExplode(ex,ey,tf));
        }
    }

    private void die() {
        living = false;
    }


    private void move() {
        switch (dir){
            case  LEFT:
                x-=SPEED;
                break;
            case  RIGHT:
                x+=SPEED;
                break;
            case  UP:
                y-=SPEED;
                break;
            case  DOWN:
                y+=SPEED;
                break;
            default:
                break;
        }
        //update rect
        rect.x = this.x;
        rect.y = this.y;

        if(x < 0 || y < 0 || x > TankFrame.GAME_WIDTH || y > TankFrame.GAME_HIGHT ){
            living = false;
        }
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

    public Dir getDir() {
        return dir;
    }

    public void setDir(final Dir dir) {
        this.dir = dir;
    }

    public Group getGroup() {
        return group;
    }

    public void setGroup(final Group group) {
        this.group = group;
    }
}
