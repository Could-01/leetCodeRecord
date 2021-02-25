package 数组;

import java.util.Arrays;

public class _867_转置矩阵 {
    public int[][] transpose(int[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;
        if (m == n) {
            for (int i = 1; i < m; i++) {
                for (int j = 0; j < i; j++) {
                    int temp = matrix[i][j];
                    matrix[i][j] = matrix[j][i];
                    matrix[j][i] = temp;
                }
            }
            return matrix;
        }
        int[][] B = new int[n][m];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                B[i][j] = matrix[j][i];
            }
        }
        return B;
    }

    public static void main(String[] args) {
        _867_转置矩阵 a = new _867_转置矩阵();
        int[][] data = {{1, 2, 3}, {4, 5, 6}, {7, 8, 9}};
        for (int[] arr : a.transpose(data)) {
            System.out.println(Arrays.toString(arr));
        }
    }
}
