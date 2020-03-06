package leetcode.medium;

import java.util.Stack;

/**
 * Created by cenumah on 2020-01-14
 */
public class Q394 {

    public static void main(String[] args) {
        //s = "3[a]2[bc]", return "aaabcbc".
        //s = "3[a2[c]]", return "accaccacc".
        //s = "2[abc]3[cd]ef", return "abcabccdcdcdef".
        System.out.println(decodeString("3[a]2[bc]"));
        System.out.println(decodeString("3[a2[c]]"));
        System.out.println(decodeString("4[x3[a2[c]]]"));
        System.out.println(decodeString("2[abc]3[cd]ef"));
        System.out.println(decodeString("sd2[f2[e]g]i"));
    }

    public static String decodeString(String s) {
        if(s == null || s.isEmpty()) {
            return s;
        }

        int idx = 0;
        Stack<Integer> stack = new Stack<>();
        StringBuilder res = new StringBuilder();
        StringBuilder temp = new StringBuilder();
        int lastDigit = 0;

        while(idx < s.length()) {
            char c = s.charAt(idx);
            if(Character.isDigit(c)) {
                if(temp.length() > 0 && stack.isEmpty()) {
                    res.append(temp);
                    temp.setLength(0);
                }
                lastDigit = Character.getNumericValue(c);
            }
            else if(c == '[') {
                if(!stack.isEmpty()) {
                    temp.append("[");
                }
                stack.add(lastDigit);
            }
            else if(c == ']') {
                int count = stack.pop();
                if(stack.isEmpty()) {
                    while(count-- > 0) {
                        res.append(temp);
                    }
                    temp.setLength(0);
                } else {
                    int startIdx = temp.lastIndexOf("[") + 1;
                    String substring = temp.substring(startIdx);
                    temp.setLength(startIdx-1);
                    while (count-- > 0) {
                        temp.append(substring);
                    }
                }
            } else {
                temp.append(c);
            }

            idx++;
        }

        int count = stack.isEmpty() ? 1 : stack.pop();
        while(count-- > 0) {
            res.append(temp);
        }

        return res.toString();
    }
}
