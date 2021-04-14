package 数组;

import java.util.LinkedList;
import java.util.Queue;

public class _1823_找出游戏的获胜者 {
    public int findTheWinner(int n, int k) {
        Queue<Integer> queue = new LinkedList<>();
        for (int i = 1; i < n + 1; i++) queue.add(i);
        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < k - 1; j++) queue.add(queue.poll());
            queue.poll();
        }
        return queue.poll();
    }

    public static void main(String[] args) {
        _1823_找出游戏的获胜者 a = new _1823_找出游戏的获胜者();
        System.out.println(a.findTheWinner(6, 5));
    }
}
