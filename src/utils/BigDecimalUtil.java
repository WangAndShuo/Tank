package utils;

import java.math.BigDecimal;

public class BigDecimalUtil {




    /**
     * String类型转成BigDecimal
     * @param str
     * @return
     */
    public static BigDecimal  stringToDecimals(String str){
        BigDecimal bigDecima = null;
        try {
            BigDecimal bigDecimal = new BigDecimal(str);
        } catch (Exception e) {
            System.err.println("字符串非小数类型");
        }
        return null;
    }


    /**
     * 保留三位小数
     * @param bigDecimal
     * @return
     */
    public static BigDecimal  keepThreeDecimals(BigDecimal bigDecimal){

        bigDecimal = bigDecimal.setScale(4, BigDecimal.ROUND_HALF_UP);
        bigDecimal = bigDecimal.setScale(3, BigDecimal.ROUND_HALF_UP);
        return bigDecimal;
    }

    /**
     * 保留两位小数
     * @param bigDecimal
     * @return
     */
    public static BigDecimal  keepTwoDecimals(BigDecimal bigDecimal){
        bigDecimal = bigDecimal.setScale(3, BigDecimal.ROUND_HALF_UP);
        bigDecimal = bigDecimal.setScale(2, BigDecimal.ROUND_HALF_UP);
        return bigDecimal;
    }
}
