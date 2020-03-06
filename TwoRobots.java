package hackerrank;

/**
 * Created by cenumah on 2019-12-16
 */
public class TwoRobots {

    public static void main(String[] args) {

        int[][] queries = new int[][] {
                {1,5},
                {3,2},
                {4,1},
                {2,4}
        };

        System.out.println(twoRobots(5, queries));

        queries = new int[][] {
                {1,2},
                {4,3}
        };

        System.out.println(twoRobots(4, queries));
    }

    static int twoRobots(int m, int[][] queries) {
        /*
         * Write your code here.
         */
        int res = 0;
        int r1 = -1;
        int r2 = -1;

        for(int[] q : queries) {
            if(r1 == q[0] || r1 < 0 || (distanceTo(r1, q) < distanceTo(r2, q) && r2 > 0)) {
                if(r1 < 0) {
                    r1 = q[0];
                }
                res+= Math.abs(r1 - q[0]) + Math.abs(q[1] - q[0]);
                r1 = q[1];
            } else {
                if(r2 < 0) {
                    r2 = q[0];
                }
                res+= Math.abs(r2 - q[0]) + Math.abs(q[1] - q[0]);
                r2 = q[1];
            }
        }

        return res;
    }

    private static int distanceTo(int robot, int[] query) {
        return Math.abs(robot - query[0]);
    }
}
