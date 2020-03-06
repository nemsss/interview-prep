package leetcode.hard;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by cenumah on 2019-11-30
 */
public class Q1192 {

    public static void main(String[] args) {

    }

    public List<List<Integer>> criticalConnections(int n, List<List<Integer>> conns) {

        List<Integer>[] graph = new ArrayList[n];
        for(int i=0; i<graph.length; i++) graph[i] = new ArrayList<>();

        for(List<Integer> conn : conns) {
            graph[conn.get(0)].add(conn.get(1));
            graph[conn.get(1)].add(conn.get(0));
        }

        boolean[] visited = new boolean[n];
        int[] timestampAt = new int[n];
        int[] time = new int[1];
        List<List<Integer>> result = new ArrayList<>();

        criticalConnsUtil(graph, -1, 0, visited, timestampAt, time, result);

        return result;
    }

    private void criticalConnsUtil(List<Integer>[] graph, int parent, int node, boolean[] visited, int[] timestampAt, int[] time, List<List<Integer>> result) {

        visited[node] = true;
        timestampAt[node] = time[0]++;
        int currTimestamp = timestampAt[node];

        for(int adj : graph[node]) {
            if(adj == parent) {
                continue;
            }
            if(!visited[adj]) {
                criticalConnsUtil(graph, node, adj, visited, timestampAt, time, result);
            }

            timestampAt[node] = Math.min(timestampAt[node], timestampAt[adj]);
            if(currTimestamp < timestampAt[adj]){
                result.add(new ArrayList<>(Arrays.asList(node, adj)));
            }
        }
    }
}
