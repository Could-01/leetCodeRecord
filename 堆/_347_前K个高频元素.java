package 堆;

import java.util.*;

public class _347_前K个高频元素 {
    public int[] topKFrequent(int[] nums, int k) {
        PriorityQueue<Integer> queue = new PriorityQueue<Integer>();
        // k : num v : size
        Map<Integer, Integer> map = new HashMap<Integer, Integer>();

        for (int num : nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }
        int[] res = new int[k];
        for (int i : map.keySet()) {
            int n = map.get(i);
            if (queue.size() < k) {
                queue.add(n);
            } else {
                // 等于 k
                if (n > queue.peek()) {
                    queue.poll();
                    queue.add(n);
                }
            }
        }
        for (int i = 0; i < k; i++) {
            int q = queue.poll();
            for (int m : map.keySet()) {
                if (map.get(m) == q) {
                    map.remove(m);
                    res[i] = m;
                    break;
                }
            }
        }
        return res;
    }

    public int[] topKFrequent1(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int num : nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }
        PriorityQueue<Integer> queue = new PriorityQueue<>();
        for (int key : map.keySet()) {
            queue.offer(key);
            if (queue.size() > k) {
                queue.poll();
            }
        }
        int[] res = new int[k];
        for (int i = 0; i < k; i++) {
            res[i] = queue.poll();
        }
        return res;
    }


    public static void main(String[] args) {
        _347_前K个高频元素 a = new _347_前K个高频元素();
        int[] data = {1, 2};
        System.out.println(Arrays.toString(a.topKFrequent(data, 2)));
    }
}
