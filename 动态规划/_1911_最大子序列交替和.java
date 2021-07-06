package 动态规划;

import java.util.Arrays;

public class _1911_最大子序列交替和 {
    public long maxAlternatingSum(int[] nums) {
        long odd = 0, even = 0;
        for (int v : nums) {
            long tmpOdd = odd;
            odd = Math.max(odd, even + v);
            even = Math.max(even, tmpOdd - v);
        }
        return odd;
    }

    //状态机DP
    public long maxAlternatingSum1(int[] nums) {
        // f[i][0] 表示[]0...i-1]个数中选偶数个数的最大交替和
        //f[i][1]  表示[]0...i-1]个数中选奇数个数的最大交替和
        int n = nums.length;
        long[][] f = new long[n + 1][2];
        for (int i = 0; i <= n; i++) Arrays.fill(f[i], Integer.MIN_VALUE >> 1);//防止溢出
        f[0][0] = 0;
        for (int i = 1; i <= n; i++) {
            f[i][0] = Math.max(f[i - 1][0], f[i - 1][1] - nums[i - 1]);
            f[i][1] = Math.max(f[i - 1][1], f[i - 1][0] + nums[i - 1]);
        }
        return Math.max(f[n][0], f[n][1]);
    }

    public static void main(String[] args) {
        _1911_最大子序列交替和 a = new _1911_最大子序列交替和();
        int[] data = {};
        System.out.println(a.maxAlternatingSum(data));
    }
}
