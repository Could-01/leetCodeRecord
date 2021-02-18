package 动态规划;

import java.util.Arrays;

public class _279_完全平方数 {
    public int numSquares(int n) {
        int[] dp = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            dp[i] = i;//初始化为i个1^2之和
            for (int j = 1; i - j * j >= 0; j++)
                dp[i] = Math.min(dp[i], dp[i - j * j] + 1);
        }
        System.out.println(Arrays.toString(dp));
        return dp[n];
    }

    public static void main(String[] args) {
        _279_完全平方数 a = new _279_完全平方数();
        System.out.println(a.numSquares(12));
    }
}

class Test_279 {
    int numSquares(int n) {
        int l = (int) Math.sqrt(n) + 1;
        int[] arr = new int[l];
        for (int i = 1; i <= l; i++) {
            arr[i - 1] = i * i;
        }
        int[] dp = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            int min = Integer.MAX_VALUE;
            for (int face : arr) {
                if (i < face) continue;
                int v = dp[i - face];
                if (v < 0 || v >= min) continue; // 选择一个最优的情况
                min = v;
            }
            if (min == Integer.MAX_VALUE) {
                dp[i] = -1;
            } else {
                dp[i] = min + 1;
            }
        }
        return dp[n];
    }


    public static void main(String[] args) {
        Test_279 a = new Test_279();
        System.out.println(a.numSquares(12));
    }
}