package 数组;

import java.util.Arrays;

public class _80_删除排序数组中的重复项II {
    public int removeDuplicates(int[] nums) {
        if (nums == null || nums.length == 0) return 0;
        int count = 2, size = nums.length;
        for (int i = 1; i <= size - 1; i++) {
            if (nums[i - 1] == nums[i]) {
                count--;
                if (count == 0) {
                    int d = 1;
                    for (int j = i; j < size - 1; j++) {
                        if (nums[j] == nums[j + 1]) {
                            d++;
                        } else {
                            break;
                        }
                    }
                    int x = i;
                    for (int k = i + d; k < size; k++) {
                        nums[x++] = nums[k];
                    }
                    size -= d;
                    count = 2;
                }
            } else {
                count = 2;
            }
        }
        return size;
    }


    public static void main(String[] args) {
        _80_删除排序数组中的重复项II a = new _80_删除排序数组中的重复项II();
        int[] nums = {0, 0, 1, 1, 1, 1, 2, 3, 3};
        int[] nums1 = {1, 1, 1, 2, 2, 3};
        int[] nums2 = {1, 1, 1, 2, 2, 2, 3, 3, 3, 4};
        int[] nums3 = {1};
        System.out.println(a.removeDuplicates(nums3));
        System.out.println(Arrays.toString(nums3));
    }
}

class Test_80 {
    public int removeDuplicates(int[] nums) {
        int i = 0;
        for (int n : nums)
            if (i < 2 || n > nums[i - 2])
                nums[i++] = n;
        return i;
    }

    public static void main(String[] args) {
        Test_80 a = new Test_80();
        int[] nums = {0, 0, 1, 1, 1, 1, 2, 3, 3};
        int[] nums1 = {1, 1, 1, 2, 2, 3};
        int[] nums2 = {1, 1, 1, 2, 2, 2, 3, 3, 3, 4};
        int[] nums3 = {1};
        System.out.println(a.removeDuplicates(nums3));
        System.out.println(Arrays.toString(nums3));
    }
}