package codewars;

import java.util.Deque;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Set;

/**
 * Created by cenumah on 2019-12-18
 */
public class ShortestKnightPath {

    public static void main(String[] args) {
        assertEquals("Test for (a2, a2)", 0, ShortestKnightPath.knight("a2", "a2"));
        assertEquals("Test for (a2, c3)", 1, ShortestKnightPath.knight("a2", "c3"));
        assertEquals("Test for (a1, c1)", 2, ShortestKnightPath.knight("a1", "c1"));
        assertEquals("Test for (a1, f1)", 3, ShortestKnightPath.knight("a1", "f1"));
        assertEquals("Test for (a1, f3)", 3, ShortestKnightPath.knight("a1", "f3"));
        assertEquals("Test for (a1, f4)", 4, ShortestKnightPath.knight("a1", "f4"));
        assertEquals("Test for (a1, f7)", 5, ShortestKnightPath.knight("a1", "f7"));
        assertEquals("Test for (a1, h8)", 6, ShortestKnightPath.knight("a1", "h8"));
        assertEquals("Test for (a1, k8)", -1, ShortestKnightPath.knight("a1", "k8"));
    }

    private static void assertEquals(String text, int expected, int result) {
        if(result != expected) {
            System.out.println(String.format("Incorrect solution. Got %d, expected %d", result, expected));
        } else {
            System.out.println(String.format("%s got %d, expected %d", text, result, expected));
        }
    }

    private static int knight(String start, String finish) {

        int[] src = getCoords(start);
        int[] dest = getCoords(finish);

        Set<Integer> visiting = new HashSet<>();
        Deque<Integer> queue = new LinkedList<>();
        queue.add(src[0]*10 + src[1]);
        int steps = -1;

        while(!queue.isEmpty()) {

            int searchSpace = queue.size();
            steps++;

            while (searchSpace-- > 0) {
                int pos = queue.poll();
                int j = pos % 10;
                int i = pos / 10;

                if(i<0 || i>=8 || j<0 || j>=8 || visiting.contains(pos)){
                    continue;
                }

                if(i == dest[0] && j == dest[1]){
                    return steps;
                }

                visiting.add(i*10 + j);

                queue.add((i+2)*10 + (j-1));
                queue.add((i+2)*10 + (j+1));

                queue.add((i-2)*10 + (j-1));
                queue.add((i-2)*10 + (j+1));

                queue.add((i+1)*10 + (j-2));
                queue.add((i+1)*10 + (j+2));

                queue.add((i-1)*10 + (j-2));
                queue.add((i-1)*10 + (j+2));
            }
        }

        return -1;
    }


    private static int knight1(String start, String finish) {
        // Your code here!

        if(start.equals(finish)) {
            return 0;
        }

        boolean[][] grid = new boolean[8][8];
        int[] src = getCoords(start);
        int[] dest = getCoords(finish);

        int shortest = getShortestPath(src[0], src[1], dest, grid);
        return shortest == 0 ? -1 : shortest;
    }

    private static int getShortestPath(int i, int j, int[] dest, boolean[][] visiting) {

        if(i<0 || i>=visiting.length || i<dest[0]-4 || i>dest[0]+4 ||
            j<0 || j>=visiting[i].length || j<dest[1]-4 || j>dest[1]+4 ||
                visiting[i][j]){
            return 100;
        }

        if(i == dest[0] && j == dest[1]){
            return 0;
        }

        visiting[i][j] = true;
        int steps = getShortestPath(i+2, j-1, dest, visiting);//up
        steps = Math.min(steps, getShortestPath(i+2, j+1, dest, visiting));//up

        steps = Math.min(steps, getShortestPath(i+1, j+2, dest, visiting));//left
        steps = Math.min(steps, getShortestPath(i-1, j+2, dest, visiting));//left

        steps = Math.min(steps, getShortestPath(i-2, j-1, dest, visiting));//down
        steps = Math.min(steps, getShortestPath(i-2, j+1, dest, visiting));//down

        steps = Math.min(steps, getShortestPath(i+1, j-2, dest, visiting));//left
        steps = Math.min(steps, getShortestPath(i-1, j-2, dest, visiting));//left

        visiting[i][j] = false;
        return 1 + steps;
    }

    private static int[] getCoords(String coord) {
        int x = coord.charAt(0) - 'a';
        int y = Character.getNumericValue(coord.charAt(1)) - 1;
        return new int[]{x,y};
    }
}
