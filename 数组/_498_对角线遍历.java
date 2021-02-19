package 数组;

import java.util.*;

public class _498_对角线遍历 {

    public int[] findDiagonalOrder(int[][] matrix) {
        if (matrix == null || matrix.length == 0) {
            return new int[]{};
        }
        int r = 0, c = 0;
        int row = matrix.length, col = matrix[0].length;
        int[] res = new int[row * col];
        for (int i = 0; i < res.length; i++) {
            res[i] = matrix[r][c];
            // r + c 即为遍历的层数，偶数向上遍历，奇数向下遍历
            if ((r + c) % 2 == 0) {
                if (c == col - 1) {
                    // 往下移动一格准备向下遍历
                    r++;
                } else if (r == 0) {
                    // 往右移动一格准备向下遍历
                    c++;
                } else {
                    // 往上移动
                    r--;
                    c++;
                }
            } else {
                if (r == row - 1) {
                    // 往右移动一格准备向上遍历
                    c++;
                } else if (c == 0) {
                    // 往下移动一格准备向上遍历
                    r++;
                } else {
                    // 往下移动
                    r++;
                    c--;
                }
            }
        }
        return res;
    }

    // 尝试暴力解通过
    // 硬嗑暴力解
    public int[] findDiagonalOrder1(int[][] matrix) {
        if (matrix == null || matrix.length == 0) {
            return new int[]{};
        }
        int rows = matrix.length, cols = matrix[0].length;
        TreeMap<Integer, List<Integer>> tree = new TreeMap<Integer, List<Integer>>();
        int r = 0, tmpr = 0, index = 0;
        int[] res = new int[rows * cols];
        for (int i = 0; i < cols + rows - 1; i++) {
            List<Integer> list = new ArrayList<>();
            int c = 1;
            r = tmpr;
            if (r < rows) {
                for (; r > -1; r--) {
                    c = i - r;
                    if (c >= cols || c < 0) continue;
                    list.add(r);
                    list.add(c);
                }
                tmpr++;
            } else {
                for (; c < cols; c++) {
                    r = i - c;
                    if (r >= rows || r < 0) continue;
                    list.add(r);
                    list.add(c);
                }
            }
            tree.put(i, list);
        }
//        tree.forEach((key, value) -> {
//            System.out.println(key + ": " + value);
//        });
        for (int i : tree.keySet()) {
            List<Integer> list = tree.get(i);
            if (i % 2 == 0) {
                for (int j = 0; j < list.size(); j++) {
                    res[index++] = matrix[list.get(j)][list.get(++j)];
                }
            } else {
                for (int j = list.size() - 1; j > 0; j--) {
                    res[index++] = matrix[list.get(j - 1)][list.get(j--)];
                }
            }
        }
        return res;
    }

    // 优化暴力解 -> 去除TreeMap结构
    public int[] findDiagonalOrder2(int[][] matrix) {
        if (matrix == null || matrix.length == 0) {
            return new int[]{};
        }
        int rows = matrix.length, cols = matrix[0].length;
        int r = 0, tmpr = 0, index = 0;
        int[] res = new int[rows * cols];
        for (int i = 0; i < cols + rows - 1; i++) {
            List<Integer> list = new ArrayList<>();
            int c = 1;
            r = tmpr;
            if (r < rows) {
                for (; r > -1; r--) {
                    c = i - r;
                    if (c >= cols || c < 0) continue;
                    list.add(r);
                    list.add(c);
                }
                tmpr++;
            } else {
                for (; c < cols; c++) {
                    r = i - c;
                    if (r >= rows || r < 0) continue;
                    list.add(r);
                    list.add(c);
                }
            }
            if (i % 2 == 0) {
                for (int j = 0; j < list.size(); j++) {
                    res[index++] = matrix[list.get(j)][list.get(++j)];
                }
            } else {
                for (int j = list.size() - 1; j > 0; j--) {
                    res[index++] = matrix[list.get(j - 1)][list.get(j--)];
                }
            }
        }
        return res;
    }

    // 优化暴力解 -> 使用栈
    public int[] findDiagonalOrder3(int[][] matrix) {
        if (matrix == null || matrix.length == 0) {
            return new int[]{};
        }
        int rows = matrix.length, cols = matrix[0].length;
        int r = 0, tmpr = 0, index = 0;
        int[] res = new int[rows * cols];
        for (int i = 0; i < cols + rows - 1; i++) {
            int c = 1;
            r = tmpr;
            if (i % 2 == 0) {
                if (r < rows) {
                    for (; r > -1; r--) {
                        c = i - r;
                        if (c >= cols || c < 0) continue;
                        res[index++] = matrix[r][c];
                    }
                    tmpr++;
                } else {
                    for (; c < cols; c++) {
                        r = i - c;
                        if (r >= rows || r < 0) continue;
                        res[index++] = matrix[r][c];
                    }
                }
            } else {
                Stack<Integer> stack = new Stack<>();
                if (r < rows) {
                    for (; r > -1; r--) {
                        c = i - r;
                        if (c >= cols || c < 0) continue;
                        stack.push(r);
                        stack.push(c);
                    }
                    tmpr++;
                } else {
                    for (; c < cols; c++) {
                        r = i - c;
                        if (r >= rows || r < 0) continue;
                        stack.push(r);
                        stack.push(c);
                    }
                }
                while (stack.size() != 0) {
                    int y = stack.pop();
                    int x = stack.pop();
                    res[index++] = matrix[x][y];
                }
            }
        }
        return res;
    }

    // 接着优化...
    // 空间击败 81.91%
    public static void main(String[] args) {
        _498_对角线遍历 a = new _498_对角线遍历();
        int[][] data = {{1, 2, 3}, {4, 5, 6}, {7, 8, 9}};
        int[][] data1 = {{1, 2, 3}};
//        System.out.println(Arrays.toString(a.findDiagonalOrder(data)));
//        System.out.println(Arrays.toString(a.findDiagonalOrder1(data1)));
        System.out.println(Arrays.toString(a.findDiagonalOrder3(data1)));
    }
}
