package 动态规划;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class _523_连续的子数组和 {
    public boolean checkSubarraySum(int[] nums, int k) {
        boolean res = false;
        int dp = nums[0];
        int max = dp;
        for (int i = 1; i < nums.length; i++) {
            if (dp <= 0) {
                dp = nums[i];
            } else {
                dp = dp + nums[i];
            }
            max = Math.max(dp, max);
        }
        System.out.println(dp);
        return res;
    }

    static int maxSubArray1(int[] nums, int k) {
        int[] dp = new int[nums.length];
        dp[0] = nums[0];
        int max = dp[0];
        for (int i = 1; i < dp.length; i++) {
            int prev = dp[i - 1];
            if (prev <= 0) {
                dp[i] = nums[i];
            } else {
                dp[i] = prev + nums[i];
            }
            max = Math.max(dp[i], max);
        }
        System.out.println(Arrays.toString(dp));
        return max;
    }

    public boolean checkSubarraySum1(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>(); //1
        int sum = 0; //2
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
            System.out.println(sum);
            int mod = k == 0 ? sum : sum % k; //3
            if (mod == 0 && i > 0) //4
                return true;
            if (map.containsKey(mod) && i - map.get(mod) > 1) //5
                return true;
            if (!map.containsKey(mod)) { //6
                map.put(mod, i);
                System.out.println(map);
            }
        }
        return false;
    }


    /*
     * 设位置 j < i :
     * 0 到 j 的前缀和 preSum1 = 某常数1 * k + 余数1
     * 0 到 i 的前缀和 preSum2 = 某常数2 * k + 余数2
     * 当找到 余数1 等于 余数2 时， 则 j + 1 到 i 的连续和 = preSum2 - preSum1 = (某常数2 - 某常数1) * k， 必为 k 的倍数， 返回true
     * */
    public boolean checkSubarraySum2(int[] nums, int k) {
        int sum = 0;
        HashMap<Integer, Integer> map = new HashMap<>();
        map.put(0, -1);
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
            if (k != 0)
                sum = sum % k;
            if (map.containsKey(sum)) {
                if (i - map.get(sum) > 1)
                    return true;
            } else
                map.put(sum, i);
        }
        return false;
    }

    public static void main(String[] args) {
        _523_连续的子数组和 a = new _523_连续的子数组和();
        int[] nums = {23, 2, 4, 6, 7};
        System.out.println(a.checkSubarraySum1(nums, 6));
    }
}
