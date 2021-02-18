package 动态规划;
import java.util.ArrayDeque;
import java.util.Deque;

public class _84_柱状图中最大的矩形 {
    // 单调栈
    public int largestRectangleArea(int[] heights) {
        int len = heights.length;
        if (len == 0) {
            return 0;
        }

        if (len == 1) {
            return heights[0];
        }

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

    public static void main(String[] args) {
        _84_柱状图中最大的矩形 a = new _84_柱状图中最大的矩形();
        int[] data = {2, 1, 5, 6, 2, 3};
        System.out.println(a.largestRectangleArea(data));
    }
}
