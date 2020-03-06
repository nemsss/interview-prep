package util;

/**
 * Created by cenumah on 2019-12-21
 */
public class Helper {

    public static int min(int... ints) {
        int min = Integer.MAX_VALUE;
        for (int i: ints)
            if (i < min) min = i;
        return min; //min != Integer.MAX_VALUE ? min : -1;
    }
}
