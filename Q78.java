package leetcode.medium;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Created by cenumah on 2020-01-10
 */
public class Q78 {

    public static void main(String[] args) {

        System.out.println(subsets(new int[]{1,2,3}));
        System.out.println(subsets(new int[]{1,2,3, 5}));
        System.out.println(subsets(new int[]{}));

        System.out.println(subsets(new char[]{}));
        System.out.println(subsets("abc".toCharArray()));
        System.out.println(subsets("ok".toCharArray()));
    }

    private static List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> list = new ArrayList<>();
        list.add(Collections.emptyList());

        for(int num : nums) {
            List<List<Integer>> add = new ArrayList<>();
            for(List<Integer> l : list) {
                List<Integer> a = new ArrayList<>(l);
                a.add(num);
                add.add(a);
            }
            list.addAll(add);
        }
        return list;
    }

    static List<List<Integer>> allSubArrays(int[] arr) {

        List<List<Integer>> result = new ArrayList<>();
        result.add(new ArrayList<>());
        int len = arr.length;

        for(int size=1; size <= len; size++) {
            for(int start=0; start<=len-size; start++) {

                List<Integer> list = new ArrayList<>();
                for(int i=start; i<start+size; i++) {
                    list.add(arr[i]);
                }

                result.add(list);
            }

        }

        return result;
    }

    private static List<List<Character>> subsets(char[] arr) {
        List<List<Character>> result = new ArrayList<>();
        result.add(new ArrayList<>());

        for(char c : arr) {
            List<List<Character>> updates = new ArrayList<>();
            for(List<Character> l : result){
                List<Character> update = new ArrayList<>(l);
                update.add(c);
                updates.add(update);
            }
            result.addAll(updates);
        }
        return result;
    }


}
