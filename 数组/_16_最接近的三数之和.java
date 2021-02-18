package 数组;

import java.util.Arrays;

public class _16_最接近的三数之和 {
    public int threeSumClosest(int[] nums, int target) {
        Arrays.sort(nums);
        int result = nums[0] + nums[1] + nums[2];
        for (int i = 0; i < nums.length - 2; i++) {
            int left = i + 1;
            int right = nums.length - 1;
            while (left < right) {
                int sum = nums[i] + nums[left] + nums[right];
                if (sum == target) {
                    return sum;
                }
                if (Math.abs(sum - target) < Math.abs(result - target))
                    result = sum;
                if (sum > target) {
                    right--;
                    while (left < right && nums[right] == nums[right + 1])
                        right--;
                } else {
                    left++;
                    while (left < right && nums[left] == nums[left - 1])
                        left++;
                }
            }
            while (i < nums.length - 2 && nums[i] == nums[i + 1])
                i++;
        }
        return result;
    }

    public static void main(String[] args) {
        _16_最接近的三数之和 d = new _16_最接近的三数之和();
        int[] nums1 = {-1, 2, 1, -4};
        int[] nums2 = {1, 2, 4, 8, 16, 32, 64, 128};
        int[] nums4 = {0, 2, 1, -3};
        int[] nums = {1, 1, 1, 0};
        // -1 0 0 1 2 3
        // -2 -1 0 1 2 3
        System.out.println(d.threeSumClosest(nums2, 82));
    }
}

class Test_16 {
    public int threeSumClosest(int[] nums, int target) {
        Arrays.sort(nums);
        int result = nums[0] + nums[1] + nums[2];
        for (int i = 0; i < nums.length - 2; i++) {
            int left = i + 1, right = nums.length - 1;
            int n = nums[i];
            while (left < right) {
                int sum = n + nums[left] + nums[right];
                if (sum == target) return target;
                if (Math.abs(sum - target) < Math.abs(result - target)) result = sum;
                if (sum > target) {
                    right--;
                } else {
                    left++;
                }
            }
        }
        return result;
    }

    public static void main(String[] args) {
        Test_16 d = new Test_16();
        int[] nums1 = {-1, 2, 1, -4};
        int[] nums2 = {1, 2, 4, 8, 16, 32, 64, 128};
        int[] nums4 = {0, 2, 1, -3};
        int[] nums = {1, 1, 1, 0};
        System.out.println(d.threeSumClosest(nums2, 82));
    }
}