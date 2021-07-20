package 数组;

import java.util.Arrays;

public class _1838_最高频元素的频数 {
    public int maxFrequency(int[] nums, int k) {
        Arrays.sort(nums);
        int max = 0, tempSum = 0;
        for (int i = 0, j = 0; j < nums.length; j++) {
            while (nums[j] * (j - i) - tempSum > k) {
                tempSum -= nums[i++];
            }
            tempSum += nums[j];
            max = Math.max(max, j - i + 1);
        }
        return max;
    }


    public static void main(String[] args) {
        _1838_最高频元素的频数 a = new _1838_最高频元素的频数();
        int[] data = {1, 4, 8, 13};
        System.out.println(a.maxFrequency(data, 5));
    }
}
