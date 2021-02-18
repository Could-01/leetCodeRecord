package 堆;

import java.util.Comparator;
import java.util.PriorityQueue;

public class _215_数组中的第K个最大元素 {
    public int findKthLargest(int[] nums, int k) {
        int len = nums.length;
        PriorityQueue<Integer> queue = new PriorityQueue<>(len, new Comparator<Integer>() {
            @Override
            public int compare(Integer i1, Integer i2) {
                return i2 - i1;
            }
        });

        for (int i : nums) {
            queue.add(i);
        }
        int num = 0;
        for (int i = 0; i < k; i++) {
            num = queue.poll();
        }
        return num;
    }

    public static void main(String[] args) {
        _215_数组中的第K个最大元素 a = new _215_数组中的第K个最大元素();
        int[] nums = {3, 2, 1, 5, 6, 4};
        System.out.println(a.findKthLargest(nums, 2));
    }
}
