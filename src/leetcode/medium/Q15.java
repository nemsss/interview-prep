package leetcode.medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by cenumah on 2019-11-12
 */
public class Q15 {

    public static void main(String[] args) {
        System.out.println(threeSum(new int[]{-1,0,2,1,-3,0,0,-1}));
    }

    private static List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        Arrays.sort(nums);

        for (int i=0; i<nums.length-2; i++) {
            if(i>0 && nums[i]==nums[i-1]){
                continue;
            }

            int j = i+1;
            int k = nums.length - 1;

            while(j<k) {
                if(nums[i] + nums[j] + nums[k] > 0){
                    k--;
                } else if(nums[i] + nums[j] + nums[k] < 0) {
                    j++;
                } else {
                    res.add(Arrays.asList(nums[i], nums[j], nums[k]));
                    j++;
                    k--;
                    while(j < k && nums[j]==nums[j-1]) {
                        j++;
                    }
                    while(k > j && nums[k]==nums[k+1]) {
                        k--;
                    }
                }
            }
        }

        return res;
    }

}
