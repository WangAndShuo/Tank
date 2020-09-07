package com.shuo.tank;

import com.shuo.tank.cor.BulletTankCollider;
import com.shuo.tank.cor.Collider;
import com.shuo.tank.cor.ColliderChain;
import com.shuo.tank.cor.TankTankCollider;
import com.shuo.tank.enums.Dir;
import com.shuo.tank.enums.Group;
import com.shuo.tank.resources.PropertyMgr;

import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class GameModel extends  Frame{

    public static final int GAME_WIDTH = 800,GAME_HIGHT = 600;
    public Dir dir = Dir.DOWN;    //方向枚举
    //对象
    private Tank myTank = new Tank(300,400, dir, Group.GOOD,this);
//    public  List<Bullet> bullet = new ArrayList<>();
//    public  List<Tank> tanks = new ArrayList<>();
//    public  List<Explode> explodes = new ArrayList<>();
    public  Explode explode = null;
    public List<GameObject> list = new ArrayList<>();
    Collider bulletTankCollider = new BulletTankCollider();
    Collider tankTankCollider = new TankTankCollider();


    ColliderChain colliderChain = new ColliderChain();
    public void add(GameObject gameObject){
        this.list.add(gameObject);
    }
    public void remove(GameObject gameObject){
        this.list.remove(gameObject);
    }

    public GameModel() throws Exception {
        int initTankCount = Integer.parseInt((String) PropertyMgr.get("initTankCount"));
        //初始化敌方坦克
        for (int i =0; i< initTankCount; i++){
            this.add(new Tank(50 + i*75,200, Dir.DOWN, Group.BAD,this));
        }
//        setVisible(true);
//        setResizable(false);
//        setTitle("tank war");
//        setSize(GAME_WIDTH,GAME_HIGHT);
//        //添加窗口监听
//        addWindowListener(new WindowAdapter() {
//            @Override
//            public void windowClosing(final WindowEvent e) {
//                System.exit(0);
//            }
//        });
//        //添加鼠标监听
//        addMouseListener(new MouseAdapter() {
//            @Override
//            public void mouseClicked(final MouseEvent e) {
//                super.mouseClicked(e);
//            }
//        });
//        //添加键盘监听
//        addKeyListener(new MyKeyListenter());
    }

    //首界面画笔
    @Override
    public void paint(Graphics g) {
        System.out.println("new paint: "+ new Date());
        //子弹数量介绍
        Color c = g.getColor();
        g.setColor(Color.white);
//        g.drawString("子弹的数量："+ bullet.size() ,10,60);
//        g.drawString("敌坦的数量：" + tanks.size(),10,80);
//        g.drawString("爆炸的数量：" + explodes.size(),10,100);
        g.setColor(c);
        //画坦克
        myTank.paint(g);
        for (int i = 0; i < list.size(); i++) {
            list.get(i).paint(g);
        }
//        //画子弹
//        for (int i = 0; i < bullet.size(); i++) {
//            bullet.get(i).paint(g);
//        }
//        //画敌方坦克
//        for (int i = 0; i < tanks.size(); i++) {
//            tanks.get(i).paint(g);
//        }
//        //画爆炸
//        for (int i = 0; i < explodes.size(); i++) {
//            explodes.get(i).paint(g);
//        }
//        //判断碰撞
//        for (int i = 0; i < bullet.size(); i++) {
//            for (int j = 0; j < tanks.size(); j++) {
//                bullet.get(i).collideWith(tanks.get(j));
//            }
//        }

        //相互碰撞
        for (int i = 0; i < list.size(); i++) {
            for (int j = i+1; j < list.size(); j++) {
                GameObject o1 = list.get(i);
                GameObject o2 = list.get(j);

                colliderChain.collider(o1, o2);
//                bulletTankCollider.collide(o1, o2);
//                tankTankCollider.collide(o1, o2);
            }
        }

    }


    //双缓冲  先创建一个Image图片对象，拿着画笔将图片画出来，之后再将画笔交给paint画坦克，子弹，画好之后返回整个Image
    // update在paint之前执行
//    Image offScreenImage = null;
//    @Override
//    public void update(Graphics g) {
//        if(offScreenImage == null){
//            offScreenImage = this.createImage(GAME_WIDTH,GAME_HIGHT);
//        }
//        Graphics gOffScreen = offScreenImage.getGraphics();
//        Color c = gOffScreen.getColor();
//        gOffScreen.setColor(Color.BLACK);
//        gOffScreen.fillRect(0,0,GAME_WIDTH,GAME_HIGHT);
//        gOffScreen.setColor(c);
//        paint(gOffScreen);
//        g.drawImage(offScreenImage,0,0,null);
//    }


//    class MyKeyListenter extends KeyAdapter{
//        boolean bL = false;
//        boolean bU = false;
//        boolean bR = false;
//        boolean bD = false;
//
//        //键盘按下去调用
//        @Override
//        public void keyPressed(KeyEvent e) {
//            System.out.println("new keyPressed");
//            int key = e.getKeyCode();
//            switch (key) {
//                case KeyEvent.VK_UP:
//                    bU = true;
//                    break;
//                case KeyEvent.VK_DOWN:
//                    bD = true;
//                    break;
//                case KeyEvent.VK_RIGHT:
//                    bR = true;
//                    break;
//                case KeyEvent.VK_LEFT:
//                    bL = true;
//                    break;
//                default:
//                    break;
//            }
//            setMainTankDir();
//        }
//
//        //键盘抬起来调用
//        @Override
//        public void keyReleased(KeyEvent e) {
//            System.out.println("new keyReleased");
//            int key = e.getKeyCode();
//
//            switch (key) {
//                case KeyEvent.VK_UP:
//                    bU = false;
//                    break;
//                case KeyEvent.VK_DOWN:
//                    bD = false;
//                    break;
//                case KeyEvent.VK_RIGHT:
//                    bR = false;
//                    break;
//                case KeyEvent.VK_LEFT:
//                    bL = false;
//                    break;
//                case KeyEvent.VK_CONTROL:
//                    myTank.fire();
//                default:
//                    break;
//            }
//            setMainTankDir();
//        }
//
//        //根据条件设置坦克方向
//        private void setMainTankDir() {
//            gm
//            if(!bL && !bU && !bR &&! bD){
//                myTank.setMoving(false);
//            }else{
//                myTank.setMoving(true);
//                if(bL) { myTank.setDir(Dir.LEFT);}
//                if(bR) { myTank.setDir(Dir.RIGHT);}
//                if(bU) { myTank.setDir(Dir.UP);}
//                if(bD) { myTank.setDir(Dir.DOWN);}
//            }
////            if(bL) { dir = Dir.LEFT;}
////            if(bR) { dir = Dir.RIGHT;}
////            if(bU) { dir = Dir.UP;}
////            if(bD) { dir = Dir.DOWN;}
//
//
//
//
//        }
//    }

    public  Tank  getMainTank(){
        return myTank;
    }
}
