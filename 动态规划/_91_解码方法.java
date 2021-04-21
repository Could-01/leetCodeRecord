package 动态规划;

import java.util.Arrays;

public class _91_解码方法 {
    public int numDecodings(String s) {
        int[] dp = new int[s.length()];//到当前数字时的解码种数
        dp[0] = 1;
        if (s.charAt(0) == '0')//如果第一个字母是0，无法解码
            return 0;
        for (int i = 1; i < s.length(); i++) {
            if (s.charAt(i) == '0') {
                //出现0，但是0前面不是1，2，不能解码
                if (s.charAt(i - 1) != '1' && s.charAt(i - 1) != '2') return 0;
                //0出现再位置1，只有一种解码方式，出现在其他位置等于dp[i-2]
                dp[i] = i == 1 ? 1 : dp[i - 2];
            } else if (s.charAt(i - 1) == '1' || (s.charAt(i - 1) == '2' && s.charAt(i) - '0' > 0 && s.charAt(i) - '0' < 7)) {
                //出现两种解法方式的条件
                //出现在位置1，没有i-2
                //出现在其他位置dp[i-1]+dp[i-2]
                dp[i] = i == 1 ? dp[i - 1] + 1 : dp[i - 1] + dp[i - 2];
            } else {
                //只有一种解码的时候
                dp[i] = dp[i - 1];
            }
        }
        return dp[s.length() - 1];
    }

    public static void main(String[] args) {
        _91_解码方法 a = new _91_解码方法();
        System.out.println(a.numDecodings("06"));
    }
}
