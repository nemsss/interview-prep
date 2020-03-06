package leetcode.easy;

/**
 * Created by cenumah on 2019-12-05
 */
public class Q7 {

    public static void main(String[] args) {

        System.out.println(new Q7().reverse(231));
        System.out.println(new Q7().reverse(-231));
        System.out.println(new Q7().reverse(-210));
        System.out.println(new Q7().reverse(964632435));
        System.out.println(new Q7().reverse(1534236469));
    }

    public int reverse(int x) {

        int response = 0;

        while (x != 0) {
            if ((Integer.MAX_VALUE / 10 < response && x > 0) || (Integer.MIN_VALUE / 10 > response && x < 0)) {
                response = 0;
                break;
            } else {
                response = response * 10 + x % 10;
                x = x / 10;
            }
        }
        return response;
    }
}
