package leetcode.medium;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by cenumah on 2019-11-12
 */
public class Q454 {

    public static void main(String[] args) {

        int[] l1 = new int[]{1,2,3};
        int[] l2 = new int[]{-2,-1,5};
        int[] l3 = new int[]{-1,2,-4};
        int[] l4 = new int[]{0,2,-4};

        System.out.println(fourSumCount(l1,l2,l3,l4));
    }

    private static int fourSumCount(int[] l1, int[] l2, int[] l3, int[] l4) {

        Map<Integer, Integer> l12_map = new HashMap<>();
        Map<Integer, Integer> l34_map = new HashMap<>();

        for(int i=0; i<l1.length; i++){
            for(int j=0; j<l2.length; j++) {
                l12_map.put(l1[i]+l2[j], l12_map.getOrDefault(l1[i]+l2[j], 0) + 1);
                l34_map.put(l3[i]+l4[j], l34_map.getOrDefault(l3[i]+l4[j], 0) + 1);
            }
        }

        int count = 0;
        for(int num : l12_map.keySet()){
            if(l34_map.containsKey(0-num)){
                count+= l12_map.get(num) * l34_map.get(0-num);
            }
        }

        return count;
    }
}
