package 动态规划;

import java.util.Arrays;

public class _32_最长有效括号 {
    // ((())  ()())(
    public int longestValidParentheses(String s) {
        int len = s.length();
        if (len < 2) return 0;
        int[] dp = new int[len];
        int index = 0, res = 0;
        dp[0] = 0;
        for (int i = 1; i < len; i++) {
            char c = s.charAt(i);
            // 遇到右括号，向左匹配左括号
            if (c == ')') {
                index = i - dp[i - 1] - 1;
                if (index >= 0 && s.charAt(index) == '(') {
                    dp[i] = dp[i - 1] + 2;
                    if (index > 0) {
                        dp[i] += dp[index - 1];
                    }
                }
            }
            res = Math.max(dp[i], res);
        }
        return res;
    }

    public static void main(String[] args) {
        _32_最长有效括号 a = new _32_最长有效括号();
        System.out.println(a.longestValidParentheses("(()"));
    }
}
