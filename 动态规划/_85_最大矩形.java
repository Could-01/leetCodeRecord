package 动态规划;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;
import java.util.Map;

public class _85_最大矩形 {
    public int maximalRectangle(char[][] matrix) {
        if (matrix.length == 0) {
            return 0;
        }
        int m = matrix.length, n = matrix[0].length;
        if (n == 0) return 0;
        int[][] dp = new int[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (matrix[i][j] == '0') continue;
                if (i == 0) {
                    dp[i][j] = 1;
                } else {
                    dp[i][j] += dp[i - 1][j] + 1;
                }
            }
        }
        int area = 0;
        for (int j = 0; j < m; j++) {
            int[] tmp = new int[n + 2];
            System.arraycopy(dp[j], 0, tmp, 1, n);
            Deque<Integer> stack = new ArrayDeque<>();
            for (int i = 0; i < tmp.length; i++) {
                // 对栈中柱体来说，栈中的下一个柱体就是其「左边第一个小于自身的柱体」；
                // 若当前柱体 i 的高度小于栈顶柱体的高度，说明 i 是栈顶柱体的「右边第一个小于栈顶柱体的柱体」。
                // 因此以栈顶柱体为高的矩形的左右宽度边界就确定了，可以计算面积～
                while (!stack.isEmpty() && tmp[i] < tmp[stack.peek()]) {
                    int h = tmp[stack.pop()];
                    area = Math.max(area, (i - stack.peek() - 1) * h);
                }
                stack.push(i);
            }
        }
        return area;
    }

    /**
     * 动态规划 + 柱子最大面积问题
     * 1、小于当前柱子的最左边界，和小于当前柱子的最右边界
     * 2、逐层遍历，求出当前柱子的左右延伸的最大面积
     * 初始值：左边界都是-1，右边界都是列宽度
     * 注意：延伸过程中，当前为0，则保存当前0的下标，作为下一个柱子的左边界或者右边界
     * 同时0柱子的左边界也是存在的，即为-1，右边界同理
     */
    public int maximalRectangle1(char[][] matrix) {
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
            return 0;
        }
        int len = matrix[0].length, res = 0;
        int[] height = new int[len];
        int[] lmi = new int[len];
        int[] rmi = new int[len];
        Arrays.fill(lmi, -1);
        Arrays.fill(rmi, len);
        for (int row = 0; row < matrix.length; row++) {
            // 处理高度
            for (int col = 0; col < len; col++) {
                if (matrix[row][col] == '1') {
                    height[col] += 1;
                } else {
                    height[col] = 0;
                }
            }
            int temp = -1;
            // 处理左边界
            for (int col = 0; col < len; col++) {
                // 边界要么在最左边，要么在上一次出现0的位置
                if (matrix[row][col] == '1') {
                    lmi[col] = Math.max(lmi[col], temp);
                }
                // 要保重连续性，出现0就必须选择尽量靠右的边界
                else {
                    lmi[col] = -1;
                    temp = col;
                }
            }
            temp = len;
            // 处理右边界
            for (int col = len - 1; col >= 0; col--) {
                // 边界要么在最左边，要么在上一次出现0的位置
                if (matrix[row][col] == '1') {
                    rmi[col] = Math.min(rmi[col], temp);
                }
                // 要保重连续性，出现0就必须选择尽量靠右的边界
                else {
                    rmi[col] = len;
                    temp = col;
                }
            }
            // 处理最大面积
            for (int col = 0; col < len; col++) {
                // rmi[col] - lmi[col]直接相减只剔除掉一个边界，-1去除掉另外一个边界
                res = Math.max(res, (rmi[col] - lmi[col] - 1) * height[col]);
            }
        }
        return res;
    }


    public static void main(String[] args) {
        _85_最大矩形 a = new _85_最大矩形();
        char[][] data = {{'1', '0', '1', '0', '0'}, {'1', '0', '1', '1', '1'}, {'1', '1', '1', '1', '1'}, {'1', '0', '0', '1', '0'}};
        System.out.println(a.maximalRectangle(data));
    }
}
