package leetcode.easy;

/**
 * Created by cenumah on 2019-12-17
 */
public class Q125 {

    public static void main(String[] args) {
//        System.out.println(new Q125().isPalindrome("A man, a plan, a canal: Panama"));
//        System.out.println(new Q125().isPalindrome(""));
        System.out.println(new Q125().isPalindrome("race a car"));
        System.out.println(new Q125().isPalindrome(".,"));
        System.out.println(new Q125().isPalindrome("0P"));

    }

    public boolean isPalindrome(String s) {

        if(s == null) return false;
        if(s.length() < 2) return true;

        s = s.toLowerCase();
        int i = 0;
        int j = s.length() -1;

        while(i < j) {

            char c1 = s.charAt(i);
            while(!isValid(c1) && i<j){
                i+= 1;
                c1 = s.charAt(i);
            }

            char c2 = s.charAt(j);
            while(!isValid(c2) && j>i){
                j-= 1;
                c2 = s.charAt(j);
            }

            if(c1 != c2 && isValid(c1) &&isValid(c2)) {
                return false;
            }

            i++;
            j--;
        }

        return true;
    }

    private boolean isValid(char c) {
        return (c>='a' && c<='z') || (c>='0' && c<='9');
    }
}
