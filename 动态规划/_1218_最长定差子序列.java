package 动态规划;

import java.util.HashMap;
import java.util.Map;

public class _1218_最长定差子序列 {
    public int longestSubsequence(int[] arr, int difference) {
        int ans = 1;
        Map<Integer, Integer> map = new HashMap<>();
        for (int i : arr) {
            int temp = map.getOrDefault(i - difference, 0) + 1;
            map.put(i, temp);
            ans = Math.max(ans, temp);
        }
        return ans;
    }

    public int longestSubsequence1(int[] arr, int difference) {
        int[] ints = new int[40001];
        int max = 1;
        for (int length : arr) {
            int i = ints[(length - difference) + 20000] + 1;
            ints[length + 20000] = i;
            max = Math.max(max, i);
        }
        return max;
    }

    public int longestSubsequence2(int[] arr, int difference) {
        int n = arr.length;
        int offset = 10000;
        int[] dp = new int[2 * offset + 1];
        int result = 1;
        for (int i = 0; i < n; i++) {
            int index = arr[i] + offset;
            dp[index] = 1;
            int prevIdx = index - difference;
            if (prevIdx > 0 && prevIdx < dp.length && dp[prevIdx] != 0) {
                dp[index] = Math.max(dp[index], dp[prevIdx] + 1);
            }
            result = Math.max(result, dp[index]);
        }
        return result;
    }

    public static void main(String[] args) {
        _1218_最长定差子序列 a = new _1218_最长定差子序列();
        int[] arr = {1, 5, 7, 8, 5, 3, 4, 2, 1};
        System.out.println(a.longestSubsequence(arr, -2));
    }


}
