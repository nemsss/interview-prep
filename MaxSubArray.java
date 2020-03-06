package hackerrank;

import java.util.Arrays;
import java.util.Deque;
import java.util.LinkedList;

/**
 * Created by cenumah on 2019-12-03
 */
public class MaxSubArray {

    public static void main(String[] args) {

        System.out.println(Arrays.toString(maxSubarray(new int[]{1, 2, 3, 4})));
        System.out.println(Arrays.toString(maxSubarray(new int[]{2, -1, 2, 3, 4, -5})));
    }

    /*
    We define subsequence as any subset of an array. We define a subarray as a contiguous subsequence in an array.

    Given an array, find the maximum possible sum among:
        all nonempty subarrays.
        all nonempty subsequences.

    Print the two values as space-separated integers on one line.
     */
    static int[] maxSubarray(int[] arr) {

        if(arr == null || arr.length == 0)
            return new int[0];

        int sum = arr[0];
        int subArrayMax = Integer.MIN_VALUE;
        for(int i=1; i<arr.length; i++) {

            if(sum <= 0) {
                sum = 0;
            }

            sum+= arr[i];

            if(sum > subArrayMax) {
                subArrayMax = sum;
            }
        }

        subArrayMax = Math.max(subArrayMax, sum);

        Arrays.sort(arr);

        int subSeqMax = 0;
        if(arr[arr.length-1] < 0) {
            subSeqMax = arr[arr.length-1];
        } else {
            for(int a : arr){
                subSeqMax+= a < 0 ? 0 : a;
            }
        }

        return new int[]{subArrayMax, subSeqMax};
    }
}
