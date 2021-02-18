package 动态规划;

import java.util.Arrays;

public class _978_最长湍流子数组 {
    public int maxTurbulenceSize(int[] arr) {
        int greater = 1, less = 1;
        int ans = 1;
        for (int i = 1; i < arr.length; i++) {
            if (arr[i] > arr[i - 1]) {
                greater = ++less;
                less = 1;
            } else if (arr[i] < arr[i - 1]) {
                less = ++greater;
                greater = 1;
            } else {
                less = greater = 1;
            }
            ans = Math.max(ans, Math.max(greater, less));
        }
        return ans;
    }

    public static void main(String[] args) {
        _978_最长湍流子数组 a = new _978_最长湍流子数组();
        int[] arr = {9, 4, 2, 10, 7, 8, 8, 1, 9};
        System.out.println(a.maxTurbulenceSize(arr));
    }
}


class Test_978 {
    public int maxTurbulenceSize(int[] arr) {
        int len = arr.length;
        if (len == 1) return 1;
        int[] dp = new int[len];
        int symbol = -(arr[1] - arr[0]);
        dp[0] = 0;
        int res = 0;
        for (int i = 1; i < len; i++) {
            int diff = arr[i] - arr[i - 1];
            if (diff < 0 && symbol > 0) {
                dp[i] += dp[i - 1] + 1;
            } else if (diff > 0 && symbol < 0) {
                dp[i] += dp[i - 1] + 1;
            } else if (diff == 0) {
                continue;
            } else {
                dp[i] = 1;
            }
            symbol = diff;
            res = Math.max(res, dp[i]);
        }
        return res + 1;
    }

    public static void main(String[] args) {
        Test_978 a = new Test_978();
        int[] arr1 = {9, 4, 2, 10, 7, 8, 8, 1, 9};
        int[] arr2 = {4};
        int[] arr4 = {4, 8, 12, 16};
        int[] arr3 = {10, 7, 9, 9, 11, 10};
        System.out.println(a.maxTurbulenceSize(arr1));
    }
}