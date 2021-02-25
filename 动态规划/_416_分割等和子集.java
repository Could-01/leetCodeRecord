package 动态规划;

import java.util.Arrays;

public class _416_分割等和子集 {
    public boolean canPartition(int[] nums) {
        int sum = Arrays.stream(nums).sum();
        if (sum % 2 == 1) return false;
        int num = sum / 2;
        int[] dp = new int[num + 1];

        // Take a chance
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == num) {
                return true;
            } else if (nums[i] > num) {
                return false;
            }
        }

        // 0~1背包问题
        dp[0] = 1;
        for (int n : nums) {
            for (int i = num; i >= n; i--) {
                dp[i] += dp[i - n];
            }
        }
        return dp[num] != 0;
    }

    public static void main(String[] args) {
        _416_分割等和子集 a = new _416_分割等和子集();
        int[] data = {1, 5, 11, 5};
        System.out.println(a.canPartition(data));
    }
}
