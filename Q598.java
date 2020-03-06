package leetcode.easy;

/**
 * Created by cenumah on 2020-02-23
 */
public class Q598 {

    public static void main(String[] args) {

        System.out.println(new Q598().compress("aabbccc".toCharArray()));
        System.out.println(new Q598().compress("a".toCharArray()));
    }

    public int compress(char[] chars) {

        char curr = chars[0];
        int count = 0;
        int idx = 0;
        for(char c : chars) {
            if(c == curr) {
                count++;
            } else {
                chars[idx++] = curr;
                String countStr = Integer.toString(count);
                for(int i=0; i<countStr.length(); i++) {
                    if(idx < chars.length)
                        chars[idx++] = countStr.charAt(i);
                }
                curr = c;
                count = 1;
            }
        }

        chars[idx++] = curr;
        String countStr = Integer.toString(count);
        for(int i=0; i<countStr.length(); i++) {
            chars[idx++] = countStr.charAt(i);
        }

        return idx;
    }
}
