package 数组;

import java.util.ArrayList;
import java.util.List;


// 吉林大学2015 软件工程考研试题
public class _54_螺旋矩阵 {
    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> result = new ArrayList<>();
        if (matrix.length == 0 || matrix[0].length == 0) {
            return result;
        }

        //二维矩阵的维数
        int row = matrix.length;
        int col = matrix[0].length;

        //四指针(上、下、左、右)
        int up = 0;
        int down = row - 1;
        int left = 0;
        int right = col - 1;

        while (true) {
            //1. 先记录上横行
            for (int i = left; i <= right; i++) {
                result.add(matrix[up][i]);
            }
            up++;   //横行下移
            //边界判断
            if (up > down) {
                break;
            }

            //2. 记录右竖行
            for (int i = up; i <= down; i++) {
                result.add(matrix[i][right]);
            }
            right--;
            if (left > right) {
                break;
            }

            //3. 记录下横行
            for (int i = right; i >= left; i--) {
                result.add(matrix[down][i]);
            }
            down--;
            if (up > down) {
                break;
            }

            //4. 记录左竖行
            for (int i = down; i >= up; i--) {
                result.add(matrix[i][left]);
            }
            left++;
            if (left > right) {
                break;
            }
        }
        return result;
    }

    public List<Integer> spiralOrder1(int[][] matrix) {
        List<Integer> res = new ArrayList<>();
        int ml = matrix.length, m0l = matrix[0].length;
        if (ml == 0 || m0l == 0) return res;
        int[] position = {0, 1, 0, -1, 0};
        int row = 0, col = 0;
        int index = 0;
        // row行 col列
        while (res.size() != ml * m0l) {
            int num = matrix[row][col];
            if (num != 101) res.add(num);
            matrix[row][col] = 101;
            row += position[index];
            col += position[index + 1];
            if (col == m0l || row == ml || col == -1 || row == -1 || matrix[row][col] == 101) {
                index++;
                if (row == ml) {
                    row--;
                    col += position[index + 1];
                    continue;
                }

                if (col == m0l) {
                    col--;
                    row += position[index];
                    continue;
                }

                if (col == -1) {
                    row--;
                    col++;
                }

                if (matrix[row][col] == 101) {
                    index--;
                    row -= position[index];
                    col -= position[index + 1];
                    index++;
                }

                if (index == 4) {
                    index = 0;
                }
            }

        }
        return res;
    }


    public static void main(String[] args) {
        _54_螺旋矩阵 a = new _54_螺旋矩阵();
        int[][] data1 = {{1, 2, 3, 4}, {12, 13, 14, 5}, {11, 16, 15, 6}, {10, 9, 8, 7}};
        int[][] data = {{1, 2, 3, 4}, {5, 6, 7, 8}, {9, 10, 11, 12}};
        System.out.println(a.spiralOrder1(data));

    }
}
