package 数组;

import java.util.Arrays;

public class _136_只出现一次的数字 {
    public int singleNumber(int[] nums) {
        int ans = nums[0];
        if (nums.length > 1) {
            for (int i = 1; i < nums.length; i++) {
                ans = ans ^ nums[i];
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        System.out.println(5 << 2);
        System.out.println(5 >> 1);
        System.out.println(5 & 3);
        System.out.println(5 | 3);
    }
}
