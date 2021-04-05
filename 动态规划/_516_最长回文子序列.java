package 动态规划;

import java.util.Arrays;

public class _516_最长回文子序列 {
    public int longestPalindromeSubseq(String s) {
        int length = s.length();
        String stmp = new StringBuilder(s).reverse().toString();
        int[] dp = new int[length + 1];
        for (int i = 1; i <= length; i++) {
            int cur = 0;
            for (int j = 1; j <= length; j++) {
                int leftTop = cur;
                cur = dp[j];
                if (stmp.charAt(i - 1) == s.charAt(j - 1)) {
                    dp[j] = leftTop + 1;
                } else {
                    dp[j] = Math.max(dp[j], dp[j - 1]);
                }
            }
        }
        return dp[length];
    }

    public int longestPalindromeSubseq1(String s) {
        if (s == null) return 0;
        int len = s.length();
        char[] chs = s.toCharArray();
        int[] dp = new int[len];
        Arrays.fill(dp, 1);
        int max = 0;
        for (int i = len - 1; i >= 0; i--) {
            char cur = chs[i];
            int curMax = 0;
            for (int j = i + 1; j < len; j++) {
                int mem = dp[j];
                if (cur == chs[j]) {
                    dp[j] = curMax + 2;
                }
                curMax = Math.max(mem, curMax);
            }
        }
        for (int e : dp) max = Math.max(max, e);
        // System.out.println(Arrays.toString(dp));
        return max;
    }

    public static void main(String[] args) {
        _516_最长回文子序列 a = new _516_最长回文子序列();
        System.out.print(a.longestPalindromeSubseq("bbbab"));
    }
}
