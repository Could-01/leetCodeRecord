package 数组;

import java.util.Arrays;

public class _59_螺旋矩阵II {
    public int[][] generateMatrix(int n) {
        int[][] res = new int[n][n];
        int[] position = {0, 1, 0, -1, 0};
        int count = 1, index = 0;
        int row = 0, col = 0;
        while (count != (n * n) + 1) {
            res[row][col] = count++;
            row += position[index];
            col += position[index + 1];

            if (col == n || col == -1 || row == n || res[row][col] != 0) {
                index++;
                if (col == n) {
                    col--;
                    row += position[index];
                    continue;
                }
                if (row == n) {
                    row--;
                    col += position[index + 1];
                    continue;
                }
                if (col == -1) {
                    row--;
                    col++;
                }
                if (res[row][col] != 0) {
                    index--;
                    row -= position[index];
                    col -= position[index + 1];
                    index++;
                    if (index != 4) {
                        row += position[index];
                        col += position[index + 1];
                    }
                }
                if (index == 4) {
                    index = 0;
                    row += position[index];
                    col += position[index + 1];
                }
            }

        }
        return res;
    }

    public int[][] generateMatrix1(int n) {
        int[][] ans = new int[n][n];
        int[] dx = {0, 1, 0, -1}, dy = {1, 0, -1, 0};
        for (int i = 0, startX = 0, startY = 0, d = 0; i < n * n; i++) {
            ans[startX][startY] = i + 1;
            int curX = startX + dx[d], curY = startY + dy[d];
            if (curX < 0 || curY < 0 || curX >= n || curY >= n || ans[curX][curY] != 0) d = (d + 1) % 4;
            startX = startX + dx[d];
            startY = startY + dy[d];
        }
        return ans;
    }

    public static void main(String[] args) {
        _59_螺旋矩阵II a = new _59_螺旋矩阵II();
        for (int[] arr : a.generateMatrix(1)) {
            System.out.println(Arrays.toString(arr));
        }
    }
}
