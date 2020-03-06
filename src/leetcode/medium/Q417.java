package leetcode.medium;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by cenumah on 2019-11-30
 */
public class Q417 {

    public static void main(String[] args) {

        int[][] input = new int[][] {
                {1,2,2,3,5},
                {3,2,3,4,4},
                {2,4,5,3,1},
                {6,7,1,4,5},
                {5,1,1,2,4}};

//        System.out.println(new Q417().pacificAtlantic(input));

        input = new int[][] {
                {6,7},
                {5,1}};

//        System.out.println(new Q417().pacificAtlantic(input));

        input = new int[][] {
                {1,2,3},
                {8,9,4},
                {7,6,5}};

        System.out.println(new Q417().pacificAtlantic(input));
    }

    public List<List<Integer>> pacificAtlantic(int[][] matrix) {
        if(matrix==null || matrix.length == 0)
            return new ArrayList<>();

        List<List<Integer>> res = new ArrayList<>();
        int rows = matrix.length;
        int cols = matrix[0].length;
        Boolean[][] pacific = new Boolean[rows][cols];
        Boolean[][] atlantic = new Boolean[rows][cols];

        for(int i=0; i<matrix.length; i++) {
            for(int j=0; j<matrix[i].length; j++) {
//                if(pacific(i,j, matrix, pacific) && atlantic(i, j, matrix, atlantic)) {
//                    res.add(new ArrayList<>(Arrays.asList(i,j)));
//                }
            }
        }

        return res;
    }
}
