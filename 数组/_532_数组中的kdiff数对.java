package 数组;

import java.util.*;

public class _532_数组中的kdiff数对 {
    public int findPairs(int[] nums, int k) {
        int res = 0;
        if (k < 0) return res;
        Set<Integer> set = new TreeSet<Integer>();
        Map<Integer, Integer> map = new TreeMap<>();
        if (k == 0) { // 判断k是否为0
            for (int num : nums) {
                if (set.contains(num) && map.get(num) < 2) res++;
                map.putIfAbsent(num, 0);
                int count = map.get(num);
                map.replace(num, ++count);
                set.add(num);
            }
            return res;
        }
        for (int num : nums) {
            set.add(num);
        }
        Iterator<Integer> it = set.iterator();
        while (it.hasNext()) {
            int num = it.next();
            if (set.contains(num + k)) res++;
            if (set.contains(num - k)) res++;
            it.remove();
        }
        return res;
    }

    public static void main(String[] args) {
        _532_数组中的kdiff数对 a = new _532_数组中的kdiff数对();
        int[] data = {1};
        System.out.println(a.findPairs(data, 2));
    }

    public int findPairs1(int[] nums, int k) {
        if (k < 0) return 0;
        Arrays.sort(nums);
        int start = 0, count = 0, prev = 0x7fffffff;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] - nums[start] > k || prev == nums[start]) {
                if (++start != i) i--;
            } else if (nums[i] - nums[start] == k) {
                prev = nums[start++];
                count++;
            }
        }
        return count;
    }

}
