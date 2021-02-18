package 数组;

import java.util.Arrays;

public class _283_移动零 {
    public void moveZeroes(int[] nums) {
        int n = nums.length, left = 0, right = 0;
        while (right < n) {
            if (nums[right] != 0) {
                swap(nums, left, right);
                left++;
            }
            right++;
        }
    }

    public void swap(int[] nums, int left, int right) {
        int temp = nums[left];
        nums[left] = nums[right];
        nums[right] = temp;
    }

    public static void main(String[] args) {
        _283_移动零 a = new _283_移动零();
        int[] data = {1, 0};
        a.moveZeroes(data);
        System.out.println(Arrays.toString(data));
    }
}
