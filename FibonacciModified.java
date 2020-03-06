package hackerrank;

import java.math.BigInteger;

/**
 * Created by cenumah on 2020-01-09
 */
public class FibonacciModified {

    public static void main(String[] args) {

        System.out.println(fibonacciModified(BigInteger.valueOf(0L), BigInteger.valueOf(1L), 5));
    }

    static BigInteger[] map;

    static BigInteger fibonacciModified(BigInteger t1, BigInteger t2, int n) {

        // f(x+2) = f(x) + f(x+1) ^ 2
        // f(x) = f(x-1) ^ 2 + f(x-2)

        if(n == 0) {
            return t1;
        }

        if(n == 1) {
            return t2;
        }

        map = new BigInteger[n];

        map[0] = t1;
        map[1] = t2;

        int idx = 2;

        while(idx < n) {
            map[idx] = map[idx-1].pow(2).add(map[idx-2]);
            idx++;
        }

        return map[idx-1];
    }
}
