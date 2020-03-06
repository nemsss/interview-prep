package leetcode.medium;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Created by cenumah on 2020-01-08
 */
public class Q163 {

    public static void main(String[] args) {

        Q163 q = new Q163();
        System.out.println(q.findMissingRanges(new int[]{2147483647}, 2147483647, 2147483647));
        System.out.println(q.findMissingRanges(new int[]{}, 1, 1));
        System.out.println(q.findMissingRanges(new int[]{-1}, -2, -1));
        System.out.println(q.findMissingRanges(new int[]{0,1,3,5,79}, 0, 100));
    }

    public List<String> findMissingRanges(int[] nums, int lower, int upper) {

        if(nums == null) {
            return new ArrayList<>();
        }

        int len = nums.length;
        if(len == 0) {
            return new ArrayList<>(Collections.singletonList(range(lower, upper)));
        }

        List<String> res = new ArrayList<>();
        int prev = lower;
        for (int i=0; i<len; i++) {

            int num = nums[i];

            if (num == prev) {
                continue;
            } else if( i == 0){
                res.add(range(prev, num - 1));
            }
            else if (num > prev + 1) {
                res.add(range(prev + 1, num - 1));
            }

            prev = num;
        }

        if(prev != upper){
            res.add(range(prev+1, upper));
        }

        return res;
    }

    private String range (int a, int b) {
        if(a == b) {
            return String.valueOf(a);
        }

        return "" + a + "->" + b;
    }
}
