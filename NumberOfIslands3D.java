package friends;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by cenumah on 2020-02-17
 */
public class NumberOfIslands3D {

    static public void main( String args[] ) {
        System.out.println("Practice makes Perfect!");

    /*
    That's perfect, the only way to go is to represent it as chemicals

    https://leetcode.com/discuss/interview-experience/437248/Palantir-or-FDSWE-Intern-or-London-or-Nov-2019-Reject
    https://leetcode.com/discuss/interview-experience/131077/Palantir-or-SDE-New-Grad-or-Palo-Alto-or-May-2018

    int[][][] p = new int[][][] {{{5,0}}, {{1,2}}, {{3,4}}};
    System.out.println(p[0][0][0]);

    1 = 1(2)
    2 = 2(1(2))
    3 = 3(2(1(2)))
    k = k(k-1);

    */
            int[][][] input = new int[][][] {{{0,1,0},
                    {1,0,1},
                    {0,0,0}},

                    {{0,1,1},
                            {1,1,1},
                            {0,1,0}},

                    {{0,0,0},
                            {1,0,0},
                            {0,0,1}}};

    /*
      input[0][0][1]


    */
            System.out.println(numOfIslands(input));
        }

        public static List<Integer> numOfIslands(int[][][] input){
            List<Integer> islands = new ArrayList<>();
            for(int x = 0; x < input.length; x++){
                for(int y = 0; y < input[x].length; y++){
                    for(int z = 0; z < input[x][y].length; z++){
                        if(input[x][y][z] == 1){
                            int island = dfs(x, y, z, input);
                            islands.add(island);
                        }
                    }
                }
            }

            return islands;
        }

        private static int dfs(int x, int y, int z, int[][][] input){
            if(x < 0 || x >= input.length) return 0;
            if(y < 0 || y >= input[x].length) return 0;
            if(z < 0 || z >= input[x][y].length) return 0;
            if(input[x][y][z] != 1) {
                return 0;
            }

            input[x][y][z] = -1;
            int[] positions = new int[]{x,y,z};

            List<int[]> neighbours = getNeighbours(positions);
            int count = 1;
            for(int[] pos : neighbours) {
                count += dfs(pos[0], pos[1], pos[2], input);
            }

            return count;
        }

        //Werd????
        private static List<int[]> getNeighbours(int[] pos) {

            /**

             1 = 1(2)
             2 = 2(1(2))
             3 = 3(2(1(2)))

             f(k) = k * f(k-1)

             x, y - 1, z
             x, y + 1, z
             x, y, z - 1
             x, y, z + 1

             x - 1, y, z
             x + 1, y, z
             x, y, z + 1
             x, y, z - 1

             x - 1, y, z
             x + 1, y, z
             x, y - 1, z
             x, y + 1, z
             **/

            List<int[]> res = new ArrayList<>();
            for(int i = 0; i < pos.length; i++){
                int idx = i;

                //[0,2,3]
                int[] minus = new int[pos.length];
                minus[i] = pos[i] - 1;
                for(int j = 0; j < pos.length; j++){
                    if(i == j) continue;
                    minus[j] = pos[j];
                }

                if(minus[i] >=0 && minus[i] < 3)
                    res.add(minus);

                //[2,2,3]
                int[] plus = new int[pos.length];
                plus[i] = pos[i] + 1;
                for(int j = 0; j < pos.length; j++){
                    if(i == j) continue;
                    plus[j] = pos[j];
                }

                if(plus[i] >=0 && plus[i] < 3)
                    res.add(plus);
            }

            return res;
        }



    }




    // Equilibrium
// Sensors
// Osmosis
// Event
    class Smell{
        List<List<Chemical>> chemicals;
    }

    class Chemical{
        String name;
        int intensity;
    }

