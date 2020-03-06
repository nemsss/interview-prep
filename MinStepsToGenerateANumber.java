package others;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

/**
 * Created by cenumah on 2020-01-15
 */
public class MinStepsToGenerateANumber {

    public static void main(String[] args) {
        System.out.println(findMin(10));
        System.out.println(findMin(3));
    }

    private static int findMin(int target) {

        if(target == 1) {
            return 0;
        }

        Set<Integer> seen = new HashSet<>();
        Queue<Integer> q = new LinkedList<>();
        q.add(1);
        seen.add(1);

        int steps = 1;

        while (!q.isEmpty()) {

            int size = q.size();
            while(size-- > 0) {
                Integer curr = q.poll();
                if(!seen.contains(curr/3)) {
                    if(curr/3 == target) {
                        return steps;
                    }
                    q.add(curr/3);
                    seen.add(curr/3);
                }

                if(!seen.contains(curr*2)) {
                    if(curr*2 == target) {
                        return steps;
                    }
                    q.add(curr*2);
                    seen.add(curr*2);
                }
            }

            steps++;
        }

        return -1;
    }
}
