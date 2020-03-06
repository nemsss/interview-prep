package others;

import java.time.Instant;
import java.util.LinkedList;

/**
 * Created by cenumah on 2020-01-05
 */
public class FindMinCommands {

    public static void main(String[] args) {

        System.out.println(Instant.now());
        System.out.println(new FindMinCommands().solution(-1));
        System.out.println(Instant.now());
        System.out.println(new FindMinCommands().solution2(-1));
        System.out.println(Instant.now());
        System.out.println(new FindMinCommands().solution(-11));
        System.out.println(Instant.now());
        System.out.println(new FindMinCommands().solution2(-11));
        System.out.println(Instant.now());
        System.out.println(new FindMinCommands().solution2(8));
        System.out.println(new FindMinCommands().solution2(19));

    }

    public int solution(int N) {
        // write your code in Java SE 8

        int l = 0; // 2*l - r
        int r = 1; // 2*r - l

        return search(l, r, N);
    }

    public int solution2(int N) {
        // write your code in Java SE 8

        int l = 0; // 2*l - r
        int r = 1; // 2*r - l

        return search2(l, r, N);
    }

    private int max = Integer.MAX_VALUE;
    private int min = Integer.MIN_VALUE;

    private int search(int a, int b, int target) {

        int count = 0;

        LinkedList<Pair> q = new LinkedList<>();
        q.add(new Pair(a, b));

        while(!q.isEmpty()) {

            int size = q.size();
            while(size-- > 0) {
                Pair pair = q.remove();
                if(pair.l == target || pair.r == target) {
                    return count;
                }

                if(pair.l < max && pair.l > min && pair.r < max && pair.r > min) {
                    q.add(new Pair(func(pair.l, pair.r), pair.r));
                    q.add(new Pair(pair.l, func(pair.r,pair.l)));
                }
            }

            count++;
        }

        return -1;
    }

    private int search2(int a, int b, int target) {

        int count = 0;

        LinkedList<int[]> q = new LinkedList<>();
        q.add(new int[]{a, b});

        while(!q.isEmpty()) {

            int size = q.size();
            while(size-- > 0) {
                int[] pair = q.remove();
                if(pair[0] == target || pair[1] == target) {
                    return count;
                }

                if(pair[0] < max && pair[0] > min && pair[1] < max && pair[1] > min) {
                    q.add(new int[]{func(pair[0], pair[1]), pair[1]});
                    q.add(new int[]{pair[0], func(pair[1],pair[0])});
                }
            }

            count++;
        }

        return -1;
    }

    class Pair {
        int l;
        int r;

        Pair(){}
        Pair(int l, int r) {
            this.l = l;
            this.r = r;
        }
    }

    private int func(int a, int b) {
        return 2*a - b;
    }
}
