package leetcode.medium;

import java.util.*;

/**
 * Created by cenumah on 2019-12-23
 */
public class Q22 {

    public static void main(String[] args) {
        System.out.println(new Q22().generateParenthesis(1));
        System.out.println(new Q22().generateParenthesis(2));
        System.out.println(new Q22().generateParenthesis(3));
        System.out.println(new Q22().generateParenthesis(4));
    }

    public List<String> generateParenthesis(int n) {
        if(n <= 0)
            return new ArrayList<>();

        List<String> res = new ArrayList<>();
        addCombinations(n, n, new StringBuilder(), res);
        return res;
    }

    private void addCombinations(int left, int right, StringBuilder prefix, List<String> res) {
        if(left == 0 && right == 0) {
            res.add(prefix.toString());
        }

        int len = prefix.length();
        if(left > 0){
            addCombinations(left-1, right, prefix.append('('), res);
        }

        prefix.setLength(len);
        if(right > left) {
            addCombinations(left, right-1, prefix.append(')'), res);
        }
    }


    private Set<String> addCombinations1 (Set<String> prev, int itr) {
        if(itr == 1) {
            return new HashSet<>(Collections.singletonList("()"));
        }

        Set<String> res = new HashSet<>();
        for(String s : prev) {
            res.add(s + "()");
            res.add("("+ s +")");
            res.add("()"+ s);
        }

        return res;
    }
}
