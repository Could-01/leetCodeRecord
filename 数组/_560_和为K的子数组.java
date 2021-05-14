package 数组;

import java.util.HashMap;

public class _560_和为K的子数组 {
    public int subarraySum(int[] nums, int k) {
        // 利用哈希表实现线性寻找
        HashMap<Integer, Integer> hashMap = new HashMap<>();
        hashMap.put(0, 1);
        int i;
        int sum = 0;
        int count = 0;
        for (i = 0; i < nums.length; i++) {
            sum += nums[i];
            if (hashMap.containsKey(sum - k))   // 表示连续子数组减去连续子数组，必定为连续子数组
            {
                count += hashMap.get(sum - k);
            }
            hashMap.put(sum, hashMap.getOrDefault(sum, 0) + 1);
        }
        return count;
    }

    public static void main(String[] args) {
        _560_和为K的子数组 a = new _560_和为K的子数组();
        int[] data = {1, 1, 1};
        System.out.println(a.subarraySum(data, 2));
    }
}
