package 数组;

import java.util.Arrays;

public class _611_有效三角形的个数 {
    // 从0遍历的暴力解
    public int triangleNumber(int[] nums) {
        int start = 0, left = 1, right = 2, length = nums.length, count = 0;
        if (length < 3) return 0;
        Arrays.sort(nums);
        while (start < length - 2) {
            int twosum = nums[start] + nums[left];
            if (right < length && twosum > nums[right]) {
                right++;
                count++;
            } else if (left < length - 1) {
                left++;
                right = left + 1;
            } else {
                start++;
                left = start + 1;
                right = left + 1;
            }
        }
        return count;
    }


    // 根据范围确定
    public int triangleNumber1(int[] nums) {
        /*
        因为三条边中任意两边之和大于第三边，因此我们只要求较小的两条边大于较大的边即可
        我们先将数组排序，然后从后面取第三边，再从前面求两边
        */
        Arrays.sort(nums);
        int len = nums.length;
        int c = 0;
        for (int i = len - 1; i >= 2; i--) {
            int left = 0;
            int right = i - 1;
            while (left < right) {
                //只要 left 和 right 两边符合条件，那么表示 [left, right - 1] 这几条边 和 right 都满足条件，因此组合数为 right - left
                if (nums[left] + nums[right] > nums[i]) {
                    c += right - left;
                    right--;
                } else {
                    left++;
                }
            }
        }
        return c;
    }

    public static void main(String[] args) {
        _611_有效三角形的个数 a = new _611_有效三角形的个数();
        int[] data = {1, 1, 2};
        System.out.println(a.triangleNumber(data));
    }
}
