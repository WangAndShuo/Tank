package com.shuo.tank;

import com.shuo.tank.cor.BulletTankCollider;
import com.shuo.tank.cor.Collider;
import com.shuo.tank.cor.ColliderChain;
import com.shuo.tank.cor.TankTankCollider;
import com.shuo.tank.enums.Dir;
import com.shuo.tank.enums.Group;
import com.shuo.tank.resources.PropertyMgr;

import java.awt.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class GameModel extends Frame {

    private static final GameModel INSTANCE = new GameModel();

    static {
        INSTANCE.init();
    }

    //对象
    static Tank myTank;

    public static GameModel getInstance() {
        return INSTANCE;
    }

    private void init() {
        myTank = new Tank(300, 400, dir, Group.GOOD);
        int initTankCount = Integer.parseInt((String) PropertyMgr.get("initTankCount"));
        //初始化敌方坦克
        for (int i = 0; i < initTankCount; i++) {
            add(new Tank(50 + i * 75, 200, Dir.DOWN, Group.BAD));
        }
        add(new Wall(152, 150, 100, 50));
        add(new Wall(550, 150, 100, 50));
        add(new Wall(300, 300, 50, 50));
        add(new Wall(500, 300, 50, 50));
    }


    //宽高
    public static final int GAME_WIDTH = 800, GAME_HIGHT = 600;
    //方向
    public Dir dir = Dir.DOWN;    //方向枚举

    public Explode explode = null;
    public List<GameObject> list = new ArrayList<>();
    Collider bulletTankCollider = new BulletTankCollider();
    Collider tankTankCollider = new TankTankCollider();


    ColliderChain colliderChain = new ColliderChain();

    public void add(GameObject gameObject) {
        this.list.add(gameObject);
    }

    public void remove(GameObject gameObject) {
        this.list.remove(gameObject);
    }

    public GameModel() {
//对象

    }

    //首界面画笔
    @Override
    public void paint(Graphics g) {
        System.out.println("new paint: " + new Date());
        //子弹数量介绍
        Color c = g.getColor();
        g.setColor(Color.white);
        g.drawString("数量：" + list.size(), 10, 60);
        g.setColor(c);
        //画坦克
        myTank.paint(g);
        for (int i = 0; i < list.size(); i++) {
            list.get(i).paint(g);
        }

        //相互碰撞
        for (int i = 0; i < list.size(); i++) {
            for (int j = i + 1; j < list.size(); j++) {
                GameObject o1 = list.get(i);
                GameObject o2 = list.get(j);

                colliderChain.collider(o1, o2);
//                bulletTankCollider.collide(o1, o2);
//                tankTankCollider.collide(o1, o2);
            }
        }
    }

    public Tank getMainTank() {
        return myTank;
    }
}
