package 动态规划;

public class _343_整数拆分 {
    /**
     * 令dp[i]表示整数i对应的最大乘积
     * 那么dp[i]的值应是dp[j]*(i-j),j属于[1,i-1]的最大值
     * 同时注意dp[i]对应的值是经过拆分了的，
     * 所以还应判断两个数拆分的情况，即j*(i-j)的值，取最大即可。
     * */
    public int integerBreak(int n) {
        int[] dp = new int[n + 1];
        dp[1] = 1;
        for (int i = 2; i < n + 1; i++) {
            for (int j = i - 1; j >= 1; j--) {
                dp[i] = Math.max(dp[i], dp[j] * (i - j));
                dp[i] = Math.max(dp[i], j * (i - j));
            }
        }
        return dp[n];
    }

    public static void main(String[] args) {
        _343_整数拆分 a = new _343_整数拆分();
        System.out.println(a.integerBreak(10));
    }
}
