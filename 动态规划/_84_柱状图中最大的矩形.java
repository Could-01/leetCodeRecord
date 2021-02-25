package 动态规划;

import java.util.ArrayDeque;
import java.util.Deque;

public class _84_柱状图中最大的矩形 {
    // 单增栈
    public int largestRectangleArea(int[] heights) {
        int len = heights.length;
        if (len == 0) return 0;
        if (len == 1) return heights[0];

        int res = 0;
        int[] newHeights = new int[len + 2];
        newHeights[0] = 0;
        System.arraycopy(heights, 0, newHeights, 1, len);
        newHeights[len + 1] = 0;
        len += 2;
        heights = newHeights;

        Deque<Integer> stack = new ArrayDeque<>(len);
        // 先放入哨兵，在循环里就不用做非空判断
        stack.addLast(0);
        // 如果发现小的，由右至左进行倒推
        for (int i = 1; i < len; i++) {
            while (heights[i] < heights[stack.peekLast()]) {
                int curHeight = heights[stack.pollLast()];
                int curWidth = i - stack.peekLast() - 1;
                res = Math.max(res, curHeight * curWidth);
            }
            stack.addLast(i);
        }
        return res;
    }


    public int largestRectangleArea1(int[] heights) {
        int length = heights.length, area = 0;
        int[] tmp = new int[length + 2];
        System.arraycopy(heights, 0, tmp, 1, length);

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
        return area;
    }

    public static void main(String[] args) {
        _84_柱状图中最大的矩形 a = new _84_柱状图中最大的矩形();
        int[] data = {2, 1, 5, 6, 2, 3};
        System.out.println(a.largestRectangleArea1(data));
    }
}
