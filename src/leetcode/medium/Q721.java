package leetcode.medium;

import com.sun.source.util.Trees;

import java.util.*;
/**
 * Created by cenumah on 2020-02-16
 */
public class Q721 {

    public static void main(String[] args) {

        List<List<String>> accounts = new ArrayList<>();
        accounts.add(Arrays.asList("John","joh1n@mail.com","joh2n@mail.com"));
        accounts.add(Arrays.asList("Mary","mary@mail.com"));
        accounts.add(Arrays.asList("John","joh1n@mail.com","joh3n@mail.com"));
        accounts.add(Arrays.asList("John","johnybravo@mail.com"));

        System.out.println(accountsMerge(accounts));
        System.out.println();

        accounts = new ArrayList<>();
        accounts.add(Arrays.asList("Gabe","Gabe0@m.co","Gabe3@m.co","Gabe1@m.co"));
        accounts.add(Arrays.asList("Kevin","Kevin3@m.co","Kevin5@m.co","Kevin0@m.co"));
        accounts.add(Arrays.asList("Ethan","Ethan5@m.co","Ethan4@m.co","Ethan0@m.co"));
        accounts.add(Arrays.asList("Hanzo","Hanzo3@m.co","Hanzo1@m.co","Hanzo0@m.co"));
        accounts.add(Arrays.asList("Fern","Fern5@m.co","Fern1@m.co","Fern0@m.co"));
        System.out.println(accountsMerge(accounts));
        System.out.println();

        //[["David","David0@m.co","David1@m.co"],
        // ["David","David3@m.co","David4@m.co"],
        // ["David","David4@m.co","David5@m.co"],
        // ["David","David2@m.co","David3@m.co"],
        // ["David","David1@m.co","David2@m.co"]]


        accounts = new ArrayList<>();
        accounts.add(Arrays.asList("David","David0@m.co","David1@m.co"));
        accounts.add(Arrays.asList("David","David3@m.co","David4@m.co"));
        accounts.add(Arrays.asList("David","David4@m.co","David5@m.co"));
        accounts.add(Arrays.asList("David","David2@m.co","David3@m.co"));
        accounts.add(Arrays.asList("David","David1@m.co","David2@m.co"));
        System.out.println(accountsMerge(accounts));
    }

    public static List<List<String>> accountsMerge(List<List<String>> accounts) {

        if(accounts == null || accounts.isEmpty()) {
            return accounts;
        }

        Map<String, Set<String>> graph = new HashMap<>();
        for(List<String> account : accounts) {
            String primaryEmail = account.get(1);
            for(int i=1; i<account.size(); i++) {
                String currentEmail = account.get(i);
                graph.putIfAbsent(currentEmail, new HashSet<>());
                graph.get(primaryEmail).add(currentEmail);
                graph.get(currentEmail).add(primaryEmail);
            }
        }

        List<List<String>> result = new ArrayList<>();
        Set<String> visited = new HashSet<>();
        for(List<String> account : accounts) {
            String primaryEmail = account.get(1);
            if(!visited.contains(primaryEmail)) {
                List<String> userDetails = new LinkedList<>();
                dfs(graph, primaryEmail, userDetails, visited);
                Collections.sort(userDetails);
                userDetails.add(0, account.get(0));
                result.add(userDetails);
            }
        }

        return result;
    }

    private static void dfs(Map<String, Set<String>> graph, String email, List<String> userDetails, Set<String> visited) {

        userDetails.add(email);
        visited.add(email);

        for(String otherEmail : graph.get(email)) {
            if(!visited.contains(otherEmail)) {
                dfs(graph, otherEmail, userDetails, visited);
            }
        }
    }


}
