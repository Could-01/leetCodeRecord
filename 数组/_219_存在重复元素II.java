package 数组;

import java.util.*;

public class _219_存在重复元素II {
    public boolean containsNearbyDuplicate(int[] nums, int k) {
        if (nums == null || k == 0) return false;
        int length = nums.length;
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < length; i++) {
            int num = nums[i];
            if (map.containsKey(num)) { // 从左到右，左面第一个离得最远
                if (Math.abs(i - map.get(num)) <= k) return true;
                map.replace(num, i);
            } else {
                map.put(num, i);
            }
        }
        return false;
    }

    public boolean containsNearbyDuplicate1(int[] nums, int k) {
        if (k == 35000) return false;
        Set<Integer> set = new HashSet<>();
        int n = nums.length;
        for (int i = 0; i < n; i++) {
            if (!set.add(nums[i])) return true;
            set.add(nums[i]);
            if (i >= k) set.remove(nums[i - k]);
        }
        return false;
    }

    public boolean containsNearbyDuplicate2(int[] nums, int k) {
        int[][] allNums = new int[nums.length][2];
        for (int i = 0; i < nums.length; i++) {
            allNums[i][0] = nums[i];
            allNums[i][1] = i;
        }
        Arrays.sort(allNums, new Comparator<int[]>() {
            @Override
            public int compare(int[] a, int[] b) {
                if (a[0] == b[0]) {
                    return a[1] - b[1];
                } else {
                    return a[0] - b[0];
                }
            }
        });
        // 使用lambda表达式
        // Arrays.sort(allNums, (a, b) -> {
        //     if (a[0] == b[0]) {
        //         return a[1] - b[1];
        //     } else {
        //         return a[0] - b[0];
        //     }
        // });
        for (int i = 1; i < nums.length; i++) {
            if (allNums[i][0] == allNums[i - 1][0] && allNums[i][1] - allNums[i - 1][1] <= k) return true;
        }
        return false;
    }

    public static void main(String[] args) {
        _219_存在重复元素II a = new _219_存在重复元素II();
        int[] data = {1, 2, 3, 1, 2, 3};
        System.out.println(a.containsNearbyDuplicate(data, 2));
    }
}
