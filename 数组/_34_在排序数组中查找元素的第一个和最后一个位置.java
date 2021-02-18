package 数组;

import java.util.Arrays;

public class _34_在排序数组中查找元素的第一个和最后一个位置 {
    public int[] searchRange(int[] nums, int target) {
        int[] res = new int[2];
        Arrays.fill(res, -1);
        int left = 0, right = nums.length - 1;
        if (right == -1) return res;
        while (left <= right) {
            int left_num = nums[left];
            if (left_num < target) {
                left += 2;
            } else if (left_num == target) {
                res[0] = left;
            }

            int right_num = nums[right];
            if (right_num > target) {
                right--;
            } else if (right_num == target) {
                res[1] = right;
            }

            if (res[0] != -1 && res[1] != -1) break;
        }
        return res;
    }

    public static void main(String[] args) {
        _34_在排序数组中查找元素的第一个和最后一个位置 a = new _34_在排序数组中查找元素的第一个和最后一个位置();
        int[] data = {5, 7, 7, 8, 8, 10};
        System.out.println(Arrays.toString(a.searchRange(data, 8)));
    }
}

class Test_34 {
    public int[] searchRange(int[] nums, int target) {
        int[] res = new int[]{-1, -1};
        res[0] = binarySearch(nums, target, true);
        res[1] = binarySearch(nums, target, false);
        return res;
    }

    //leftOrRight为true找左边界 false找右边界
    public int binarySearch(int[] nums, int target, boolean leftOrRight) {
        int res = -1;
        int left = 0, right = nums.length - 1, mid;
        while (left <= right) {
            mid = left + (right - left) / 2;
            if (target < nums[mid])
                right = mid - 1;
            else if (target > nums[mid])
                left = mid + 1;
            else {
                res = mid;
                //处理target == nums[mid]
                if (leftOrRight)
                    right = mid - 1;
                else
                    left = mid + 1;
            }
        }
        return res;
    }

    public static void main(String[] args) {
        Test_34 a = new Test_34();
        int[] data = {7, 7, 7, 8, 8, 10};
        System.out.println(Arrays.toString(a.searchRange(data, 9)));
    }
}