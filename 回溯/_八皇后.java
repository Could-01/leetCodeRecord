package 回溯;

import java.util.ArrayList;
import java.util.List;

public class _八皇后 {


    public static void main(String[] args) {
        System.out.println(new _八皇后().solveNQueens(4));
    }

    int[] cols;
    List<List<String>> res = new ArrayList();

    public List<List<String>> solveNQueens(int n) {
        if (n < 1) return null;
        cols = new int[n];
        place(0);
        return res;
    }

    void place(int row) {
        if (row == cols.length) {
            show();
            return;
        }

        for (int col = 0; col < cols.length; col++) {
            if (isValid(row, col)) {
                cols[row] = col;
                place(row + 1);
            }
        }
    }

    /**
     * 判断第row行第col列是否可以摆放皇后
     */
    boolean isValid(int row, int col) {
        for (int i = 0; i < row; i++) {
            // 第col列已经有皇后
            if (cols[i] == col) {
                return false;
            }
            // 第i行的皇后跟第row行第col列格子处在同一斜线上
            if (row - i == Math.abs(col - cols[i])) {
                return false;
            }
        }
        return true;
    }

    void show() {
        List<String> list = new ArrayList();
        for (int row = 0; row < cols.length; row++) {
            StringBuilder sb = new StringBuilder();
            for (int col = 0; col < cols.length; col++) {
                if (cols[row] == col) {
                    sb.append("Q");
                } else {
                    sb.append(".");
                }
            }
            list.add(sb.toString());
        }
        res.add(list);
    }
}

class Solution_八皇后_1 {

    public static void main(String[] args) {
        System.out.println(new Solution_八皇后_1().solveNQueens(4));
    }

    /**
     * 数组索引是行号，数组元素是列号
     */
    int[] queens;
    /**
     * 标记着某一列是否有皇后
     */
    boolean[] cols;
    /**
     * 标记着某一斜线上是否有皇后（左上角 -> 右下角）
     */
    boolean[] leftTop;
    /**
     * 标记着某一斜线上是否有皇后（右上角 -> 左下角）
     */
    boolean[] rightTop;
    /**
     * 一共有多少种摆法
     */
    List<List<String>> res = new ArrayList();

    List<List<String>> solveNQueens(int n) {
        if (n < 1) return null;
        queens = new int[n];
        cols = new boolean[n];
        leftTop = new boolean[(n << 1) - 1];
        rightTop = new boolean[leftTop.length];
        place(0);
        return res;
    }

    /**
     * 从第row行开始摆放皇后
     *
     * @param row
     */
    void place(int row) {
        if (row == cols.length) {
            show();
            return;
        }

        for (int col = 0; col < cols.length; col++) {
            if (cols[col]) continue;
            int ltIndex = row - col + cols.length - 1;
            if (leftTop[ltIndex]) continue;
            int rtIndex = row + col;
            if (rightTop[rtIndex]) continue;

            queens[row] = col;
            cols[col] = true;
            leftTop[ltIndex] = true;
            rightTop[rtIndex] = true;
            place(row + 1);
            cols[col] = false;
            leftTop[ltIndex] = false;
            rightTop[rtIndex] = false;
        }
    }

    void show() {
        List<String> list = new ArrayList();
        for (int row = 0; row < cols.length; row++) {
            StringBuilder sb = new StringBuilder();
            for (int col = 0; col < cols.length; col++) {
                if (queens[row] == col) {
                    sb.append("Q");
                } else {
                    sb.append(".");
                }
            }
            list.add(sb.toString());
        }
        res.add(list);
    }
}

class Solution_八皇后_2 {

    public static void main(String[] args) {
        System.out.println(new Solution_八皇后_2().solveNQueens(4));
    }

    /**
     * 数组索引是行号，数组元素是列号
     */
    int[] queens;
    /**
     * 标记着某一列是否有皇后
     */
    //byte cols;
    short cols;
    /**
     * 标记着某一斜线上是否有皇后（左上角 -> 右下角）
     */
    //short leftTop;
    int leftTop;
    /**
     * 标记着某一斜线上是否有皇后（右上角 -> 左下角）
     */
    //short rightTop;
    int rightTop;
    List<List<String>> res = new ArrayList();

    List<List<String>> solveNQueens(int n) {
        queens = new int[n];
        place(0);
        return res;
    }

    /**
     * 从第row行开始摆放皇后
     *
     * @param row
     */
    void place(int row) {
        if (row == queens.length) {
            show();
            return;
        }

        for (int col = 0; col < queens.length; col++) {
            int cv = 1 << col;
            if ((cols & cv) != 0) continue;

            int lv = 1 << (row - col + queens.length - 1);
            //    row - col + cols.length - 1;
            if ((leftTop & lv) != 0) continue;

            int rv = 1 << (row + col);
            if ((rightTop & rv) != 0) continue;

            queens[row] = col;
            cols |= cv;
            leftTop |= lv;
            rightTop |= rv;
            place(row + 1);
            cols &= ~cv;
            leftTop &= ~lv;
            rightTop &= ~rv;
        }
    }

    void show() {
        List<String> list = new ArrayList();
        for (int row = 0; row < queens.length; row++) {
            StringBuilder sb = new StringBuilder();
            for (int col = 0; col < queens.length; col++) {
                if (queens[row] == col) {
                    sb.append("Q");
                } else {
                    sb.append(".");
                }
            }
            list.add(sb.toString());
        }
        res.add(list);
    }
}