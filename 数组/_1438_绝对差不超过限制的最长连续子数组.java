package 数组;

import java.util.Arrays;
import java.util.Deque;
import java.util.LinkedList;
import java.util.TreeMap;

public class _1438_绝对差不超过限制的最长连续子数组 {
    public int longestSubarray(int[] nums, int limit) {
        int len = nums.length;
        if (len <= 1) return len;
        boolean check = check(nums, limit);
        if (check) {
            return len;
        }

        int maxlenth = Math.abs(nums[0] - nums[1]) <= limit ? 2 : 0;
        for (int i = 2; i < nums.length; i++) {
            int max = nums[i], min = nums[i];
            int j;
            for (j = i; j >= 0; j--) {
                max = Math.max(nums[j], max);
                min = Math.min(nums[j], min);
                if (max - min > limit) {
                    break;
                }
            }
            int length = i - j;
            maxlenth = Math.max(maxlenth, length);
        }
        return maxlenth;

    }

    public boolean check(int[] nums, int limit) {
        int max = nums[0], min = nums[0];
        for (int i = 1; i < nums.length; i++) {
            max = Math.max(max, nums[i]);
            min = Math.min(min, nums[i]);
        }
        return max - min <= limit;
    }

    public int longestSubarray1(int[] nums, int limit) {
        Deque<Integer> max = new LinkedList<>();
        Deque<Integer> min = new LinkedList<>();
        int left = 0, right = 0;
        while (right < nums.length) {
            int offer = nums[right++];
            while (!max.isEmpty() && offer > max.peekLast()) {
                max.pollLast();
            }
            while (!min.isEmpty() && offer < min.peekLast()) {
                min.pollLast();
            }
            max.offer(offer);
            min.offer(offer);
            if (max.peekFirst() - min.peekFirst() > limit) {
                int poll = nums[left++];
                if (min.peekFirst() == poll) min.pollFirst();
                if (max.peekFirst() == poll) max.pollFirst();
            }
        }
        return right - left;
    }

    public int longestSubarray2(int[] nums, int limit) {
        TreeMap<Integer, Integer> treeMap = new TreeMap<>();
        int left = 0,right = 0,size = 0,maxSize = 0,len = nums.length;
        while (right<len){
            int item = nums[right];
            treeMap.put(item, treeMap.getOrDefault(item,0)+1);
            right++;
            while (treeMap.lastKey() - treeMap.firstKey()>limit){
                if (treeMap.get(nums[left])==1){
                    treeMap.remove(nums[left]);
                }else{
                    treeMap.put(nums[left],treeMap.get(nums[left])-1);
                }
                left++;
            }
            maxSize = Math.max(maxSize,right-left);
        }
        return maxSize;
    }

    public static void main(String[] args) {
        _1438_绝对差不超过限制的最长连续子数组 a = new _1438_绝对差不超过限制的最长连续子数组();
        int[] data = {1, 5, 6, 7, 8, 10, 6, 5, 6};
        System.out.println(a.longestSubarray1(data, 4));
    }
}
