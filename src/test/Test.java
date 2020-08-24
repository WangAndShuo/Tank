package test;

import com.shuo.tank.Tank;

import java.util.ArrayList;
import java.util.List;

public class Test {


    public static void main(String[] args) {
        List<List<String>> list = new ArrayList<>();


        for (int i = 0; i < 10 ; i++) {
            List<String> tmp = new ArrayList<>();
            tmp = getTmp(tmp,i);
            list.add(tmp);
            tmp.clear();
        }


        Tank tank = new Tank();
        tank.setX(10);
    }

    public static List<String> getTmp(List tmp, int i){
        for (int j = 0; j < i; j++) {
            tmp.add("1");
        }
        return tmp;
    }

}
