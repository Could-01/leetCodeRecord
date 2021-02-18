package 动态规划;

import java.util.Arrays;

public class _413_等差数列划分 {
    public int numberOfArithmeticSlices(int[] A) {
        if (A == null || A.length <= 0) {
            return 0;
        }

        int length = A.length;
        int[] dp = new int[length]; // 保存当前下标的A数组元素加入时，新增的等差子区间个数
        for (int i = 2; i < length; i++) {
            if (A[i] - A[i - 1] == A[i - 1] - A[i - 2]) {
                dp[i] = dp[i - 1] + 1;
            }
        }

        int result = 0;
        for (int count : dp) {
            result += count;
        }
        return result;
    }

    public static void main(String[] args) {
        _413_等差数列划分 a = new _413_等差数列划分();
        int[] data = {1, 3, 5, 7, 9};
        System.out.println(a.numberOfArithmeticSlices(data));
    }

}