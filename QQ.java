package leetcode.medium;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Created by cenumah on 2020-02-03
 */
public class QQ {

    public static void main(String[] args) {
//        System.out.println(fractionToDecimal(5,2));
//        System.out.println(fractionToDecimal(1,2));
//        System.out.println(fractionToDecimal(5,3));
//        System.out.println(fractionToDecimal(4,333));

    }

    public static String fractionToDecimal(int num, int div) {

        if(num == 0) {
            return "0";
        }

        if(div == 0) {
            return "NaN";
        }

        StringBuilder res = new StringBuilder();
        boolean hasDecPoint = false;
        int prev = 0;
        List<Integer> prevs = new ArrayList<>();
        Set<Integer> set = new HashSet<>();
        int idx = 0;

        while(num != prev && num != 0) {

            if(!prevs.isEmpty() && prevs.get(idx) == num) {
                break;
            }

            prev = num;
            prevs.add(num);

            if(num < div) {
                if(!hasDecPoint) {
                    if(res.length() == 0) res.append(0);
                    res.append(".");
                    hasDecPoint = true;
                }

                num*= 10;

                while (num < div) {
                    res.append(0);
                    num*= 10;
                }

                num = num == Integer.MIN_VALUE ? Integer.MAX_VALUE+1 : num*-1;

            }

            res.append(num/div);
            num = num%div;
        }

        if(num == prev && num != 0) {
            char last = res.charAt(res.length()-1);
            res.setLength(res.length()-1);
            res.append('(').append(last).append(')');
        }

        return res.toString();

    }
}
