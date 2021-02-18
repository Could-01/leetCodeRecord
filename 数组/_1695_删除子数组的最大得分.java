package 数组;

import java.util.HashSet;
import java.util.Set;

public class _1695_删除子数组的最大得分 {
    public int maximumUniqueSubarray(int[] nums) {
        int sum = 0, left = 0, right = 0, res = 0, right_num, left_num;
        Set<Integer> set = new HashSet<>();
        while (right < nums.length) {
            right_num = nums[right];
            if (!set.contains(right_num)) {
                set.add(right_num);
                sum += right_num;
                right++;
                res = Math.max(res, sum);
            } else {
                left_num = nums[left];
                while (left_num != right_num) {
                    set.remove(left_num);
                    sum -= left_num;
                    left_num = nums[++left];
                }
                set.remove(left_num);
                sum -= left_num;
                left++;
            }
        }
        return res;
    }

    public static void main(String[] args) {
        _1695_删除子数组的最大得分 a = new _1695_删除子数组的最大得分();
        int[] data = {5, 2, 1, 2, 5, 2, 1, 2, 5};
        System.out.println(a.maximumUniqueSubarray(data));
    }
}
