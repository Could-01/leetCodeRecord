package 动态规划;

import java.util.Arrays;

public class _53_最大子序和 {
    public int maxSubArray(int[] nums) {
        int[] dp = new int[nums.length];
        dp[0] = nums[0];
        int res = dp[0];
        for (int i = 1; i < nums.length; i++) {
            dp[i] = Math.max(nums[i], dp[i - 1] + nums[i]);
            res = Math.max(dp[i], res);
        }
        return res;
    }

    public static void main(String[] args) {
        _53_最大子序和 a = new _53_最大子序和();
        int[] data = {-1};
        System.out.println(a.maxSubArray(data));
    }
}
