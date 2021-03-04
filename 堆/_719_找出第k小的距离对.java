package 堆;

import java.util.Arrays;

public class _719_找出第k小的距离对 {
    public int smallestDistancePair(int[] nums, int k) {
        Arrays.sort(nums);
        int len = nums.length, low = 0, high = nums[len - 1] - nums[0];
        while (low < high) {
            int mid = low + (high - low) / 2;
            int count = 0;
            int left = 0;
            for (int right = 0; right < len; right++) {
                while (nums[right] - nums[left] > mid) left++;
                count += right - left;
            }

            if (count >= k) {
                high = mid;
            } else {
                low = mid + 1;
            }
        }
        return low;
    }


    public static void main(String[] args) {
        _719_找出第k小的距离对 a = new _719_找出第k小的距离对();
        int[] data = {62, 100, 4};
        System.out.println(a.smallestDistancePair(data, 2));

    }
}
