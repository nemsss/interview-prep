package others;

import java.util.*;

/**
 * Created by cenumah on 2020-02-26
 */
public class WelchSorting {

    private static Map<Integer, Integer> map = null;

    static public void main( String args[] ) {
        System.out.println( "Practice makes Perfect!" );

        //https://leetcode.com/discuss/interview-experience/428946/Bloomberg-or-SWE-New-Grad-or-London-or-Nov-2019-No-Offer

        System.out.println(sort(Arrays.asList("thij","cchichi",  "thing", "cd")));
        System.out.println(sort(Arrays.asList("ayo", "ayi", "ayem", "chi", "chichi")));

    }

    private static List<String> sort(List<String> words) {

        if(words == null || words.isEmpty()) {
            return words;
        }

        populateCharSet(); //TODO

        words.sort(WelchSorting::compare);
        return words;
    }

//ayo, ayi, ayem, chi, chichi

    private static int compare(String w1, String w2) {

        int i1 = 0;
        int i2 = 0;

        if(w1.equals(w2)) {
            return 0;
        }

        while(i1 < w1.length() || i2 < w2.length()) {

            if(i1 >= w1.length()) {
                return -1;
            }

            if(i2 >= w2.length()) {
                return 1;
            }

            int w1Code = (i1 + 1 < w1.length()) && map.containsKey(w1.charAt(i1) * 100 + w1.charAt(i1 + 1)) ? w1.charAt(i1++) * 100 + w1.charAt(i1++) : w1.charAt(i1++);

            int w2Code = (i2 + 1 < w2.length()) && map.containsKey(w2.charAt(i2) * 100 + w2.charAt(i2 + 1)) ? w2.charAt(i2++) * 100 + w2.charAt(i2++) : w2.charAt(i2++);

            if(!map.get(w1Code).equals(map.get(w2Code))){
                return map.get(w1Code) - map.get(w2Code);
            }
        }


        return 0;
    }

    private static void populateCharSet() {
        if(map != null) {
            return;
        }

        map = new HashMap<>();

        //a b c ch d dd e f ff g ng h i j l ll m n o p ph r rh s t th u w y
        map.put((int) 'a', 1);
        map.put((int) 'b', 2);
        map.put((int) 'c', 3);
        map.put('c'*100 + 'h', 4);
        map.put((int) 'd', 5);
        map.put('d'*100 + 'd', 6);
        map.put((int) 'e', 7);
        map.put((int) 'f', 8);
        map.put('f'*100 + 'f', 9);
        map.put((int) 'g', 10);
        map.put('n'*100 + 'g', 11);
        map.put((int) 'h', 12);
        map.put((int) 'i', 13);
        map.put((int) 'j', 14);
        map.put((int) 'l', 15);
        map.put('l'*100 + 'l', 16);
        map.put((int) 'm', 17);
        map.put((int) 'n', 18);
        map.put((int) 'o', 19);
        map.put((int) 'p', 20);
        map.put('p'*100 + 'h', 21);
        map.put((int) 'r', 22);
        map.put('r'*100 + 'h', 23);
        map.put((int) 's', 24);
        map.put((int) 't', 25);
        map.put('t'*100 + 'h', 26);
        map.put((int) 'u', 27);
        map.put((int) 'w', 28);
        map.put((int) 'y', 29);
    }
}
