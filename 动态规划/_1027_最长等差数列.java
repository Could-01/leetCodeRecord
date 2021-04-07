package 动态规划;

public class _1027_最长等差数列 {
    public int longestArithSeqLength(int[] A) {
        int m = A.length;
        //dp[i][j] 表示到第i个数 且公差为j的最长值
        int[][] dp = new int[m][20002];
        int res = Integer.MIN_VALUE;
        for (int i = 0; i < m; i++) {
            for (int j = i - 1; j >= 0; j--) {
                int a = A[i] - A[j];
                if (a < 0) {
                    dp[i][1000 + a * -1] = Math.max(dp[j][1000 + a * -1] + 1, dp[i][1000 + a * -1]);
                    res = Math.max(res, dp[i][1000 + a * -1]);
                } else {
                    dp[i][a] = Math.max(dp[j][a] + 1, dp[i][a]);
                    res = Math.max(dp[i][a], res);
                }
            }
        }
        return res + 1;
    }

    public static void main(String[] args) {
        _1027_最长等差数列 a = new _1027_最长等差数列();
        int[] data = {9, 4, 7, 2, 10};
        System.out.println(a.longestArithSeqLength(data));
    }
}
