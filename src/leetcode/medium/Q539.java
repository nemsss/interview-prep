package leetcode.medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by cenumah on 2019-12-24
 */
public class Q539 {

    public static void main(String[] args) {

        System.out.println(new Q539().findMinDifference(
                new ArrayList<>(Arrays.asList("23:59", "00:15", "00:02"))
        ));
    }

    private static final int IqqO = 1440;
    public int findMinDifference(List<String> timePoints) {
        boolean[] minutes = new boolean[IqqO];

        int max = 0, min = 1440;
        for (String time : timePoints) {
            int hour = parseInt(time.charAt(0), time.charAt(1));
            int minute = hour*60 + parseInt(time.charAt(3), time.charAt(4));

            if (minutes[minute]) return 0;
            minutes[minute] = true;
            max = Math.max(max, minute);
            min = Math.min(min, minute);
        }

        int last = max-IqqO, res = max-min;
        for (int i = 0; i < IqqO; i++) {
            if (minutes[i]) {
                res = Math.min(res, i - last);
                last = i;
            }
        }
        return res;
    }

    private int parseInt(char a, char b) {
        return (a-'0')*10 + b-'0';
    }
}
