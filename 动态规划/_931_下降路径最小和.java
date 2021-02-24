package 动态规划;

public class _931_下降路径最小和 {
    public int minFallingPathSum(int[][] matrix) {
        int m = matrix.length, n = matrix[0].length;
        int[][] dp = new int[m][n];
        int res = Integer.MAX_VALUE;
        for (int i = 0; i < n; i++) {
            dp[0][i] = matrix[0][i];
        }
        for (int i = 1; i < m; i++) {
            for (int j = 0; j < n; j++) {
                // 最左列, 寻找正上方和右上方的最小值
                if (j == 0) {
                    // 如果只有一列，直接和正上方的相加即可
                    if (n == 1) {
                        dp[i][j] = dp[i - 1][j] + matrix[i][j];
                        break;
                    }
                    dp[i][j] = Math.min(dp[i - 1][j], dp[i - 1][j + 1]) + matrix[i][j];
                    continue;
                }
                // 最右列，寻找正上方和左上方的最小值
                if (j == n - 1) {
                    dp[i][j] = Math.min(dp[i - 1][j], dp[i - 1][j - 1]) + matrix[i][j];
                    continue;
                }
                // 在正上方，左上和右上方找出最小值
                dp[i][j] = Math.min(dp[i - 1][j], Math.min(dp[i - 1][j - 1], dp[i - 1][j + 1])) + matrix[i][j];
            }
        }
        for (int i = 0; i < n; i++) {
            res = Math.min(res, dp[m - 1][i]);
        }

        return res;
    }


    public static void main(String[] args) {
        _931_下降路径最小和 a = new _931_下降路径最小和();
        int[][] data = {{2}, {6}, {7}};
//        int[][] data = {{-48}};
        System.out.println(a.minFallingPathSum(data));
    }
}
