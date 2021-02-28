package 数组;

import java.util.*;

public class _18_四数之和 {
    public List<List<Integer>> fourSum(int[] nums, int target) {
        List<List<Integer>> res = new ArrayList<>();
        int len = nums.length;
        if (len < 4) return res;
        Arrays.sort(nums);
        Set<List<Integer>> set = new HashSet<>();
        for (int i = 0; i < len - 3; i++) {
            int SecondNum = target - nums[i];
            if (nums[i] << 2 > target) break;
            for (int j = i + 1; j < len - 2; j++) {
                int Sum = SecondNum - nums[j];
                int left = j + 1, right = nums.length - 1;
                if (nums[left] << 1 > Sum || nums[right] << 1 < Sum) continue;
                while (left < right) {
                    int TwoSum = nums[left] + nums[right];
                    if (TwoSum < Sum) {
                        left++;
                    } else if (TwoSum > Sum) {
                        right--;
                    } else {
                        List<Integer> list = Arrays.asList(nums[i], nums[j], nums[left], nums[right]);
                        Collections.sort(list);
                        set.add(list);
                        left++;
                        right--;
                    }
                }
            }
        }
        res.addAll(set);
        return res;
    }

    public static void main(String[] args) {
        _18_四数之和 a = new _18_四数之和();
        int[] data = {-5, 5, 4, -3, 0, 0, 4, -2};
        // -5 0 4 5
        System.out.println(a.fourSum(data, 4));
    }
}
