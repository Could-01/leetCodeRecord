package 动态规划;

import java.util.Arrays;

public class _213_打家劫舍II {
    public int rob(int[] nums) {
        int length = nums.length;
        int[] leftarr = new int[length - 1], rightarr = new int[length - 1];
        if (length == 2) {
            return Math.max(nums[0], nums[1]);
        } else if (length == 1) {
            return nums[0];
        } else if (length == 0) {
            return 0;
        }
        for (int i = 0; i < length - 1; i++) {
            leftarr[i] = nums[i];
        }
        for (int i = 1; i < length; i++) {
            rightarr[i - 1] = nums[i];
        }
        return Math.max(getarray(leftarr, length - 1), getarray(rightarr, length - 1));
    }

    int getarray(int[] left, int len) {
        int[] memo = new int[len];
        memo[0] = left[0];
        memo[1] = Math.max(left[0], left[1]);
        for (int i = 2; i < len; i++) {
            memo[i] = Math.max(memo[i - 1], left[i] + memo[i - 2]);
            System.out.println(Arrays.toString(memo));
        }
        System.out.println("=====================");
        return memo[len - 1];
    }


    public static void main(String[] args) {
        _213_打家劫舍II a = new _213_打家劫舍II();
        int[] data = {1, 2, 3, 9, 5, 8};
        System.out.println(a.rob(data));
    }
}

class Test_213 {
    public int rob(int[] nums) {
        if (nums.length == 0) return 0;
        if (nums.length == 1) return nums[0];
        return Math.max(myRob(Arrays.copyOfRange(nums, 0, nums.length - 1)),
                myRob(Arrays.copyOfRange(nums, 1, nums.length)));
    }

    private int myRob(int[] nums) {
        int pre = 0, cur = 0, tmp;
        for (int num : nums) {
            tmp = cur;
            cur = Math.max(pre + num, cur);
            pre = tmp;
        }
        return cur;
    }

    public static void main(String[] args) {
        Test_213 a = new Test_213();
        int[] data = {1, 2, 3, 1};
        System.out.println(a.rob(data));
    }
}