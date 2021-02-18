package 回溯;

public class _52_八皇后Ⅱ {

    public static void main(String[] args) {
        // TODO Auto-generated method stub
        System.out.println(new _52_八皇后Ⅱ().totalNQueens(9));
    }

    /**
     * 数组索引是行号，数组元素是列号
     */
    int[] queens;
    /**
     * 标记着某一列是否有皇后
     */
    short cols;
    /**
     * 标记着某一斜线上是否有皇后（左上角 -> 右下角）
     */
    int leftTop;
    /**
     * 标记着某一斜线上是否有皇后（右上角 -> 左下角）
     */
    int rightTop;
    /**
     * 一共有多少种摆法
     */
    int ways;

    public int totalNQueens(int n) {
        queens = new int[n];
        place(0);
        return ways;
    }


    /**
     * 从第row行开始摆放皇后
     *
     * @param row
     */
    void place(int row) {
        if (row == queens.length) {
            ways++;
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

}
