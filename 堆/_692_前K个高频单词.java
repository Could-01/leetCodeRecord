package 堆;

import java.util.*;

public class _692_前K个高频单词 {
    public List<String> topKFrequent(String[] words, int k) {
        Map<String, Integer> map = new HashMap<>(words.length);
        for (String word : words) {
            map.put(word, map.getOrDefault(word, 0) + 1);
        }
        //大堆
        PriorityQueue<String> queue = new PriorityQueue<>((o1, o2) -> {
            Integer o1Count = map.get(o1);
            Integer o2Count = map.get(o2);
            if (o1Count.equals(o2Count)) {
                return o1.compareTo(o2);
            } else {
                return o2Count - o1Count;
            }
        });
        for (String s : map.keySet()) {
            queue.add(s);
        }
        List<String> res = new ArrayList<>();
        for (int i = 0; i < k; i++) {
            res.add(queue.poll());
        }
        return res;
    }
}
