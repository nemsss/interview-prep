package others;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by cenumah on 2020-01-12
 */
public class CountClouds {

    public static void main(String[] args) {

        System.out.println(countClouds(new int[][]{{0,1,1,0}, {1,1,0,1}, {0,0,1,0}, {1,1,1,0}}));
        System.out.println(countClouds(new int[][]{{0,1,0,1}, {1,0,1,0}, {0,1,0,1}, {1,0,1,0}}));
        System.out.println(countClouds(new int[][]{{0,0,0,0}, {0,0,0,0}, {0,0,0,0}, {0,0,0,0}}));
        System.out.println(countClouds(new int[][]{{1,1,1,1}, {1,1,1,1}, {1,1,1,1}, {1,1,1,1}}));
    }

    private static int countClouds(int[][] sky) {

        if(sky == null || sky.length == 0) {
            return 0;
        }

        int clouds = 0;

        Set<Integer> visited = new HashSet<>();

        for(int i=0; i<sky.length; i++) {
            for(int j=0; j<sky[i].length; j++) {

                if(sky[i][j] == 1 && !visited.contains(getPosition(i,j))) {
                    mark(i, j, sky, visited);
                    clouds++;
                }
            }
        }

        return clouds;
    }

    private static void mark(int i, int j, int[][] sky, Set<Integer> visited) {

        if(i<0 || i>= sky.length || j<0 || j>= sky[i].length) {
            return;
        }

        int position = getPosition(i, j);
        if(visited.contains(position) || sky[i][j] == 0) {
            return;
        }

        visited.add(position);
        mark(i+1, j, sky, visited);
        mark(i-1, j, sky, visited);
        mark(i, j+1, sky, visited);
        mark(i, j-1, sky, visited);
    }

    private static int getPosition(int i, int j) {
        return i*10 + j;
    }
}
