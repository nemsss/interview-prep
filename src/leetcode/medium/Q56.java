package leetcode.medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by cenumah on 2020-02-25
 */
public class Q56 {

    public static void main(String[] args) {
        Q56 q = new Q56();
        int[][] input = new int[][] {{8,10}, {1,3}, {2,6}, {12, 15}};
        System.out.println(Arrays.deepToString(q.merge(input)));

        input = new int[][] {{5,10}, {1,3}, {2,6}, {9, 15}};
        System.out.println(Arrays.deepToString(q.merge(input)));
    }

    public int[][] merge(int[][] ranges) {

        if(ranges == null || ranges.length == 0) {
            return new int[][]{};
        }

        Arrays.sort(ranges, (o1, o2) -> o1[0] != o2[0] ? o1[0] - o2[0] : o1[1] - o2[1]);

        List<int[]> res = new ArrayList<>();
        int[] curr = ranges[0];
        for(int[] range : ranges) {
            if(range[0] <= curr[1]) {
                curr[1] = Math.max(range[1], curr[1]);
            } else {
                res.add(curr);
                curr = range;
            }
        }

        res.add(curr);

        int[][] result = new int[res.size()][2];
        for(int i=0; i<res.size(); i++) {
            result[i] = res.get(i);
        }

        return result;
    }
}
