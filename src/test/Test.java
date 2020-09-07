package test;

import com.shuo.tank.Tank;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class Test {


    public static void main(String[] args) {

        BigDecimal b = new BigDecimal("dsa");


        StringBuilder sb = new StringBuilder();
        sb.append("11");
        if(sb.length() <= 2){
            System.out.println(sb.toString());
            System.out.println(sb.toString());
            System.out.println(sb.toString());
            System.out.println(sb.toString());
        }





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
