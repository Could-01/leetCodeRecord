package 数组;

import java.util.Arrays;

public class _27_移除元素 {
    public int removeElement(int[] nums, int val) {
        int l = nums.length;
        for (int i = 0; i < l; i++) {
            if (nums[i] == val) {
                l--;
                for (int j = i; j < nums.length - 1; j++) {
                    nums[j] = nums[j + 1];
                }
                i--;
            }
        }
        return l;
    }

    public int removeElement1(int[] nums, int val) {
        if (nums.length == 0) return 0;
        int left = 0, right = nums.length - 1, count = 0;
        while (left <= right) {
            while (nums[right] == val && right > left) right--;
            if (nums[left] == val) {
                nums[left] = nums[right];
                right--;
                left--;
            } else {
                count++;
            }
            left++;
        }
        return count;
    }

    public static void main(String[] args) {
        _27_移除元素 a = new _27_移除元素();
        int[] data = {0, 1, 2, 2, 3, 0, 4, 2};
        System.out.println(a.removeElement1(data, 2));
        System.out.println(Arrays.toString(data));
    }
}
