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

    public static void main(String[] args) {
        _27_移除元素 a = new _27_移除元素();
        int[] data = {0, 1, 2, 2, 3, 0, 4, 2};
        System.out.println(a.removeElement(data, 2));
        System.out.println(Arrays.toString(data));
    }
}
