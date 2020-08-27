package com.shuo.tank;

import com.shuo.tank.enums.Dir;
import com.shuo.tank.enums.Group;
import com.shuo.tank.resources.PropertyMgr;
import com.shuo.tank.resources.ResourceMgr;
import com.shuo.tank.strategy.DefalutFireStrategySingleton;
import com.shuo.tank.strategy.FireStrategy;
import com.shuo.tank.strategy.FourDirFireStrategy;

import java.awt.*;
import java.util.Random;


/**
 * 坦克类
 */
public class Tank {
    public int x, y ;
    private Dir dir = Dir.DOWN;
    private final int SPEED = 5;
    private boolean moving = false;
    public  final int TANK_WIGHT = ResourceMgr.goodtankD.getWidth();
    public  final int TANK_HIGHT = ResourceMgr.goodtankD.getHeight();
    private GameModel gm = null;
    private boolean living = true;
    private Group group = Group.BAD;
    Random random = new Random();
    public Rectangle rect = new Rectangle();
    FireStrategy fs;


    public Tank( int x,  int y,  Dir dir,Group group, GameModel gm) throws ClassNotFoundException, IllegalAccessException, InstantiationException {
        this.x = x;
        this.y = y;
        this.dir = dir;
        this.gm = gm;
        this.group = group;
        if(group == Group.BAD){
            moving = true;
            String FsName = (String)PropertyMgr.get("badFs");
            fs = (FireStrategy) Class.forName(FsName).newInstance();
        }else{
            String FsName = (String)PropertyMgr.get("goodFs");
            fs = (FireStrategy) Class.forName(FsName).newInstance();

        }
        rect.x = this.x;
        rect.y = this.y;
        rect.width = TANK_HIGHT;
        rect.height = TANK_HIGHT;
    }

    public Tank() {

    }

    //画坦克
    public void paint(Graphics g){
        if(!living){return;}
        switch (dir){
            case  LEFT:
                g.drawImage(this.group == Group.GOOD ? ResourceMgr.goodtankL : ResourceMgr.badtankL,x,y,null);
                break;
            case  RIGHT:
                g.drawImage(this.group == Group.GOOD ? ResourceMgr.goodtankR : ResourceMgr.badtankR,x,y,null);
                break;
            case  UP:
                g.drawImage(this.group == Group.GOOD ? ResourceMgr.goodtankU : ResourceMgr.badtankU ,x,y,null);
                break;
            case  DOWN:
                g.drawImage(this.group == Group.GOOD ? ResourceMgr.goodtankD : ResourceMgr.badtankD,x,y,null);
                break;
        }
        move(g);
    }

    //发射子弹
    public void  fire() {
        if(gm.bullet.size() <=  50){

            //策略模式
            fs.fire(this);

            //非策略模式
//            int bx = this.x + (TANK_WIGHT - Bullet.WIDTH-1)/2;
//            int by = this.y + (TANK_HIGHT - Bullet.HIGHT)/2;
//            Bullet bullet = new Bullet(bx, by, dir,this.group,tf);
//            tf.bullet.add(bullet);


//            画笔图形化坦克
//            int x = tf.bullet.get(tf.bullet.size()-1).getX();
//            int y = tf.bullet.get(tf.bullet.size()-1).getY();
//            if(Math.abs(x - tf.myTank.getX()) > 200 || Math.abs(y - tf.myTank.getY()) > 200){
//                Bullet bullet = new Bullet(this.x, this.y, dir,tf);
//                tf.bullet.add(bullet);
//                return;
//            }
        }
    }

    //移动
    private void move(Graphics g) {
        if(!moving){
            return;
        }
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
        buondsCheck();

        if(this.group == Group.BAD && random.nextInt(100) > 85){
            this.fire();
        }
        if(this.group == Group.BAD){ randomDir(); }
        //update rect
        rect.x = this.x;
        rect.y = this.y;
    }

    private void buondsCheck() {
        if(this.x < 2 ){
            x = 2;
        }else if(this.y < 30 ){
            y = 32;
        }else if(this.x > TankFrame.GAME_WIDTH - TANK_WIGHT-2){
            x = TankFrame.GAME_WIDTH - TANK_WIGHT-2;
        }else if(this.y > TankFrame.GAME_HIGHT - TANK_HIGHT-2){
            y = TankFrame.GAME_HIGHT - TANK_HIGHT-2;
        }

    }

    ///随机方向
    private void randomDir() {
        if(random.nextInt(100) > 88){
            this.dir =  Dir.values()[random.nextInt(4)];
        }

    }

    //向上图案
    public void up(Graphics g){
        g.fillRect(x,y,TANK_WIGHT,TANK_HIGHT);
        g.fillRect(x,y-10,TANK_WIGHT,TANK_HIGHT);
        g.fillRect(x-10,y,TANK_WIGHT,TANK_HIGHT);
        g.fillRect(x+10,y,TANK_WIGHT,TANK_HIGHT);
        g.fillRect(x+10,y+10,TANK_WIGHT,TANK_HIGHT);
        g.fillRect(x-10,y+10,TANK_WIGHT,TANK_HIGHT);
    }
    //向下图案
    public void down (Graphics g){
        g.fillRect(x,y,TANK_WIGHT,TANK_HIGHT);
        g.fillRect(x,y+10,TANK_WIGHT,TANK_HIGHT);
        g.fillRect(x-10,y,TANK_WIGHT,TANK_HIGHT);
        g.fillRect(x+10,y,TANK_WIGHT,TANK_HIGHT);
        g.fillRect(x+10,y-10,TANK_WIGHT,TANK_HIGHT);
        g.fillRect(x-10,y-10,TANK_WIGHT,TANK_HIGHT);
    }
    //向左图案
    public void left(Graphics g){
        g.fillRect(x,y,TANK_WIGHT,TANK_HIGHT);
        g.fillRect(x-10,y,TANK_WIGHT,TANK_HIGHT);
        g.fillRect(x,y+10,TANK_WIGHT,TANK_HIGHT);
        g.fillRect(x,y-10,TANK_WIGHT,TANK_HIGHT);
        g.fillRect(x+10,y-10,TANK_WIGHT,TANK_HIGHT);
        g.fillRect(x+10,y+10,TANK_WIGHT,TANK_HIGHT);
    }
    //向右图案
    public void right(Graphics g){
        g.fillRect(x,y,TANK_WIGHT,TANK_HIGHT);
        g.fillRect(x+10,y,TANK_WIGHT,TANK_HIGHT);
        g.fillRect(x,y+10,TANK_WIGHT,TANK_HIGHT);
        g.fillRect(x,y-10,TANK_WIGHT,TANK_HIGHT);
        g.fillRect(x-10,y-10,TANK_WIGHT,TANK_HIGHT);
        g.fillRect(x-10,y+10,TANK_WIGHT,TANK_HIGHT);
    }
    //子弹射击死亡
    public void die() {
        living = false;
        gm.tanks.remove(this);
        gm.explode = new Explode(this.x,this.y,gm);
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
    public boolean isMoving() {
        return moving;
    }
    public void setMoving(final boolean moving) {
        this.moving = moving;
    }
    public Dir getDir() {
        return dir;
    }
    public void setDir(final Dir dir) {
        this.dir = dir;
    }
    public int getSPEED() {
        return SPEED;
    }
    public Group getGroup() {
        return group;
    }
    public void setGroup(final Group group) {
        this.group = group;
    }

    public int getTANK_WIGHT() {
        return TANK_WIGHT;
    }

    public int getTANK_HIGHT() {
        return TANK_HIGHT;
    }

    public GameModel getGm() {
        return gm;
    }

    public void setGm(final GameModel gm) {
        this.gm = gm;
    }

    public boolean isLiving() {
        return living;
    }

    public void setLiving(final boolean living) {
        this.living = living;
    }

    public Random getRandom() {
        return random;
    }

    public void setRandom(final Random random) {
        this.random = random;
    }

    public Rectangle getRect() {
        return rect;
    }

    public void setRect(final Rectangle rect) {
        this.rect = rect;
    }
}
