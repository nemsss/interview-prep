package others;

/**
 * Created by cenumah on 2020-01-27
 */
public class FindFirstDuplicate {

    public static void main(String[] args) {

        System.out.println(firstDuplicate(new int[]{1,2,3,2,4}));
        System.out.println(firstDuplicate(new int[]{1,2,1,2,4}));
        System.out.println(firstDuplicate(new int[]{5,4,3,2,1,5}));
        System.out.println(firstDuplicate(new int[]{2,2,1}));
        System.out.println(firstDuplicate(new int[]{0,1,2}));
    }

    private static int firstDuplicate(int[] nums) {
        if(nums == null || nums.length == 0) {
            return -1;
        }

        int max = nums.length;

        for(int i=0; i<max; i++) {

            int val = nums[i] % max; // get the number which was originally in the array
            nums[val] += max; // add max to the number's "position" to show it has been visited

            if(nums[val] > 2*max) { //check if we've visited it previously
                return val;
            }
        }

        return -1;
    }
}
