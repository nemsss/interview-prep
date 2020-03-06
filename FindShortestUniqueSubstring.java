package others;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by cenumah on 2020-02-25
 */
public class FindShortestUniqueSubstring {

    public static void main(String[] args) {
        FindShortestUniqueSubstring obj = new FindShortestUniqueSubstring();
        String[] input = {"palantir", "pelantors","cheapair", "cheapoair"};
        System.out.print(Arrays.toString(obj.findUniqueShortestSubstring(input)));

        /*
            output:{
                "palantir": "ti", # ti only appears in "palantir"
                "pelantors": "s", # s only appears in "pelantors"
                "cheapair": "pai" or "apa", # either substring only appears in "cheapair"
                "cheapoair": "po" or "oa" # either substring only appears in cheapoair
            }
         */
    }

    private Trie root;

    private String[] findUniqueShortestSubstring(String[] strs) {
        root = new Trie();
        String[] result = new String[strs.length];
        for(int i=0; i<strs.length; i++) {
            for(int j=0;j<strs[i].length();j++) {
                String temp = strs[i].substring(j);
                for(int k=1; k<=temp.length(); k++) {
                    addToTrie(temp.substring(0, k), i, j, j+k);
                }
            }
        }

        findShortString(root, result, strs);
        return result;
    }

    private void findShortString(Trie root, String[] result, String[] strs) {
        if(root.children == null) return;
        for(Trie child : root.children) {
            if(child != null) {
                if(child.occurences.size() == 1) {
                    int index = child.occurences.iterator().next();
                    String temp = strs[index].
                            substring(child.position[0], child.position[1]);
                    if(result[index] == null
                            || result[index].length() > temp.length()) {
                        result[index] = temp;
                    }
                }
                findShortString(child, result, strs);
            }
        }
    }

    private void addToTrie(String str, int wordId, int start, int end) {
        Trie ptr = root;
        for(char ch : str.toCharArray()) {
            if(ptr.children == null) {
                ptr.children = new Trie[26];
            }
            if(ptr.children[ch-'a'] == null) {
                ptr.children[ch-'a'] = new Trie();
            }
            ptr = ptr.children[ch-'a'];
        }
        ptr.position = new int[] {start, end};
        if(ptr.occurences == null) ptr.occurences = new HashSet<>();
        ptr.occurences.add(wordId);
    }

    class Trie {
        Trie[] children;
        int[] position;
        Set<Integer> occurences;
    }
}
