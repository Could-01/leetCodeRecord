package 动态规划;

import java.util.Arrays;

public class _62_不同路径 {
    public int uniquePaths(int m, int n) {
        if (m < 2 || n < 2) return Math.min(m, n);
        int[][] paths = new int[m][n];
        Arrays.fill(paths[0], 1);
        for (int i = 1; i < m; i++) {
            paths[i][0] = 1;
            for (int j = 1; j < n; ++j) {
                paths[i][j] = paths[i - 1][j] + paths[i][j - 1];
            }
        }
        return paths[m - 1][n - 1];
    }


    public static void main(String[] args) {
        _62_不同路径 a = new _62_不同路径();
        System.out.println(a.uniquePaths(3, 3));
    }
}

class Test_62 {
    //理论可以存在一维数组
    public int uniquePaths(int m, int n) {
        if (m < 2 || n < 2) return Math.min(m, n);
        int[] dp = new int[n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                int dp0 = dp[j];
                if (j == 0) {
                    dp[j] = 1;
                } else {
                    dp[j] = dp[j - 1] + dp0;
                }
            }
        }
        return dp[n - 1];
    }

    public static void main(String[] args) {
        Test_62 a = new Test_62();
        System.out.println(a.uniquePaths(1, 1));
    }
}