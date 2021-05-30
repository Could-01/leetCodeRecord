package 数组;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Stack;

public class _1124_表现良好的最长时间段 {
    public int longestWPI(int[] hours) {
        int length = hours.length;
        int cursor = 0, res = 0, tmp = 0;
        Stack<Integer> stack = new Stack<>();
        while (cursor < length) {
            int num = hours[cursor];
            if (stack.size() == 0) {
                stack.push(num);
                continue;
            }
            if (stack.peek() > 8) { // 证明此时还有多余的劳累天
                if (num <= 8) { // 抵消掉了一天
                    tmp++;
                    stack.pop();
                } else {
                    stack.push(num);
                }
            } else {
                if (num <= 8) {
                    res = Math.max(tmp, res);
                } else {
                    tmp++;
                    stack.pop();
                }
            }
            cursor++;
        }
        while (stack.size() != 0 && stack.peek() > 8) {
            res++;
            stack.pop();
        }
        return res;
    }


    public int longestWPI1(int[] hours) {
        //1.通过前缀和反映工作到第i天的净劳累天数,补零方便寻找上坡
        int len = hours.length;
        int[] tired = new int[len + 1];
        tired[0] = 0;
        for (int i = 0; i < len; i++) {
            tired[i + 1] = tired[i] + (hours[i] > 8 ? 1 : -1);
        }
        //2.建立“单调栈”
        Deque<Integer> stack = new ArrayDeque<>();

        for (int i = 0; i < len; i++) {
            if (stack.isEmpty() || tired[i] < tired[stack.peek()]) {
                stack.push(i);
            }
        }
        //3.寻找最长上坡
        int res = 0;
        for (int i = len; i > 0; i--) {
            while (!stack.isEmpty() && tired[i] > tired[stack.peek()]) {
                res = Math.max(res, i - stack.pop());
            }
        }
        return res;
    }

    public int longestWPI2(int[] hours) {
        int max = 0;
        Stack<Integer> stack = new Stack<>();
        int[] prefixSrc = new int[hours.length + 1];
        //大于8的置为1，否则置为-1
        for (int i = 0; i < hours.length; i++) {
            if (hours[i] > 8) {
                max = 1;
                hours[i] = 1;
            } else {
                hours[i] = -1;
            }
            //初始化前缀和数组
            prefixSrc[0] = 0;
            prefixSrc[i + 1] = prefixSrc[i] + hours[i];
        }
        for (int i = 0; i < prefixSrc.length - 1; i++) {
            //实现单调栈
            if (stack.isEmpty()) {
                stack.push(i);
            } else {
                if (prefixSrc[i] < prefixSrc[stack.peek()]) {
                    stack.push(i);
                }
            }
        }
        //开始寻找,从后往前遍历
        for (int i = prefixSrc.length - 1; i >= 0; i--) {
            int last = i;
            while (!stack.isEmpty() && prefixSrc[i] > prefixSrc[stack.peek()]) {
                last = stack.pop();
            }
            if (last != i) {
                int width = i - last;
                max = max > width ? max : width;
            }
        }
        return max;
    }


    public int longestWPI3(int[] hours) {
        int len = hours.length;
        int[] score = new int[len];
        for (int i = 0; i < len; i++) {
            if (hours[i] > 8) score[i] = 1;
            else score[i] = -1;
        }
        int[] presum = new int[len + 1];
        presum[0] = 0;
        for (int i = 1; i < len + 1; i++) {
            presum[i] = presum[i - 1] + score[i - 1];
        }
        int res = 0;
        Stack<Integer> stack = new Stack<>();
        stack.push(0);
        for (int i = 1; i < len; i++) {
            if (presum[stack.peek()] - presum[i] > 0) {
                stack.push(i);
            }
        }
        for (int i = len; i >= 0; i--) {
            while (!stack.isEmpty() && presum[i] - presum[stack.peek()] > 0) {
                res = Math.max(res, i - stack.pop());
            }
        }
        return res;
    }


    public static void main(String[] args) {
        _1124_表现良好的最长时间段 a = new _1124_表现良好的最长时间段();
        int[] data = {9, 9, 6, 0, 6, 6, 9};
        int[] data1 = {6, 9, 9};
        int res = a.longestWPI3(data);
        System.out.println(res);

    }
}
