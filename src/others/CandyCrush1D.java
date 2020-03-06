package others;

import java.util.Deque;
import java.util.LinkedList;

/**
 * Created by cenumah on 2020-01-10
 */
public class CandyCrush1D {

    public static void main(String[] args) {

        System.out.println(crushLetters("aaabbcccbcd"));
        System.out.println(crushLetters("aaabbbacd"));
        System.out.println(crushLetters("aabbccddeeedcba"));
        System.out.println(crushLetters("bbb"));
    }

    private static String crushLetters(String s) {
        if(s == null || s.isEmpty() || s.length() < 3) {
            return s;
        }

        Deque<Pair<Character, Integer>> deque = new LinkedList<>();

        for(int i=0; i<s.length(); i++) {
            char c = s.charAt(i);
            if(!deque.isEmpty() && deque.peekLast().fst == c) {
                if(deque.peekLast().snd == 2) {
                    deque.removeLast();
                } else {
                    deque.peekLast().snd+= 1;
                }
            } else {
                deque.add(new Pair<>(c, 1));
            }
        }

        StringBuilder sb = new StringBuilder();
        for(Pair pair : deque) {
            Integer count = (Integer) pair.snd;
            while(count-- > 0) {
                sb.append(pair.fst);
            }
        }
        return sb.toString();
    }

    static class Pair<F,S> {
        F fst;
        S snd;
        Pair() {}
        Pair(F f, S s) {
            fst = f;
            snd = s;
        }
    }
}
