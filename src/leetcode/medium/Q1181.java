package leetcode.medium;

import com.sun.istack.internal.NotNull;

import java.util.*;

/**
 * Created by cenumah on 2020-01-20
 */
public class Q1181 {

    public static void main(String[] args) {

        String[] arr = new String[]{"a", "b", "a"};
        //System.out.println(new Q1181().beforeAndAfterPuzzles(arr));

        arr = new String[]{"mission statement",
                "a quick bite to eat",
                "a chip off the old block",
                "chocolate bar",
                "mission impossible",
                "a man on a mission",
                "block party",
                "eat my words",
                "bar of soap"};
       // System.out.println(new Q1181().beforeAndAfterPuzzles(arr));

        arr = new String[]{"nrop xshcva twecfm twecfm twecfm xshcva twecfm",
                "ggwznmv twecfm nrop nrop nrop xshcva ggwznmv ggwznmv p twecfm nrop xshcva p p",
                "p p nrop ggwznmv twecfm nrop p p",
                "xshcva twecfm ggwznmv twecfm nrop p ggwznmv p twecfm",
                "xshcva"};
        System.out.println(new Q1181().beforeAndAfterPuzzles(arr));


    }

    public List<String> beforeAndAfterPuzzles(String[] phrases) {

        if(phrases == null || phrases.length == 0) {
            return new ArrayList<>();
        }

        Map<String, List<Node>> last = new HashMap<>();
        Map<String, List<Node>> first = new HashMap<>();

        for(int i=0; i<phrases.length; i++) {
            String s = phrases[i];
            if(!s.contains(" ")) {
                last.putIfAbsent(s, new ArrayList<>());
                last.get(s).add(new Node("", i));
                first.putIfAbsent(s, new ArrayList<>());
                first.get(s).add(new Node("", i));
                continue;
            }

            int spaceIdx = s.indexOf(" ");
            String key = s.substring(0, spaceIdx);
            first.putIfAbsent(key, new ArrayList<>());
            first.get(key).add(new Node(s.substring(spaceIdx), i));

            spaceIdx = s.lastIndexOf(" ");
            key = s.substring(spaceIdx+1);
            last.putIfAbsent(key, new ArrayList<>());
            last.get(key).add(new Node(s.substring(0, spaceIdx+1), i));
        }

        Set<String> res = new HashSet<>();
        for(String key : last.keySet()) {
            if(first.containsKey(key)) {
                for(Node n1 : last.get(key)) {
                    for(Node n2 : first.get(key)) {
                        if(n1.idx != n2.idx) {
                            res.add(n1.val + key + n2.val);
                        }
                    }
                }
            }
        }

        List<String> result = new ArrayList<>(res);
        Collections.sort(result);
        return result;
    }

    class Node {
        String val;
        int idx;

        Node(String s, int i){
            val = s;
            idx = i;
        }
    }
}
