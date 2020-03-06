package geeksforgeeks;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by cenumah on 2019-12-21
 */
public class FindAllRectangles {

    public static void main(String[] args) {

        int[][] input = new int[][]{
                {1, 1, 1, 1, 1, 1, 1},
            {1, 1, 1, 1, 1, 1, 1},
            {1, 1, 1, 0, 0, 0, 1},
            {1, 0, 1, 0, 0, 0, 1},
            {1, 0, 1, 1, 1, 1, 1},
            {1, 0, 1, 0, 0, 0, 0},
            {1, 1, 1, 0, 0, 0, 1},
            {1, 1, 1, 1, 1, 1, 1}
        };

        System.out.println(findAllRectangles(input));

        input = new int[][] {
                {1, 0, 1, 1, 1, 1, 1},
            {1, 1, 0, 1, 1, 1, 1},
            {1, 1, 1, 0, 0, 0, 1},
            {1, 0, 1, 0, 0, 0, 1},
            {1, 0, 1, 1, 1, 1, 1},
            {1, 1, 1, 0, 0, 0, 0},
            {1, 1, 1, 1, 1, 1, 1},
            {1, 1, 0, 1, 1, 1, 0}
        };

        System.out.println(findAllRectangles(input));
    }

    static List<List<Integer>> findAllRectangles(int[][] grid) {

        if(grid == null || grid.length == 0) {
            return new ArrayList<>();
        }

        List<List<Integer>> result = new ArrayList<>();

        for(int i=0; i<grid.length; i++) {
            for(int j=0; j<grid[i].length; j++) {
                if(grid[i][j] == 0) {
                    result.add(getCoords(i, j, grid));
                }
            }
        }

        return result;
    }

    private static List<Integer> getCoords(int start_i, int start_j, int[][] grid) {

        List<Integer> rectangle = new ArrayList<>();
        rectangle.add(start_i);
        rectangle.add(start_j);

        int end_i = start_i;
        int end_j = start_j;
        //go down
        while (end_i<grid.length && grid[end_i][end_j] == 0) {
            end_i++;
        }

        end_i-=1;
        while (end_j<grid[end_i].length && grid[end_i][end_j] == 0) {
            end_j++;
        }

        rectangle.add(end_i);
        rectangle.add(end_j-1);

        for(int i=start_i; i<=end_i; i++){
            for(int j=start_j; j <end_j; j++) {
                grid[i][j] = -1;
            }
        }

        return rectangle;
    }
}
