package 数组;

import java.util.Arrays;

public class _73_矩阵置零 {
    public void setZeroes(int[][] matrix) {
        boolean row = false; // 第一行是否为0
        boolean col = false; // 第一列是否有0
        int m = matrix.length, n = matrix[0].length;

        for (int i = 0; i < Math.max(m, n); i++) {
            if (i < m && matrix[i][0] == 0) {
                row = true;
            }
            if (i < n && matrix[0][i] == 0) {
                col = true;
            }
        }

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (matrix[i][j] == 0) {
                    matrix[0][j] = matrix[i][0] = 0;
                }
            }
        }
        // 填充0
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                if (matrix[0][j] == 0 || matrix[i][0] == 0)
                    matrix[i][j] = 0;
            }
        }

        if (row) {
            for (int i = 0; i < m; i++) {
                matrix[i][0] = 0;
            }
        }

        if (col) {
            for (int i = 0; i < n; i++) {
                matrix[0][i] = 0;
            }
        }

    }

    public static void main(String[] args) {
        _73_矩阵置零 a = new _73_矩阵置零();
        int[][] data = {{0, 1, 2, 0}, {3, 4, 5, 2}, {1, 3, 1, 5}};
        a.setZeroes(data);
        for (int[] arr : data) {
            System.out.println(Arrays.toString(arr));
        }
    }
}
