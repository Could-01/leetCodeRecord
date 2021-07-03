package 贪心;

import java.util.Arrays;

public class _1749_任意子数组和的绝对值的最大值 {
    public int maxAbsoluteSum(int[] nums) {
        int length = nums.length;
        int res = 0;
        int[] mindp = new int[length];
        int[] maxdp = new int[length];
        maxdp[0] = mindp[0] = nums[0];
        for (int i = 1; i < length; i++) {
            maxdp[i] = Math.max(nums[i] + maxdp[i - 1], nums[i]);
            mindp[i] = Math.min(nums[i] + mindp[i - 1], nums[i]);
        }
        for (int max : maxdp) {
            int tmp = Math.abs(max);
            res = Math.max(tmp, res);
        }

        for (int min : mindp) {
            int tmp = Math.abs(min);
            res = Math.max(tmp, res);
        }
        return res;
    }

    public int maxAbsoluteSum1(int[] nums) {
        int right = 0;
        int len = nums.length;
        int sum = 0;
        int[] mm = new int[2];
        while (right < len) {
            sum += nums[right++];
            if (sum < 0) {
                sum = 0;
            } else {
                mm[0] = Math.max(mm[0], sum);
            }
        }
        right = 0;
        sum = 0;
        while (right < len) {
            sum += nums[right++];
            if (sum > 0) {
                sum = 0;
            } else {
                mm[1] = Math.min(mm[1], sum);
            }
        }
        return Math.max(mm[0], -mm[1]);
    }

    public static void main(String[] args) {
        _1749_任意子数组和的绝对值的最大值 a = new _1749_任意子数组和的绝对值的最大值();
        int[] data = {4};
        int[] data1 = {2, -5, 1, -4, 3, -2};
        System.out.println(a.maxAbsoluteSum(data));
    }
}
