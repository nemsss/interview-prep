package leetcode.easy;

/**
 * Created by cenumah on 2019-11-30
 */
public class Q463 {

    public static void main(String[] args) {
        System.out.println(new Q463().islandPerimeter(new int[][]{
                        {0,1,0,0},
                        {1,1,1,0},
                        {0,1,0,0},
                        {1,1,0,0}}));

        System.out.println(new Q463().islandPerimeter(new int[][]{{1}}));
    }

    public int islandPerimeter(int[][] grid) {

        if(grid==null || grid.length==0)
            return 0;

        for(int i=0; i<grid.length; i++) {
            for(int j=0; j<grid[i].length; j++) {
                if(grid[i][j] == 1)
                    return helper(i, j, grid, new boolean[grid.length][grid[i].length]);
            }
        }

        return 0;
    }

    private int helper(int i, int j, int[][] grid, boolean[][] visited) {
        if(i<0 || i>=grid.length || j<0 || j>=grid[i].length) {
            return 0;
        }

        if(grid[i][j] != 1 || visited[i][j]) {
            return 0;
        }

        int res = 0;
        if(i == 0)  res+= 1; //top row
        if(i == grid.length-1) res+= 1; //bottom row
        if(j == 0) res+= 1; //left-most column
        if(j == grid[i].length-1) res+= 1; //right-most column

        if(i>0 && grid[i-1][j] != 1) res+= 1; //top-most plot of land
        if(i<grid.length-1 && grid[i+1][j] != 1) res+= 1; //bottom-most plot of land

        if(j>0 && grid[i][j-1] != 1) res+= 1; //left-most plot of land
        if(j<grid[i].length-1 && grid[i][j+1] != 1) res+= 1; //right-most plot of land

        visited[i][j] = true;
        return res +
                helper(i+1, j, grid, visited) +
                helper(i-1, j, grid, visited) +
                helper(i, j+1, grid, visited) +
                helper(i, j-1, grid, visited);
    }
}
