package 数组;

import java.util.Arrays;

public class _48_旋转图像 {
    public void rotate(int[][] matrix) {
        int m = matrix.length;
        int x = m - 1;
        for (int i = 0; i < m / 2; i++, x--) {
            for (int j = 0; j < m; j++) {
                int num = matrix[i][j];
                matrix[i][j] = matrix[x][j];
                matrix[x][j] = num;
            }
        }
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < i; j++) {
                int num = matrix[i][j];
                matrix[i][j] = matrix[j][i];
                matrix[j][i] = num;
            }
        }
    }

    public static void main(String[] args) {
        _48_旋转图像 a = new _48_旋转图像();
        int[][] data = {{1, 2, 3}, {4, 5, 6}, {7, 8, 9}};
        a.rotate(data);
        for (int[] arr : data) {
            System.out.println(Arrays.toString(arr));
        }
    }
}
