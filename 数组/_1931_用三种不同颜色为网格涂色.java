package 数组;

import java.util.ArrayList;
import java.util.List;

public class _1931_用三种不同颜色为网格涂色 {
    int res = 0;
    int r = 0, c = 0;
    int mod = 1000000007;

    public int colorTheGrid(int m, int n) {
        // 0->红 1->绿 2->蓝
        r = m;
        c = n;
        int[][] arrs = new int[m][n];
        helper(0, 0, arrs);
        return res % mod;
    }

    void helper(int m, int n, int[][] arrs) {
        if (m == r - 1 && n == c) { // 走完了
            res++;
            return;
        }
        if (n == c) { // 到最右一列
            helper(m + 1, 0, arrs);
        } else {
            int top = m == 0 ? 3 : arrs[m - 1][n]; // 3、4 表示不存在的格子颜色
            int left = n == 0 ? 4 : arrs[m][n - 1];
            boolean[] rec = new boolean[5];
            rec[top] = true;
            rec[left] = true;
            for (int i = 0; i < 3; i++) {
                if (!rec[i]) {
                    arrs[m][n] = i;
                    helper(m, n + 1, arrs);
                }
            }
        }
    }

    public static void main(String[] args) {
        _1931_用三种不同颜色为网格涂色 a = new _1931_用三种不同颜色为网格涂色();
        Solution_1931 s = new Solution_1931();
        System.out.println(s.colorTheGrid(2, 37));
//        System.out.println(a.colorTheGrid(2, 37));
    }
}


class Solution_1931 {

    private static final int MOD = (int) 1e9 + 7;
    private ArrayList<ArrayList<Integer>> types = new ArrayList<>();

    private void genValid(int m, ArrayList<Integer> path) {
        if (path.size() == m) {
            types.add(new ArrayList<>(path));
            return;
        }
        for (int j = 0; j < 3; j++) {
            if (path.isEmpty() || path.get(path.size() - 1) != j) {
                path.add(j);
                genValid(m, path);
                path.remove(path.size() - 1);
            }
        }
    }

    private boolean isValid(int i, int j, int m) {
        for (int k = 0; k < m; k++) {
            if (types.get(i).get(k).equals(types.get(j).get(k))) {
                return false;
            }
        }
        return true;
    }

    public int colorTheGrid(int m, int n) {
        genValid(m, new ArrayList<>());
        int[][] dp = new int[n + 1][types.size()];
        for (int i = 0; i < types.size(); i++) {
            dp[1][i] = 1;
        }
        for (int i = 2; i <= n; i++) {
            for (int j = 0; j < types.size(); j++) {
                for (int k = 0; k < types.size(); k++) {
                    if (isValid(j, k, m)) {
                        dp[i][j] += dp[i - 1][k];
                        dp[i][j] %= MOD;
                    }
                }
            }
        }
        int ans = 0;
        for (int i = 0; i < types.size(); i++) {
            ans += dp[n][i];
            ans %= MOD;
        }
        return ans;
    }
}