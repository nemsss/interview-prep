package others;

import java.sql.Timestamp;
import java.time.Instant;
import java.util.*;

/**
 * Created by cenumah on 2020-01-11
 */
public class PredictProduct {

    public static void main(String[] args) {

        System.out.println(Instant.now());
        System.out.println(predict(5, Arrays.asList("mobile", "monitor", "mousepad", "mouse", "moneypot"), "mouse"));
        System.out.println(predict(6, Arrays.asList("mobile", "monitor", "mousepad", "mouse", "moneypot", "money"), "money"));
        System.out.println(Instant.now());

        System.out.println("-----------");
        System.out.println(Instant.now());
        System.out.println(predict2(5, Arrays.asList("mobile", "monitor", "mousepad", "mouse", "moneypot"), "mouse"));
        System.out.println(predict2(6, Arrays.asList("mobile", "monitor", "mousepad", "mouse", "moneypot", "money"), "money"));
        System.out.println(Instant.now());

    }

    private static List<List<String>> predict2(int numProducts, List<String> repository, String searchKey) {

        if(numProducts < 1 || repository == null || repository.isEmpty() || searchKey == null || searchKey.isEmpty()) {
            return new ArrayList<>();
        }

        Collections.sort(repository);
        List<List<String>> result = new ArrayList<>();
        int idx = 0;

        for(int prefixLen=2; prefixLen<=searchKey.length(); prefixLen++) {

            String prefix = searchKey.substring(0,prefixLen);
            List<String> list = new ArrayList<>();
            boolean marked = false;

            for(int i=idx; i<searchKey.length(); i++) {
                String product = repository.get(i);
                if(product.startsWith(prefix)){
                    if(!marked) {
                        idx = i;
                        marked = true;
                    }

                    if(list.size() < 3) {
                        list.add(product);
                    }
                }
            }

            result.add(list);
        }

        return result;
    }

    private static List<List<String>> predict(int numProducts, List<String> repository, String searchKey) {

        if(numProducts < 1 || repository == null || repository.isEmpty() || searchKey == null || searchKey.isEmpty()) {
            return new ArrayList<>();
        }

        Collections.sort(repository);

        Trie trie = new Trie();
        for(String product : repository) {
            trie.insertWord(product);
        }

        List<List<String>> result = new ArrayList<>();
        for(int i=2; i<=searchKey.length(); i++) {
            result.add(trie.search(searchKey.substring(0,i)));
        }

        return result;
    }

    static class Trie {

        TrieNode root;

        Trie() {
            this.root = new TrieNode();
        }

        void insertWord(String word) {
            if(word== null || word.length()==0) return;

            TrieNode node = root;
            for(int i=0; i<word.length(); i++){
                TrieNode child = node.getChild(word.charAt(i));
                if(child == null){
                    child = new TrieNode(word.charAt(i));
                    node.addChild(word.charAt(i), child);
                }
                node = child;
                node.addWord(word);
            }
        }


        private List<String> search(String word) {
            TrieNode node = this.root;
            for(int i=0; i<word.length(); i++) {
                char c = word.charAt(i);
                if(!node.children.containsKey(c)){
                    return new ArrayList<>();
                }
                node = node.getChild(c);
            }

            return node.words.subList(0, Math.min(3, node.words.size()));
        }
    }

    static class TrieNode {
        Character c;
        Map<Character, TrieNode> children = new HashMap<>();
        List<String> words = new ArrayList<>();

        TrieNode() {}
        TrieNode(char c){
            this.c = c;
        }

        TrieNode getChild(char c){
            return children.getOrDefault(c, null);
        }

        void addChild(char c, TrieNode node){
            children.put(c, node);
        }

        void addWord(String word) {
            words.add(word);
        }
    }
}
