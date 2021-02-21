package 堆;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;

public class _239_滑动窗口最大值 {
    public int[] maxSlidingWindow(int[] nums, int k) {
        int len = nums.length;
        if (len == 0) return new int[0];
        int[] res = new int[len - k + 1];
        Deque<Integer> queue = new ArrayDeque<>();
        for (int i = 0, j = 0; i < len; i++) {
            if (!queue.isEmpty() && i - queue.peek() >= k) {
                queue.poll();
            }
            while (!queue.isEmpty() && nums[i] > nums[queue.peekLast()]) {
                queue.pollLast();
            }
            queue.offer(i);
            if (i >= k - 1) {
                res[j++] = nums[queue.peek()];
            }
        }
        return res;
    }

    public static void main(String[] args) {
        _239_滑动窗口最大值 a = new _239_滑动窗口最大值();
        int[] data = {1,3,-1,-3,5,3,6,7};
        System.out.println(Arrays.toString(a.maxSlidingWindow(data, 3)));
    }
}
