package 数组;

import java.util.Arrays;

public class _503_下一个更大元素II {
    public int[] nextGreaterElements(int[] nums) {
        int len = nums.length;
        if (len == 0) return nums;
        int tmp;
        int[] res = new int[len];
        for (int i = 0; i < len; i++) {
            int n = nums[i];
            res[i] = n;
            //往右找
            tmp = i;
            for (; tmp < len; tmp++) {
                if (nums[tmp] > n) {
                    res[i] = nums[tmp];
                    break;
                }
            }
            if (res[i] > n) continue;
            // 往左找
            tmp = 0;
            for (; tmp < i; tmp++) {
                if (nums[tmp] > n) {
                    res[i] = nums[tmp];
                    break;
                }
            }
            if (res[i] > n) continue;
            //都没找到
            res[i] = -1;
        }
        return res;
    }

    public int[] nextGreaterElements1(int[] nums) {
        int len = nums.length;
        if (len == 0) return nums;
        int[] res = new int[len];
        int save = 0;
        for (int i = 0; i < len; i++) {
            int n = nums[i];
            res[i] = n;
            //左右同时找
            int tmp = 0;
            save = n;
            for (; tmp < len; tmp++) {
                if (tmp + i < len && nums[tmp + i] > n) {
                    res[i] = nums[tmp + i];
                    break;
                }
                if (tmp < i && nums[tmp] > n && save == n) {
                    save = nums[tmp];
                }
                res[i] = save;
            }
            if (res[i] == n) res[i] = -1;
        }
        return res;
    }

    public int[] nextGreaterElements2(int[] nums) {
        int[] ans = new int[nums.length];
        int[] stack = new int[nums.length + 1];
        stack[0] = -1;
        int top = 0;
        for (int i = nums.length - 1; i >= 0; i--) {
            while (top > 0 && stack[top] <= nums[i]) {
                top--;
            }
            stack[++top] = nums[i];
        }
        for (int i = nums.length - 1; i >= 0; i--) {
            while (top > 0 && stack[top] <= nums[i]) {
                top--;
            }
            ans[i] = stack[top];
            stack[++top] = nums[i];
        }
        return ans;
    }

    public static void main(String[] args) {
        _503_下一个更大元素II a = new _503_下一个更大元素II();
        int[] data = {100, 1, 11, 1, 120, 111, 123, 1, -1, -100};
        int[] res = a.nextGreaterElements1(data);
        System.out.println(Arrays.toString(res));
    }
}
