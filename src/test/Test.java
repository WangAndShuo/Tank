package test;

import com.shuo.tank.Tank;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class Test {


    public static void main(String[] args) {
        BigDecimal c = new BigDecimal("3.11");
        BigDecimal maxOrgRate = new BigDecimal("0.23");
        BigDecimal minOrgRate = new BigDecimal("0.124");
        if(c.compareTo(minOrgRate) == -1){
            //rate.setMinOrgRate(contractRate);
            System.out.println("-----");
        }else if (c.compareTo(maxOrgRate) == 1){
            System.out.println("44645");

        }
//        System.out.println(minOrgRate.compareTo(maxOrgRate));

    }
//
//    public static void main(String[] args) {
//
//        List list1 = new ArrayList();
//        for (int i = 0; i < 10 ; i++) {
//            list1.add(i);
//        }
//
//        for (int i = 0; i < list1.size(); i++) {
//            list1.remove(list1.get(i));
//        }
//
//
////        BigDecimal b = new BigDecimal("dsa");
//
//
//        StringBuilder sb = new StringBuilder();
//        sb.append("11");
//        if(sb.length() <= 2){
//            System.out.println(sb.toString());
//            System.out.println(sb.toString());
//            System.out.println(sb.toString());
//            System.out.println(sb.toString());
//        }
//
//
//
//
//
//        List<List<String>> list = new ArrayList<>();
//
//
//        for (int i = 0; i < 10 ; i++) {
//            List<String> tmp = new ArrayList<>();
//            tmp = getTmp(tmp,i);
//            list.add(tmp);
//            tmp.clear();
//        }
//
//
//        Tank tank = new Tank();
//        tank.setX(10);
//    }
//
//    public static List<String> getTmp(List tmp, int i){
//        for (int j = 0; j < i; j++) {
//            tmp.add("1");
//        }
//        return tmp;
//    }

}
