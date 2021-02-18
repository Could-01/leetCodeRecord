package 并查集;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class _990_等式方程的可满足性 {
    public boolean equationsPossible(String[] equations) {
        int[] parent = new int[26];
        int[] rank = new int[26];
        Arrays.fill(rank, 1);
        //初始化
        for (int i = 0; i < 26; i++) {
            parent[i] = i;
        }
        //合并
        for (String s : equations) {
            char x = s.charAt(0);
            char y = s.charAt(3);
            if (s.charAt(1) == '=') {
                union(rank, parent, x - 'a', y - 'a');
            }
        }

        for (String s : equations) {
            char x = s.charAt(0);
            char y = s.charAt(3);
            if (s.charAt(1) == '!') {
                if (find(parent, x - 'a') == find(parent, y - 'a')) {
                    return false;
                }
            }
        }
        return true;
    }

    public void union(int[] ranks, int[] parents, int v1, int v2) {
        int p1 = find(parents, v1);
        int p2 = find(parents, v2);
        if (p1 == p2) {
            return;
        }

        if (ranks[p1] < ranks[p2]) {
            parents[p1] = p2;
        } else if (ranks[p1] > ranks[p2]) {
            parents[p2] = p1;
        } else {
            parents[p1] = p2;
            ranks[p2] += 1;
        }
    }

    public int find(int[] parents, int v) {
        if (parents[v] != v) {
            parents[v] = find(parents, parents[v]);
        }
        return parents[v];
    }

    public static void main(String[] args) {
        _990_等式方程的可满足性 a = new _990_等式方程的可满足性();
        String[] data = {"a==b", "b!=a"};
        String[] data1 = {"b==a", "a==b"};
        System.out.println(a.equationsPossible(data1));
    }
}

