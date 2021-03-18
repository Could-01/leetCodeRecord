package 数组;

import java.util.ArrayList;
import java.util.List;

public class _493_翻转对 {
    public int reversePairs(int[] nums) {
        List<Long> list = new ArrayList<>();
        int ans = 0;
        for (int i = nums.length - 1; i >= 0; i--) {
            ans += binSearch(list, (long) nums[i]);
            list.add(binSearch(list, (long) nums[i] * 2), (long) nums[i] * 2);
        }
        return ans;
    }

    private int binSearch(List<Long> list, long target) {
        int l = 0, r = list.size() - 1;
        while (l <= r) {
            int mid = l + (r - l) / 2;
            if (list.get(mid) >= target) {
                r = mid - 1;
            } else {
                l = mid + 1;
            }
        }
        return l;
    }

    public static void main(String[] args) {
        _493_翻转对 a = new _493_翻转对();
        int[] data1 = {2, 4, 3, 5, 1};
        int[] data = {2147483647, 2147483647, 2147483647, 2147483647, 2147483647, 2147483647};
        System.out.println(a.reversePairs(data));
    }
}
