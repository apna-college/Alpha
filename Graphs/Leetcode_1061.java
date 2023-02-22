package Graphs;

import java.util.*;

// Lexicographically  smallest equivalent string - 1061 leetcode
public class Leetcode_1061 {
    public static void main(String[] args) {
        System.out.println(smallestEquivalentString("parker","morris","parser"));
    }

    static int minchar;

    public static String smallestEquivalentString(String s1, String s2, String baseStr) {
        Integer adj[][] = new Integer[26][26];
        for (int i = 0; i < s1.length(); i++) {
            adj[s1.charAt(i) - 'a'][s2.charAt(i) - 'a'] = 1;
            adj[s2.charAt(i) - 'a'][s1.charAt(i) - 'a'] = 1;
        }

        int mappingChar[] = new int[26];
        for (int i = 0; i < 26; i++)
            mappingChar[i] = i;

        boolean vis[] = new boolean[26];
        for (int c = 0; c < 26; c++) {
            if (!vis[c]) {
                List<Integer> component = new ArrayList<>();
                minchar = 27;

                dfs(c, adj, vis, component);

                for (int vertex : component) {
                    mappingChar[vertex] = minchar;
                }
            }
        }

        String ans = "";
        for (char c : baseStr.toCharArray()) {
            ans += (char) (mappingChar[c - 'a'] + 'a');
        }

        return ans;
    }

    public static void dfs(int source, Integer adj[][], boolean vis[], List<Integer> component) {
        vis[source] = true;

        component.add(source);

        minchar = Math.min(minchar, source);

        for (int i = 0; i < 26; i++) {
            if (adj[source][i] != null && !vis[i]) {
                dfs(i, adj, vis, component);
            }
        }
    }
}
