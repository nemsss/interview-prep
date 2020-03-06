package others;

import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.Set;

/**
 * Created by cenumah on 2020-01-10
 */
public class BalanceParenthesis {

    public static void main(String[] args) {

        System.out.println(solve("ab(a(c)fg)9)"));
        System.out.println(solve(")a(b)c()("));
        System.out.println(solve(")("));
        System.out.println(solve("a(b))"));
        System.out.println(solve("(a(c()b)"));
        System.out.println(solve("(a)b(c)d(e)f)(g)"));
    }

    /*
        Example 1:
        Input: "ab(a(c)fg)9)"
        Output: "ab(a(c)fg)9" or "ab(a(c)fg9)" or "ab(a(cfg)9)"

        Example 2:
        Input: ")a(b)c()("
        Output: "a(b)c()"

        Example 3:
        Input: ")("
        Output: ""

        Example 4:
        Input: "a(b))"
        Output: "a(b)"

        Example 5:
        Input: "(a(c()b)"
        Output: "a(c()b)" or "(ac()b)" or "(a(c)b)"

        Example 6:
        Input: "(a)b(c)d(e)f)(g)"
        Output: "(a)b(c)d(e)f(g)"
     */
    static String solve(String s) {
        if(s == null || s.isEmpty()) {
            return s;
        }

        Set<Integer> ignore = new HashSet<>();
        int open = 0;
        for(int i=0; i<s.length(); i++) {
            char c = s.charAt(i);
            if (c == '(') {
                open++;
            } else if(c == ')') {
                if(open > 0){
                    open--;
                } else {
                    ignore.add(i);
                }
            }
        }

        int closed = 0;
        for(int i=s.length()-1; i>=0; i--) {
            char c = s.charAt(i);
            if (c == ')') {
                closed++;
            } else if(c == '(') {
                if(closed > 0){
                    closed--;
                } else {
                    ignore.add(i);
                }
            }
        }

        StringBuilder sb = new StringBuilder();
        for(int i=0; i<s.length(); i++) {
            if(!ignore.contains(i)){
                sb.append(s.charAt(i));
            }
        }

        return sb.toString();
    }
}
