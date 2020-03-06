package leetcode.medium;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Created by cenumah on 2020-01-23
 */
public class Q797 {

    public static void main(String[] args) {

        int[][] g = new int[][] {{1,2}, {3}, {3}, {}};
        System.out.println(new Q797().allPathsSourceTarget(g));
    }

    public List<List<Integer>> allPathsSourceTarget(int[][] graph) {

        List<List<Integer>> res = new ArrayList<>();
        dfs(0, new ArrayList<>(), new HashSet<>(), graph, res);
        return res;
    }

    private void dfs(int curr, List<Integer> temp, Set<Integer> visiting, int[][] graph, List<List<Integer>> res) {

        if(visiting.contains(curr)) {
            return;
        }

        temp.add(curr);
        if(curr == graph.length-1) {
            res.add(temp);
            return;
        }

        visiting.add(curr);
        for(Integer i : graph[curr]) {
            dfs(i, new ArrayList<>(temp), visiting, graph, res);
        }

        visiting.remove(curr);
    }
}
