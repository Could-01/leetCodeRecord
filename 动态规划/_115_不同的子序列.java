package 动态规划;

import java.util.Arrays;

public class _115_不同的子序列 {
    public int numDistinct(String s, String t) {
        int m = s.length(), n = t.length();
        int[][] dp = new int[m + 1][n + 1];
        for (int i = 0; i <= m; i++)
            dp[i][0] = 1;
        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                if (j > i)
                    break;
                if (s.charAt(i - 1) == t.charAt(j - 1)) {
                    dp[i][j] = dp[i - 1][j - 1] + dp[i - 1][j];
                } else {
                    dp[i][j] = dp[i - 1][j];
                }
            }
        }
        return dp[m][n];
    }

    public int numDistinct1(String s, String t) {
        int m = s.length();
        int n = t.length();
        char[] st = s.toCharArray();
        char[] tt = t.toCharArray();
        int[][] ss = new int[m + 1][n + 1];
        ss[0][0] = 1;
        for (int i = 1; i <= m; i++)
            ss[i][0] = 1;
        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                if (st[i - 1] == tt[j - 1]) {
                    ss[i][j] = ss[i - 1][j - 1] + ss[i - 1][j];
                } else {
                    ss[i][j] = ss[i - 1][j];
                }
            }
        }
        return ss[m][n];
    }

    public static void main(String[] args) {
        _115_不同的子序列 a = new _115_不同的子序列();
        System.out.println(a.numDistinct("rabbbit", "rabbit"));
    }
}
