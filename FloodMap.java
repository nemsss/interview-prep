package others;

import java.util.*;

public class FloodMap {
    static public void main( String args[] ) {

        int[][] input = new int[][]{
                {1, 2, 1, 3, 4},
                {1, 5, 2, 2, 2},
                {4, 5, 1, 9, 7},
                {3, 5, 3, 7, 6},
                {4, 3, 1, 7, 3}};
//        System.out.println(Arrays.deepToString(findPlateaus(input)));

//        System.out.println(Arrays.deepToString(findHighPointsBool(input)));

        System.out.println(Arrays.deepToString(findRiskScores(input)));

        input = new int[][]{
                {1, 2, 3, 4},
                {5, 5, 5, 2},
                {5, 1, 1, 1},
                {0, 0, 0, 9}};
//        System.out.println(Arrays.deepToString(findPlateaus(input)));

        input = new int[][]{{1,1,1,1,1}, {1,2,2,2,1}, {1,2,3,2,1}, {1,2,2,2,1}, {1,1,1,1,1}, {1,1,1,1,3}};

//        System.out.println(Arrays.deepToString(findPlateaus(input)));

    }


    //Question 1 Find Highpoints.
    /*
                {1, 2, 1, 3, 4},
                {1, 5, 2, 2, 2},
                {4, 5, 1, 9, 7},
                {3, 5, 3, 7, 6},
                {4, 3, 1, 7, 3}

                {0, 0, 0, 0, 1},
                {0, 0, 0, 0, 0},
                {0, 0, 0, 1, 0},
                {0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0}}
    */
    public static boolean[][] findHighPointsBool(int[][] map) {

        // null && empty check

        boolean[][] res = new boolean[map.length][map[0].length];
        for(int i=0; i<map.length; i++) {
            for(int j=0; j<map[i].length; j++) {
                res[i][j] = check(i, j, map);
            }
        }

        return res;
    }

    private static boolean check(int i, int j, int[][] map) {

        boolean high;
        int val = map[i][j];
        int rows = map.length;
        int cols = map[i].length;

        high = i == 0 || j == 0 || (map[i - 1][j - 1] < val);//upward left
        high&= i==0 || map[i-1][j] < val;//up
        high&= i==0 || j==cols-1 || map[i-1][j+1] < val; //upward right
        high&= j== 0 || map[i][j-1] < val; //left
        high&= j==cols-1 || map[i][j+1] < val; //right
        high&= i==rows-1 || j==0 || map[i+1][j-1] < val; //downward left
        high&= i==rows-1 || map[i+1][j] < val; //down
        high&= i==rows-1 || j==cols-1 || map[i+1][j+1] < val; //downward right

        return high;
    }



    /*Question 2 Find RiskScores.

                {1, 2, 1, 3, 4},
                {1, 5, 2, 2, 2},
                {4, 5, 1, 9, 7},
                {3, 5, 3, 7, 6},
                {4, 3, 1, 7, 3}

                {0, 0, 0, 0, 1}, 0, 4
                {0, 0, 0, 0, 0},
                {0, 0, 0, 1, 0},
                {0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0}

                >
                {0, 0, 1, 1, 1}, 4
                {0, 0, 1, 0, 0},
                {0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0}


                [0, 0, 2, 1, 1],
                [0, 0, 2, 2, 2],
                [0, 0, 2, 1, 1],
                [0, 0, 1, 1, 1],
                [0, 0, 1, 0, 1]]
    */
    public static int[][] findRiskScores(int[][] map) {

        boolean[][] highs = findHighPointsBool(map);
        int[][] res = new int[map.length][map[0].length];

        boolean[][] visited;
        for(int i=0; i<map.length; i++) {
            for(int j=0; j<map[i].length; j++) {
                if(highs[i][j]) {
                    visited = new boolean[map.length][map[0].length];
                    findRisk(i,j, map[i][j]+1, map, visited, res);
                }
            }
        }

        return res;
    }

    private static void findRisk(int i, int j, int target, int[][] map, boolean[][] visited, int[][] res) {

        if(i<0 || i>=map.length || j<0 || j>=map[i].length || visited[i][j]){
            return;
        }

        int val = map[i][j];
        if(val >= target){
            return;
        }

        res[i][j]+= 1;
        visited[i][j] = true;
        findRisk(i-1,j-1, val, map, visited, res);
        findRisk(i-1,j,val, map, visited, res);
        findRisk(i-1,j+1,val, map, visited, res);
        findRisk(i, j-1, val, map, visited, res);
        findRisk(i, j+1, val, map, visited, res);
        findRisk(i+1, j-1, val, map, visited, res);
        findRisk(i+1, j, val, map, visited, res);
        findRisk(i+1, j+1, val, map, visited, res);
    }



    //Question 3 Find Plateaus. Print out as bool.
    /*
                <=
                1 2 3 4    0 0 0 0
                5 5 4 2    1 1 0 0
                5 1 1 8 -> 0 0 0 0
                0 0 0 9    0 0 0 0

    */

    public static boolean[][] findPlateaus(int[][] map) {

        boolean[][] isHigh = new boolean[map.length][map[0].length];
        for(int i=0; i<map.length; i++) {
            for(int j=0; j<map[i].length; j++) {
                isHigh[i][j] = check2(i, j, map);
            }
        }

        boolean[][] res = new boolean[map.length][map[0].length];
        boolean[][] visiting = new boolean[map.length][map[0].length];
        for(int i=0; i<map.length; i++) {
            for(int j=0; j<map[i].length; j++) {
                if(isHigh[i][j]){
                    res[i][j] = plateauCheck(i,j, map[i][j], map, isHigh, visiting);
                }
            }
        }

        return res;
    }

    private static boolean plateauCheck(int i, int j, int target, int[][] map, boolean[][] isHigh, boolean[][] visiting) {

        if(i<0 || i>=map.length || j<0 || j>=map[i].length || map[i][j] < target || visiting[i][j]){
            return true;
        }

        int val = map[i][j];
        if(val==target && !isHigh[i][j]){
            return false;
        }

        visiting[i][j] = true;
        boolean valid = plateauCheck(i-1,j-1, val, map, isHigh, visiting);
        valid&= plateauCheck(i-1,j,val, map, isHigh, visiting);
        valid&= plateauCheck(i-1,j+1,val, map, isHigh, visiting);
        valid&= plateauCheck(i, j-1, val, map, isHigh, visiting);
        valid&= plateauCheck(i, j+1, val, map, isHigh, visiting);
        valid&= plateauCheck(i+1, j-1, val, map, isHigh, visiting);
        valid&= plateauCheck(i+1, j, val, map, isHigh, visiting);
        valid&= plateauCheck(i+1, j+1, val, map, isHigh, visiting);

        visiting[i][j] = false;
        return valid;
    }

    private static boolean check2(int i, int j, int[][] map) {

        boolean high;
        int val = map[i][j];
        int rows = map.length;
        int cols = map[i].length;

        high = i == 0 || j == 0 || (map[i - 1][j - 1] <= val);//upward left
        high&= i==0 || map[i-1][j] <= val;//up
        high&= i==0 || j==cols-1 || map[i-1][j+1] <= val; //upward right
        high&= j== 0 || map[i][j-1] <= val; //left
        high&= j==cols-1 || map[i][j+1] <= val; //right
        high&= i==rows-1 || j==0 || map[i+1][j-1] <= val; //downward left
        high&= i==rows-1 || map[i+1][j] <= val; //down
        high&= i==rows-1 || j==cols-1 || map[i+1][j+1] <= val; //downward right

        return high;
    }


    private static boolean plateauCheck2(int i, int j, int[][] city, boolean[][] isHigh) {

          boolean valid;
          int val = city[i][j];
          int rows = city.length;
          int cols = city[i].length;

          valid = i == 0 || j == 0 || (city[i - 1][j - 1] != val) || isHigh[i-1][j-1];//upward left
          valid&= i==0 || city[i-1][j] != val || isHigh[i-1][j];//up
          valid&= i==0 || j==cols-1 || city[i-1][j+1] != val || isHigh[i-1][j+1]; //upward right
          valid&= j== 0 || city[i][j-1] != val || isHigh[i][j-1]; //left
          valid&= j==cols-1 || city[i][j+1] <= val || isHigh[i][j+1]; //right
          valid&= i==rows-1 || j==0 || city[i+1][j-1] <= val || isHigh[i+1][j-1]; //downward left
          valid&= i==rows-1 || city[i+1][j] <= val || isHigh[i+1][j]; //down
          valid&= i==rows-1 || j==cols-1 || city[i+1][j+1] <= val || isHigh[i+1][j+1]; //downward right

          return valid;
      }
     
}
