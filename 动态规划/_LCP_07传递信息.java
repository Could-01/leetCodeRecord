package 动态规划;

public class _LCP_07传递信息 {
    public int numWays(int n, int[][] relation, int k) {
        int[][] dp = new int[k + 1][n];
        dp[0][0] = 1; // 表示第0轮传递到编号为0的小朋友的总方案数
        for (int i = 1; i <= k; i++) {
            for (int[] r : relation) {
                dp[i][r[1]] += dp[i - 1][r[0]];
            }
        }
        return dp[k][n - 1];
    }


    public static void main(String[] args) {
        _LCP_07传递信息 a = new _LCP_07传递信息();
        int[][] data = {{0, 2}, {2, 1}, {3, 4}, {2, 3}, {1, 4}, {2, 0}, {0, 4}};
        System.out.println(a.numWays(5, data, 3));
    }
}
