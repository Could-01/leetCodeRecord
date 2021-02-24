package 数组;

import java.util.Arrays;

public class _832_翻转图像 {
    public int[][] flipAndInvertImage(int[][] A) {
        int right;
        int left;
        for (int i = 0; i < A.length; i++) {
            left = 0;
            right = A[0].length - 1;
            while (left <= right) {
                if (A[i][left] == A[i][right]) {
                    A[i][right] = A[i][left] = A[i][left] == 0 ? 1 : 0;
                }
                left++;
                right--;
            }
        }
        return A;
    }

    public static void main(String[] args) {
        _832_翻转图像 a = new _832_翻转图像();
        int[][] data = {{1, 1, 0, 0}, {1, 0, 0, 1}, {0, 1, 1, 1}, {1, 0, 1, 0}};
        for (int[] arr : a.flipAndInvertImage(data)) {
            System.out.println(Arrays.toString(arr));
        }
    }
}
