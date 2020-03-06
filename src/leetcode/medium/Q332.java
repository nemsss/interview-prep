package leetcode.medium;

import java.util.*;
import java.util.stream.Collectors;

/**
 * Created by cenumah on 2020-01-12
 */
public class Q332 {

    public static void main(String[] args) {

        //["JFK", "MUC"], ["SFO", "SJC"], ["LHR", "SFO"]]
        System.out.println(findItinerary(new ArrayList<>(Arrays.asList(
                new ArrayList<>(Arrays.asList("MUC", "LHR")),
                new ArrayList<>(Arrays.asList("JFK", "MUC")),
                new ArrayList<>(Arrays.asList("SFO", "SJC")),
                new ArrayList<>(Arrays.asList("LHR", "SFO"))
        ))));

        //[["JFK","SFO"],["JFK","ATL"],["SFO","ATL"],["ATL","JFK"],["ATL","SFO"]]
        System.out.println(findItinerary(new ArrayList<>(Arrays.asList(
                new ArrayList<>(Arrays.asList("JFK", "SFO")),
                new ArrayList<>(Arrays.asList("JFK", "ATL")),
                new ArrayList<>(Arrays.asList("SFO", "ATL")),
                new ArrayList<>(Arrays.asList("ATL", "JFK")),
                new ArrayList<>(Arrays.asList("ATL", "SFO"))
        ))));
    }

    public static List<String> findItinerary(List<List<String>> tickets) {

        if(tickets == null || tickets.isEmpty()) {
            return new ArrayList<>();
        }

        Map<String, PriorityQueue<String>> map = new HashMap<>();
        for(List<String> t : tickets) {
            map.putIfAbsent(t.get(0), new PriorityQueue<>());
            map.putIfAbsent(t.get(1), new PriorityQueue<>());
            map.get(t.get(0)).add(t.get(1));
        }

        LinkedList<String> res = new LinkedList<>();
        dfs("JFK", map, res);
        return res;
    }

    private static void dfs(String curr, Map<String, PriorityQueue<String>> map, LinkedList<String> res) {

        if(!map.containsKey(curr)) {
            return;
        }

        while(!map.get(curr).isEmpty()) {
            dfs(map.get(curr).poll(), map, res);
        }

        res.addFirst(curr);
    }
}
