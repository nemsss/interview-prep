package hackerrank;

import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

/**
 * Created by cenumah on 2020-01-14
 */
public class Abbreviation {

    public static void main(String[] args) {

        System.out.println(abbreviation("ABcDE", "ABDE"));
        System.out.println(abbreviation("daBcd", "ABC"));
        System.out.println(abbreviation("AbcDE", "AFDE"));
        System.out.println();
        System.out.println(abbreviation("beFgH", "EFG"));
    }

    static boolean abbreviate(String s, int i1, String target, int i2) {

        if(i1 >= s.length()) {
            return i2 >= target.length();
        }

        if(i2 >= target.length()) {
            return true;
        }

        char c1 = s.charAt(i1);
        char c2 = target.charAt(i2);

        if(Character.isUpperCase(c1)) {
            return c1 == c2 ? abbreviate(s, i1+1, target, i2+1)
                    : abbreviate(s, i1+1, target, i2);
        }

        c1 = Character.toUpperCase(c1);
        return c1 == c2 ? abbreviate(s, i1+1, target, i2+1)
                : abbreviate(s, i1+1, target, i2);
    }

    static String abbreviation(String s1, String s2) {

        //a= ABcDE b=ABDE
        //a= daBcd b=ABC
        //a= AbcDE b=AFDE

        if(s1 == null || s2 == null || s2.length() > s1.length()) {
            return "NO";
        }

        return abbreviate(s1, 0, s2, 0) ? "YES" : "NO";

        /*
            ABcDE
            ABDE
         */


//        boolean[][] cache = new boolean[s1.length()][s2.length()];
//        for(int i=0; i<s1.length(); i++) {
//            for(int j=0; j<s2.length(); j++) {
//                char a = s1.charAt(i);
//                char b = s2.charAt(j);
//                if(i==0 && j==0) {
//                    cache[i][j] = Character.toUpperCase(a) == b;
//                } else if (j>i){
//                    cache[i][j] = false;
//                }else if(i == 0) {
//
//                } else if(j == 0) {
//
//                } else {
//
//                }
//            }
//        }
//
//        return cache[s1.length()-1][s2.length()-1] ? "YES" : "NO";
    }
}
