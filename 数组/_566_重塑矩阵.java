package 数组;

import java.util.Arrays;

public class _566_重塑矩阵 {
    public int[][] matrixReshape(int[][] nums, int r, int c) {
        int cols = nums[0].length, rows = nums.length;
        if (r * c != rows * cols || r * c == 0) return nums;
        int[][] res = new int[r][c];
        int h = 0, w = 0;
//        for (int[] arr : nums) {
//            for (int num : arr) {
//                res[h][w++] = num;
//                if (w == c) {
//                    h++;
//                    w = 0;
//                }
//            }
//        }
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                res[h][w++] = nums[i][j];
                if (w == c) {
                    h++;
                    w = 0;
                }
            }
        }
        return res;
    }

    public static void main(String[] args) {
        _566_重塑矩阵 a = new _566_重塑矩阵();
        int[][] data = {{1, 2}, {3, 4}, {5, 6}};
        int[][] res = a.matrixReshape(data, 2, 3);
        for (int[] arr : res) {
            System.out.println(Arrays.toString(arr));
        }

    }
}
