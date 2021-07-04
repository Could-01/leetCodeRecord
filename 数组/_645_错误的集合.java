package 数组;

import java.util.Arrays;

public class _645_错误的集合 {
    public int[] findErrorNums(int[] nums) {
        int n = nums.length;
        int rep = 0;
        int sum = 0;
        for (int i = 0; i < n; i++) {
            int temp = nums[i];
            if (temp > n) temp -= n;
            sum += temp;
            if (nums[temp - 1] > n) rep = temp;
            else nums[temp - 1] += n;
        }
        return new int[]{rep, (n * (n + 1) >> 1) - (sum - rep)};
    }

    public static void main(String[] args) {
        _645_错误的集合 a = new _645_错误的集合();
        int[] data = new int[100];
        data = new int[]{1, 2, 3, 4, 3};
        System.out.println(Arrays.toString(a.findErrorNums(data)));
    }
}
