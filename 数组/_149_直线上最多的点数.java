package 数组;

import java.util.HashMap;

public class _149_直线上最多的点数 {
    public int maxPoints(int[][] points) {
        int n = points.length;
        int max = 0;
        for (int i = 0; i < n; i++) {
            HashMap<Double, Integer> hm = new HashMap<>();
            for (int j = 0; j < n; j++) {
                if (i == j) continue;
                int w = points[i][0] - points[j][0];
                int h = points[i][1] - points[j][1];
                double db = h == 0 ? Integer.MAX_VALUE : w * 1.0 / h * 1.0;
                hm.put(db, hm.getOrDefault(db, 0) + 1);
            }
            for (Double db : hm.keySet()) {
                max = Math.max(max, hm.get(db));
            }
        }

        return max + 1;
    }

    public int maxPoints1(int[][] points) {
        //暴力点就是,选出两个点，判断剩下的点和这些点在不在一个直线上;
        if (points.length <= 0) {
            return 0;
        }
        int maxPoint = 1;
        for (int i = 0; i < points.length; i++) {
            for (int j = i + 1; j < points.length; j++) {
                int count = 2;
                //判断在这个线上的个数;
                //考虑一个问题1,2,3,4都在一条直线上;
                //2的时候，需要再去考虑1吗？
                //1的时候应该一定考虑过了把;
                int x1 = points[i][0];
                int y1 = points[i][1];

                int x2 = points[j][0];
                int y2 = points[j][1];

                int deltaY = y2 - y1;
                int deltaX = x2 - x1;

                for (int k = j + 1; k < points.length; k++) {
                    int x3 = points[k][0];
                    int y3 = points[k][1];
                    if ((y3 - y1) * deltaX == (x3 - x1) * deltaY) {
                        count++;
                    }
                }
                if (count > maxPoint) {
                    maxPoint = count;
                }
            }
        }
        return maxPoint;
    }

    public static void main(String[] args) {
        _149_直线上最多的点数 a = new _149_直线上最多的点数();
        int[][] data = {{1, 1}, {3, 2}, {5, 3}, {4, 1}, {2, 3}, {1, 4}};
        System.out.println(a.maxPoints(data));
    }
}
