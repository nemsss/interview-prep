package leetcode.medium;

/**
 * Created by cenumah on 2020-03-03
 */
public class Q75 {

    public static void main(String[] args) {

        System.out.println(sortColors(new int[] {0,2,1,0,2,1,2,1}));
    }

    public static int[] sortColors(int[] nums) {

        if(nums == null || nums.length == 0) {
            return nums;
        }

        int[] count = new int[3];
        for(int num : nums) {
            count[num]++;
        }

        for(int i=1; i<count.length; i++) {
            count[i]+= count[i-1];
        }

        for(int i=0; i<nums.length; i++) {
            int num = nums[i];
            if(count[num] < nums.length && count[num] >= 0) {
                count[num]--;
                nums[count[num]] = num;
            }
        }

        return nums;
    }
}
