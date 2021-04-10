package 数组;

import java.util.Arrays;

public class _189_旋转数组 {
    public void rotate(int[] nums, int k) {
        int n = nums.length;
        k %= n;
        reverse(nums, 0, n - 1);
        reverse(nums, 0, k - 1);
        reverse(nums, k, n - 1);
    }

    private void reverse(int[] nums, int start, int end) {
        while (start < end) {
            int tmp = nums[start];
            nums[start++] = nums[end];
            nums[end--] = tmp;
        }
    }

    public static void main(String[] args) {
        _189_旋转数组 a = new _189_旋转数组();
        int[] data = {1, 2, 3, 4, 5, 6, 7};
        a.rotate(data, 3);
        System.out.println(Arrays.toString(data));
    }
}
