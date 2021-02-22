package 数组;

import java.util.Arrays;

public class _1658_将x减到0的最小操作数 {
    public int minOperations(int[] nums, int x) {
        int maxPart = -1;
        int sum = Arrays.stream(nums).sum();
        int currentSum = 0;
        int left = 0;
        int right = 0;
        while (right < nums.length) {
            currentSum += nums[right++];
            while (currentSum > sum - x && left < nums.length) {
                currentSum -= nums[left++];
            }
            if (currentSum == sum - x) {
                maxPart = Math.max(maxPart, right - left);
            }
        }
        return maxPart == -1 ? -1 : nums.length - maxPart;
    }

    public static void main(String[] args) {
        _1658_将x减到0的最小操作数 a = new _1658_将x减到0的最小操作数();
        int[] data = {1, 1, 4, 2, 3};
        System.out.println(a.minOperations(data, 5));
    }
}
