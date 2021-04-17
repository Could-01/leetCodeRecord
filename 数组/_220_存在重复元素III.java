package 数组;

import java.util.TreeSet;

public class _220_存在重复元素III {
    public boolean containsNearbyAlmostDuplicate(int[] nums, int k, int t) {
        TreeSet<Long> set = new TreeSet<>();
        for (int i = 0; i < nums.length; i++) {
            // 边添加边查找
            // 查找表中是否有大于等于 nums[i] - t 且小于等于 nums[i] + t 的值
            Long ceiling = set.ceiling((long) nums[i] - (long) t);
            if (ceiling != null && ceiling <= ((long) nums[i] + (long) t)) {
                return true;
            }
            // 添加后，控制查找表（窗口）大小，移除窗口最左边元素
            set.add((long) nums[i]);
            if (set.size() == k + 1) {
                set.remove((long) nums[i - k]);
            }
        }
        return false;
    }

    public static void main(String[] args) {
        _220_存在重复元素III a = new _220_存在重复元素III();
        int[] data = {-2147483648, 2147483647};
        System.out.println(a.containsNearbyAlmostDuplicate(data, 1, 1));
        System.out.println(Integer.compare(-2147483648 - 1, 2147483647));
    }
}