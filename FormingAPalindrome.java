package friends;

import java.util.Arrays;

/**
 * Created by cenumah on 2019-12-23
 */
public class FormingAPalindrome {

    public static void main(String[] args) {

        System.out.println(canFormPalindromeAtSameCutPoint("VVYUIO", "RTKKVV"));
        System.out.println(canFormPalindromeAtSameCutPoint("VVYUIO", "RTKKVV"));
    }

    /*
        Given two strings, A and B, of equal length, find whether it is possible to cut both strings at a common point
        such that the first part of A and the second part of B form a palindrome.

        Extension1. How'd you change your solution if the strings could be cut at any point (not just a common point)?
        Extension2. Multiple cuts in the strings (substrings to form a palindrome)? Form a palindrome using a substring
        from both strings. What is its time complexity?
    */

    private static boolean canFormPalindromeAtAnyPoint(String s1, String s2) {

        if(s1 == null || s2 == null) {
            return false;
        }

        int left = 0;
        int right = s2.length()-1;

        return s1.charAt(left) == s2.charAt(right);
    }

    private static boolean canFormPalindromeAtSameCutPoint(String s1, String s2) {
        if(s1 == null || s2 == null) {
            return false;
        }

        //check if pointer is at beginning / end of strings

        int left = 0;
        int right = s2.length()-1;

        while(left < right) {
            if(s1.charAt(left) != s2.charAt(right)){
                break;
            }
            left++; right--;
        }

        if(left >= right) return true;


        //AATBYT i=2
        //TYUYAA j=3

        int i = left;
        int j = right;
        while(i < j) {
            if(s1.charAt(i) != s2.charAt(j)){
                break;
            }
            i++; j--;
        }

        if(i >= j) return true;


        i = left;
        j = right;
        while(i < j) {
            if(s2.charAt(i) != s2.charAt(j)) {
                break;
            }
            i++; j--;
        }

        return i >= j;
    }


}
