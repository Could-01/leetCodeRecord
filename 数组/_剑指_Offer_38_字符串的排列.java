package 数组;

import java.util.*;

public class _剑指_Offer_38_字符串的排列 {
    public String[] permutation(String s) {
        Set<String> list = new HashSet<>();
        char[] arr = s.toCharArray();
        StringBuilder sb = new StringBuilder();
        boolean[] visited = new boolean[arr.length];
        dfs(arr, "", visited, list);
        return list.toArray(new String[0]);
    }

    public void dfs(char[] arr, String s, boolean[] visited, Set<String> list) {
        if (s.length() == arr.length) {
            list.add(s);
            return;
        }
        for (int i = 0; i < arr.length; i++) {
            if (visited[i]) continue;
            visited[i] = true;
            dfs(arr, s + arr[i], visited, list);
            visited[i] = false;
        }
    }

    public static void main(String[] args) {
        _剑指_Offer_38_字符串的排列 a = new _剑指_Offer_38_字符串的排列();
        System.out.println(Arrays.toString(a.permutation("abc")));
    }
}

class Test__剑指_Offer_38_字符串的排列 {
    public String[] permutation(String s) {
        ArrayList<String> ans = new ArrayList<>();
        permutationCore(s.toCharArray(), 0, ans);

        return ans.toArray(new String[0]);
    }

    private void permutationCore(char[] str, int i, ArrayList<String> ans) {
        if (i == str.length) {
            ans.add(String.valueOf(str));
        }

        boolean[] visited = new boolean[26];
        for (int j = i; j < str.length; j++) {
            if (!visited[str[j] - 'a']) {
                visited[str[j] - 'a'] = true;
                swap(str, i, j);
                permutationCore(str, i + 1, ans);
                swap(str, i, j);
            }
        }
    }

    private void swap(char[] str, int i, int j) {
        char tmp = str[i];
        str[i] = str[j];
        str[j] = tmp;
    }

}