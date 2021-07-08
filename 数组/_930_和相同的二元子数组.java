package 数组;

import java.util.HashMap;
import java.util.Map;

public class _930_和相同的二元子数组 {
    public int numSubarraysWithSum(int[] nums, int t) {
        int n = nums.length;
        int[] sum = new int[n + 1];
        for (int i = 1; i <= n; i++) sum[i] = sum[i - 1] + nums[i - 1];
        Map<Integer, Integer> map = new HashMap<>();
        map.put(0, 1);
        int ans = 0;
        for (int i = 0; i < n; i++) {
            int r = sum[i + 1], l = r - t;
            ans += map.getOrDefault(l, 0);
            map.put(r, map.getOrDefault(r, 0) + 1);
        }
        return ans;
    }

    public static void main(String[] args) {
        _930_和相同的二元子数组 a = new _930_和相同的二元子数组();
        int[] data = {1, 0, 1, 0, 1};
        System.out.println(a.numSubarraysWithSum(data, 2));
    }
}
