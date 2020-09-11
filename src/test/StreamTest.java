package test;

import java.time.Clock;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class StreamTest {


    public static void main(String[] args) {

        Clock clock;

        List<Stu> list = new ArrayList<>();
        List<Stu> list1 = new ArrayList<>();
        for (int i = 0; i < 1000000 ; i++) {
            list.add(new Stu(String.valueOf(i),String.valueOf(i)));
        }

        long start = System.currentTimeMillis();
         list.stream().filter(p -> Integer.parseInt(p.getUserName()) % 10 != 0 ).collect(Collectors.toList());
//        for (int i =0; i < list.size(); i++ ) {
//            Stu stu = list.get(i);
//            if(Integer.parseInt(stu.getUserName()) % 10 != 0){
//                list1.add(stu);
//            }
//        }
        long end = System.currentTimeMillis();
        System.out.println(end-start);
    }
}
