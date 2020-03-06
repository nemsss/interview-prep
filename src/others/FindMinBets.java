package others;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;

/**
 * Created by cenumah on 2019-11-29
 */
public class FindMinBets {

    public static void main(String[] args) {

//        System.out.println(new FindMinBets().solution(8,0));
//        System.out.println(new FindMinBets().solution(10,10));
//        System.out.println(new FindMinBets().solution(18,2));
//        System.out.println(new FindMinBets().solution(35,4));
//        System.out.println(new FindMinBets().solution(35,3));

//        System.out.println(new FindMinBets().solution(1800,21));
//        System.out.println(new FindMinBets().solution(4900,11));

        System.out.println(new FindMinBets().solution2(8,0));
        System.out.println(new FindMinBets().solution2(4900,11));
        System.out.println(new FindMinBets().solution2(43800,41));

        System.out.println("------------");

        System.out.println(new FindMinBets().solution3(8,0));
        System.out.println(new FindMinBets().solution3(4900,11));
        System.out.println(new FindMinBets().solution3(438000,41));

        System.out.println("-------------");
        System.out.println(new FindMinBets().solution4(8,0));
        System.out.println(new FindMinBets().solution4(4900,11));
        System.out.println(new FindMinBets().solution4(438000,41));

    }

    private int solution4(int N, int K){

        //Base Case
        //when k is 0, there will be no all ins, number of games will be n - 1 based on patterns in small numbers
        //when n is below 3, number of rounds will be at most n-1
        //recursive function
        //if n is even, recursively divide n by 2 and decrement k number of all ins till base case is met
        //if n is odd, subtract 1 from n till base case is met;
        if (K < 1 || N < 4)
            return N - 1;

        //check if n is odd or even
        return 1 + (N % 2 != 0 ? solution4(N - 1, K) : solution4(N / 2, K - 1));
    }

    public int solution3(int target, int maxAllIns) {

        int moves = 0;
        if(maxAllIns==0){
            return target-1;
        }

        while (target > 1){
            if(target%2==0 && maxAllIns>0){
                target = target/2;
                maxAllIns--;
            }
            else {
                target--;
            }

            moves++;
        }

        return moves;
    }

    public int solution2(int total, int allIns) {
        // write your code in Java SE 8
        return findMinBets2(total, allIns);
    }

    private int findMinBets2(int N, int K) {

        int res = 0;

        Queue<int[]> q = new LinkedList<>();
        q.add(new int[]{1, K});

        while (!q.isEmpty()) {

            int size = q.size();
            while (size-- > 0) {

                int[] info = q.poll();
                assert info != null;
                int current = info[0];
                int allIns = info[1];

                if(current == N) {
                    return res;
                }

                if(current > N) {
                    continue;
                }

                q.offer(new int[]{current+1, allIns});

                if(allIns > 0) {
                    q.offer(new int[]{current*2, allIns-1});
                }
            }

            res++;

            if(q.size() == 1 && q.peek()[1] == 0) {
                return res + N - q.peek()[0];
            }

        }

        return res;
    }


    public int solution(int total, int allIns) {
        // write your code in Java SE 8
        map = new HashMap<>();
        return findMinBets(1, total, allIns);
    }

    private Map<Integer, Map<Integer, Integer>> map;// = new HashMap<>();

    private Integer checkMap(int target, int allIns) {
        if(map.containsKey(target)){
            if(map.get(target).containsKey(allIns)){
                return map.get(target).get(allIns);
            }
        }

        return null;
    }

    private int findMinBets(int current, int total, int allIns){
        if(current == total) {
            return 0;
        }

        if(current > total) {
            return Integer.MAX_VALUE;
        }

        if(allIns < 1) {
            return total - current;
        }

        int target = total - current;

        Integer existing = checkMap(target, allIns);
        if(existing != null) {
            return existing;
        }

        int res = 1 + Math.min(
                findMinBets(current * 2, total, allIns-1),
                findMinBets(current + 1, total, allIns)
        );

        map.putIfAbsent(target, new HashMap<>());
        map.get(target).putIfAbsent(allIns, res);

        return res;
    }
}
