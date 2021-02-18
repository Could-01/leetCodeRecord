package 动态规划;

import java.util.Arrays;

public class _152_乘积最大子数组 {
    public int maxProduct(int[] nums) {
        if (nums == null || nums.length == 0) return 0;
        int res = nums[0];
        int pre_max = nums[0];
        int pre_min = nums[0];
        for (int i = 1; i < nums.length; i++) {
            int cur_max = Math.max(Math.max(pre_max * nums[i], pre_min * nums[i]), nums[i]);
            int cur_min = Math.min(Math.min(pre_max * nums[i], pre_min * nums[i]), nums[i]);
            res = Math.max(res, cur_max);
            pre_max = cur_max;
            pre_min = cur_min;
        }
        return res;
    }

    public static void main(String[] args) {
        _152_乘积最大子数组 a = new _152_乘积最大子数组();
        int[] data = {3, -1, 4}; // 4
        int[] data1 = {-2, 3, -4}; // 24
        System.out.println(a.maxProduct(data));
        System.out.println(a.maxProduct(data1));
    }
}

class Test_152 {
    public int maxProduct(int[] nums) {
        int len = nums.length;
        if (len == 0) {
            return 0;
        }

        // dp[i][0]：以 nums[i] 结尾的连续子数组的最小值
        // dp[i][1]：以 nums[i] 结尾的连续子数组的最大值
        int[][] dp = new int[len][2];
        dp[0][0] = nums[0];
        dp[0][1] = nums[0];
        for (int i = 1; i < len; i++) {
            if (nums[i] >= 0) {
                dp[i][0] = Math.min(nums[i], nums[i] * dp[i - 1][0]);
                dp[i][1] = Math.max(nums[i], nums[i] * dp[i - 1][1]);
            } else {
                dp[i][0] = Math.min(nums[i], nums[i] * dp[i - 1][1]);
                dp[i][1] = Math.max(nums[i], nums[i] * dp[i - 1][0]);
            }
            for (int[] arr : dp) {
                System.out.println(Arrays.toString(arr));
            }
        }

        // 只关心最大值，需要遍历
        int res = dp[0][1];
        for (int i = 1; i < len; i++) {
            res = Math.max(res, dp[i][1]);
        }
        return res;
    }

    public static void main(String[] args) {
        Test_152 a = new Test_152();
        int[] data = {2, 3, -2, 4};
        int[] data1 = {3, -1, 4}; // 4
        int[] data2 = {-2, 3, -4}; // 24
        System.out.println(a.maxProduct(data));
//        System.out.println(a.maxProduct(data1));
    }

}

class Test_152_1 {
    public int maxProduct(int[] nums) {
        int len = nums.length;
        if (len == 0) {
            return 0;
        }

        int preMax = nums[0];
        int preMin = nums[0];

        // 滚动变量
        int curMax;
        int curMin;

        int res = nums[0];
        for (int i = 1; i < len; i++) {
            if (nums[i] >= 0) {
                curMax = Math.max(preMax * nums[i], nums[i]);
                curMin = Math.min(preMin * nums[i], nums[i]);
            } else {
                curMax = Math.max(preMin * nums[i], nums[i]);
                curMin = Math.min(preMax * nums[i], nums[i]);
            }
            res = Math.max(res, curMax);

            // 赋值滚动变量
            preMax = curMax;
            preMin = curMin;
        }
        return res;
    }
}