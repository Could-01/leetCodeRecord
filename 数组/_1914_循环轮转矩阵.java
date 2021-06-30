package 数组;

import java.util.Arrays;

public class _1914_循环轮转矩阵 {
    public int[][] rotateGrid(int[][] grid, int k) {
        int width = grid[0].length, height = grid.length;
        int[] pos = {0, 1, 0, -1, 0};

        boolean[][] mark = new boolean[height][width];
        for (int i = 0; i < Math.min(height / 2, width / 2); i++) {
            int h = height - (i * 2); // 高
            int w = width - (i * 2); // 宽
            int perimeter = (h * 2 + w * 2) - 4; //周长
            int k1 = k;
            if (k1 > perimeter) {
                k1 = k1 % perimeter;
            }
            if (k1 == 0) continue;
            int x = i, y = i, pcur = 0;
            int pre = grid[y][x];
            for (int j = 0; j < perimeter; j++) {
                for (int m = 0; m < k1; m++) {
                    x += pos[pcur];
                    y += pos[pcur + 1];
                    if ((x == i && y == height - 1 - i) || (y == height - 1 - i && x == width - 1 - i) || (x == width - 1 - i && y == i) || (x == i && y == i)) {
                        pcur = pcur == 3 ? 0 : pcur + 1;
                    }
                }
                if (mark[y][x]) { //回到了一个被更改的点
                    x += pos[pcur];
                    y += pos[pcur + 1];
                    if ((x == i && y == height - 1 - i) || (y == height - 1 - i && x == width - 1 - i) || (x == width - 1 - i && y == i) || (x == i && y == i)) {
                        pcur = pcur == 3 ? 0 : pcur + 1;
                    }
                    j--;
                    pre = grid[y][x];
                    continue;
                }
                int tmp = grid[y][x];
                mark[y][x] = true;
                grid[y][x] = pre;
                pre = tmp;
            }
        }
        return grid;
    }

    public int[][] rotateGrid1(int[][] grid, int k) {
        int m = grid.length, n = grid[0].length;
        int x = Math.min(m / 2, n / 2);
        int tm = m, tn = n;
        for (int c = 0; c < x; c++) {
            int tk = k % (2 * (tm + tn) - 4);
            while (tk-- != 0) {
                int first = grid[c][c];
                for (int i = c; i < n - c - 1; i++) {
                    grid[c][i] = grid[c][i + 1];
                }
                for (int i = c; i < m - c - 1; i++) {
                    grid[i][n - c - 1] = grid[i + 1][n - c - 1];
                }
                for (int i = n - c - 1; i > c; i--) {
                    grid[m - c - 1][i] = grid[m - c - 1][i - 1];
                }
                for (int i = m - c - 1; i > c; i--) {
                    grid[i][c] = grid[i - 1][c];
                }
                grid[c + 1][c] = first;
            }
            tm -= 2;
            tn -= 2;
        }
        return grid;
    }

    public static void main(String[] args) {
        _1914_循环轮转矩阵 a = new _1914_循环轮转矩阵();
//        int[][] data = {{1, 2, 3, 4}, {16, 1, 2, 5}, {15, 8, 3, 6}, {14, 7, 4, 7}, {13, 6, 5, 8}, {12, 11, 10, 9}};
        int[][] data = {{40, 10}, {30, 20}};
//        int[][] data = {{1, 2, 3, 4, 5, 6}, {20, 1, 2, 3, 4, 7}, {19, 12, 1, 2, 5, 8}, {18, 11, 4, 3, 6, 9}, {17, 10, 9, 8, 7, 10}, {16, 15, 14, 13, 12, 11}};
//        int[][] data = {{4, 5, 8, 9, 4, 2, 4, 7, 2, 4}, {7, 1, 9, 6, 6, 1, 4, 5, 7, 7}, {7, 1, 5, 1, 1, 7, 10, 1, 3, 1}, {7, 2, 2, 5, 2, 6, 6, 4, 7, 7}, {1, 2, 3, 8, 4, 7, 6, 9, 6, 2}, {5, 10, 3, 4, 7, 2, 7, 5, 3, 10}};
//        int[][] data = {{3970, 1906, 3608, 298, 3072, 3546, 1502, 773, 4388, 3115, 747, 3937},
//                {2822, 304, 4179, 1780, 1709, 1058, 3645, 681, 2910, 2513, 4357, 1038},
//                {4471, 2443, 218, 550, 2766, 4780, 1997, 1672, 4095, 161, 4645, 3838},
//                {2035, 2350, 3653, 4127, 3208, 4717, 4347, 3452, 1601, 3725, 3060, 2270},
//                {188, 2278, 81, 3454, 3204, 1897, 2862, 4381, 3704, 2587, 743, 3832},
//                {996, 4499, 66, 2742, 1761, 1189, 608, 509, 2344, 3271, 3076, 108},
//                {3274, 2042, 2157, 3226, 2938, 3766, 2610, 4510, 219, 1276, 3712, 4143},
//                {744, 234, 2159, 4478, 4161, 4549, 4214, 4272, 701, 4376, 3110, 4896},
//                {4431, 1011, 757, 2690, 83, 3546, 946, 1122, 2216, 3944, 2715, 2842},
//                {898, 4087, 703, 4153, 3297, 2968, 3268, 4717, 1922, 2527, 3139, 1516},
//                {1086, 1090, 302, 1273, 2292, 234, 3268, 2284, 4203, 3838, 2227, 3651},
//                {2055, 4406, 2278, 3351, 3217, 2506, 4525, 233, 3829, 63, 4470, 3170},
//                {3797, 3276, 1755, 1727, 1131, 4108, 3633, 1835, 1345, 1293, 2778, 2805},
//                {1215, 84, 282, 2721, 2360, 2321, 1435, 2617, 1202, 2876, 3420, 3034}};
        int[][] res = a.rotateGrid(data, 1);
        System.out.println(Arrays.deepToString(res));
    }
}
