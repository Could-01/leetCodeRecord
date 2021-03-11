package 贪心;

import java.util.Arrays;

public class _45_跳跃游戏II {
    public int jump(int[] nums) {
        int len = nums.length;
        if (len == 1) return 0;
        int[] dp = new int[len];
        Arrays.fill(dp, 1000000);
        dp[0] = 0;
        for (int i = 1; i < len; i++) {
            for (int j = 0; j < i; j++) {
                if (nums[j] + j >= i) dp[i] = Math.min(dp[i], dp[j] + 1);
            }
        }
        return dp[len - 1];
    }

    public static void main(String[] args) {
        _45_跳跃游戏II a = new _45_跳跃游戏II();
        int[] data = {2, 3, 1, 1, 4};
        System.out.println(a.jump(data));
    }
}
