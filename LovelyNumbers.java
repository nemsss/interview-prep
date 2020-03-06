package others;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by cenumah on 2019-11-29
 */
public class LovelyNumbers {

    public static void main(String[] args) {

        System.out.println(new LovelyNumbers().solution(0,3353));
    }

    public int solution(int A, int B) {
        // write your code in Java SE 8
        int count = 0;

        int num = A;
        while(num <= B) {
            count += isLovely(num) ? 1 : 0;
            num++;
        }

        return count;
    }

    private boolean isLovely(int input) {
        if(input < 111) return true;

        Map<Integer, Integer> digitCount = new HashMap<>();
        String num = String.valueOf(input);
        for(int i=0; i<num.length(); i++) {
            char ch = num.charAt(i);
            int digit = Character.getNumericValue(ch);
            digitCount.putIfAbsent(digit, 0);
            digitCount.put(digit, digitCount.get(digit)+1);
        }

        for(int i : digitCount.values()){
            if(i >= 3) return false;
        }

        return true;
    }

}
