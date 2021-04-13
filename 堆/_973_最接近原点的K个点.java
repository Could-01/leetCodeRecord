package 堆;

import java.util.Arrays;
import java.util.PriorityQueue;

public class _973_最接近原点的K个点 {
    public int[][] kClosest(int[][] points, int k) {
        int[][] res = new int[k][2];
        PriorityQueue<int[]> queue = new PriorityQueue<>((o1, o2) -> {
            return Integer.compare(o1[0], o2[0]);
        });
        for (int i = 0; i < points.length; i++) {
            int[] arr = new int[3];
            int x = points[i][0];
            int y = points[i][1];
            arr[0] = x * x + y * y;
            arr[1] = x;
            arr[2] = y;
            queue.offer(arr);
        }
        for (int i = k; i > 0; i--) {
            int[] tmp = queue.poll();
            res[k - i][0] = tmp[1];
            res[k - i][1] = tmp[2];
        }
        return res;
    }


    public static void main(String[] args) {
        _973_最接近原点的K个点 a = new _973_最接近原点的K个点();
        int[][] data = {{3, 3}, {5, -1}, {-2, 4}};
        int[][] res = a.kClosest(data, 2);
        for (int[] arr : res) {
            System.out.println(Arrays.toString(arr));
        }
    }
}
