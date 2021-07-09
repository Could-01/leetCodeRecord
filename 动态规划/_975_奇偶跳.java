package 动态规划;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;
import java.util.Stack;

public class _975_奇偶跳 {
    public int oddEvenJumps(int[] arr) {
        int length = arr.length;
        int[][] dp = new int[2][length]; //1代表奇，0代表偶  1代表可以跳到终点，2表示不可以，0是第一次来
        int res = 0;
        // BigStack 大 -> 小 递减
        Stack<Integer> Bigstack = new Stack<>();
        // Smallstack 小 -> 大 递增
        Stack<Integer> Smallstack = new Stack<>();
        for (int i = 0; i < length; i++) {
            Stack<Integer> tmp = new Stack<>();
            int num = arr[i];
            while (Bigstack.size() != 0 && arr[Bigstack.peek()] >= num) { // 保证数值相同，下标大的在后
                tmp.push(Bigstack.pop());
            }
            Bigstack.push(i);
            while (tmp.size() != 0) {
                Bigstack.push(tmp.pop());
            }
            while (Smallstack.size() != 0 && arr[Smallstack.peek()] <= num) { // 保证数值相同，下标大的在后
                tmp.push(Smallstack.pop());
            }
            Smallstack.push(i);
            while (tmp.size() != 0) {
                Smallstack.push(tmp.pop());
            }
        }
        for (int i = 0; i < length; i++) {
            int time = 1;
            boolean success = false;
            boolean[] rec = new boolean[length - i];
            for (int j = i; j < length; j++) {
                rec[j - i] = true;
                if (dp[time % 2][j] == 2) break;
                if (j == length - 1) {
                    success = true;
                    break;
                }
                Stack<Integer> tmp = new Stack<>();
                int pos = j, gap = 100001;
                if (time % 2 != 0) {
                    // 奇数需要比它大
                    while (Smallstack.size() != 0) {
                        if (Smallstack.peek() > j && arr[Smallstack.peek()] >= arr[j]) {
                            if (arr[Smallstack.peek()] - arr[j] < gap) {
                                pos = Smallstack.peek();
                                gap = arr[j] - arr[Smallstack.peek()];
                            }
                        }
                        tmp.push(Smallstack.pop());
                    }
                    if (gap == 100001) { // 没有符合的
                        dp[1][j] = 2; // 它是最大的一个了
                    } else {
                        j = pos - 1;
                    }
                    while (tmp.size() != 0) Smallstack.push(tmp.pop()); // 回填
                } else {
                    // 偶数跳比它小
                    while (Bigstack.size() != 0) {
                        if (Bigstack.peek() > j && arr[Bigstack.peek()] <= arr[j]) {
                            if (arr[j] - arr[Bigstack.peek()] < gap) {
                                pos = Bigstack.peek();
                                gap = arr[j] - arr[Bigstack.peek()];
                            }
                        }
                        tmp.push(Bigstack.pop());
                    }
                    if (gap == 100001) {
                        dp[0][j] = 2;
                    } else {
                        j = pos - 1;
                    }
                    while (tmp.size() != 0) Bigstack.push(tmp.pop());
                }
                if (gap == 100001) {
                    break;
                }
                time++;
            }
            int r = 0, f = 2;
            if (success) {
                res++;
                f = 1;
            }
            for (int k = 0; k < rec.length; k++) {
                if (rec[k]) {
                    dp[++r % 2][i + k] = f;
                }
            }
        }
        return res;
    }

    public int oddEvenJumps1(int[] arr) {
        int length = arr.length;
        int[][] dp = new int[2][length]; //1代表奇，0代表偶  1代表可以跳到终点，2表示不可以，0是第一次来
        int res = 0;
        // 大 -> 小
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < length; i++) {
            Stack<Integer> tmp = new Stack<>();
            int num = arr[i];
            while (stack.size() != 0 && arr[stack.peek()] >= num) { // 保证数值相同，下标大的在后
                tmp.push(stack.pop());
            }
            stack.push(i);
            while (tmp.size() != 0) {
                stack.push(tmp.pop());
            }
        }
        int[] Trendarr = new int[length];
        for (int i = 0; stack.size() != 0; i++) {
            Trendarr[i] = stack.pop();
        }
        for (int i = 0; i < length; i++) {
            int time = 1;
            boolean success = false;
            boolean[] rec = new boolean[length - i];
            for (int j = i; j < length; j++) {
                int value = arr[j];
                rec[j - i] = true;
                if (dp[time % 2][j] == 2) break;
                if (j == length - 1) {
                    success = true;
                    break;
                }
                int pos = j, gap = 100001;
                if (time % 2 != 0) {
                    for (int k = 0; k < length; k++) {
                        int n = Trendarr[k];
                        if (n > j && arr[n] >= value && arr[n] - value < gap) {
                            gap = arr[n] - value;
                            pos = n;
                        }
                    }
                } else {
                    for (int k = length - 1; k > 0; k--) {
                        boolean f = false;
                        int n = Trendarr[k];
                        if (n > j && value >= arr[n] && value - arr[n] < gap) {
                            gap = arr[j] - arr[n];
                            while (k != 0 && arr[Trendarr[k]] == arr[Trendarr[k - 1]]) {
                                k--;
                                f = true;
                            }
                            pos = Trendarr[k];
                            if (f) k++;
                        }
                    }
                }
                if (pos == j) {
                    break;
                } else {
                    j = pos - 1;
                }
                time++;
            }
            int r = 0, f = 2;
            if (success) {
                res++;
                f = 1;
            }
            for (int k = 0; k < rec.length; k++) {
                if (rec[k]) {
                    dp[++r % 2][i + k] = f;
                }
            }
        }
        return res;
    }

    public int oddEvenJumps2(int[] arr) {
        int len = arr.length;
        if (len == 1)
            return 1;
        int count = 1;
        boolean[] h = new boolean[len];
        boolean[] l = new boolean[len];
        h[len - 1] = l[len - 1] = true;
        Integer[] idxI = new Integer[len];
        Integer[] idxD = new Integer[len];
        for (int i = 0; i < len; i++) {
            idxI[i] = idxD[i] = i;
        }
        Arrays.sort(idxI, (i1, i2) -> {
            if (arr[i1] - arr[i2] != 0)
                return arr[i1] - arr[i2];
            else
                return i1 - i2;
        });
        Arrays.sort(idxD, (i1, i2) -> {
            if (arr[i1] - arr[i2] != 0)
                return -arr[i1] + arr[i2];
            else
                return i1 - i2;
        });
        int[] nextHigher = new int[len];
        int[] nextLower = new int[len];
        Deque<Integer> stackI = new ArrayDeque(len);
        Deque<Integer> stackD = new ArrayDeque(len);
        stackI.push(idxI[len - 1]);
        stackD.push(idxD[len - 1]);
        int idx;
        for (int i = len - 2; i >= 0; i--) {
            idx = idxI[i];
            while (!stackI.isEmpty() && stackI.peek() < idx)
                stackI.poll();
            if (stackI.peek() != null)
                nextHigher[idx] = stackI.peek();
            stackI.push(idx);
            idx = idxD[i];
            while (!stackD.isEmpty() && stackD.peek() < idx)
                stackD.poll();
            if (stackD.peek() != null)
                nextLower[idx] = stackD.peek();
            stackD.push(idx);
        }
        for (int i = len - 2; i >= 0; i--) {
            if (nextHigher[i] != 0)
                h[i] = l[nextHigher[i]];
            if (nextLower[i] != 0)
                l[i] = h[nextLower[i]];
            if (h[i])
                count++;
        }
        return count;
    }

    public static void main(String[] args) {
        _975_奇偶跳 a = new _975_奇偶跳();
        int[] data1 = {81, 54, 96, 60, 58};
        int[] data = {2, 3, 1, 1, 4};
        // 81 96 60
        // 54 58
        // 96
        // 60
        // 58
        System.out.println(a.oddEvenJumps1(data));
    }

}
