package 动态规划;

import java.util.Arrays;
import java.util.Map;

public class _1277_统计全为1的正方形子矩阵 {
    public int countSquares(int[][] matrix) {
        int m = matrix.length, n = matrix[0].length, res = 0;
        int[][] dp = new int[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (matrix[i][j] == 0) continue; // 如果是 0, 就跳过
                if (i == 0) {
                    dp[i][j] = 1;
                    res++;
                    continue;
                }
                if (j == 0) {
                    dp[i][j] = 1;
                    res++;
                    continue;
                }
                // 如果是 1, 就找根据它为右下角所形成的三角形
                dp[i][j] = Math.min(dp[i][j - 1], Math.min(dp[i - 1][j - 1], dp[i - 1][j])) + 1;
                res+=dp[i][j];
            }
        }
        return res;
    }

    public static void main(String[] args) {
        _1277_统计全为1的正方形子矩阵 a = new _1277_统计全为1的正方形子矩阵();
        int[][] data = {{0, 1, 1, 1}, {1, 1, 1, 1}, {0, 1, 1, 1}};
        System.out.println(a.countSquares(data));
    }
}
