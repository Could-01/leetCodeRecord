package 动态规划;

import java.util.Arrays;

public class _354_俄罗斯套娃信封问题 {
    public int maxEnvelopes(int[][] envelopes) {
        int n = envelopes.length, max = 1;
        if (n < 1) return 0;
        int[] dp = new int[n];
        Arrays.fill(dp, 1);
        Arrays.sort(envelopes, (a, b) -> a[0] - b[0]); // 长宽递增
        for (int i = 1; i < n; ++i) {
            for (int j = 0; j < i; ++j) {
                if (envelopes[i][0] > envelopes[j][0] && envelopes[i][1] > envelopes[j][1]) {
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }
            }
            max = Math.max(max, dp[i]);
        }
        return max;
    }


    public int maxEnvelopes1(int[][] envelopes) {
        if (envelopes == null || envelopes.length == 0 || envelopes[0].length == 0) return 0;
        Arrays.sort(envelopes, ((o1, o2) -> o1[0] == o2[0] ? o2[1] - o1[1] : o1[0] - o2[0]));
        return LIS(envelopes);
    }

    public int LIS(int[][] envelopes) {
        int n = envelopes.length;
        int[] d = new int[n + 1];
        int len = 1;
        d[len] = envelopes[0][1];
        for (int i = 1; i < n; i++) {
            if (envelopes[i][1] > d[len]) {
                d[++len] = envelopes[i][1];
            } else {
                int l = 1, r = len;
                int pos = 0;
                while (l <= r) {
                    int mid = ((r - l) >> 1) + l;
                    if (d[mid] < envelopes[i][1]) {
                        l = mid + 1;
                        pos = mid;
                    } else {
                        r = mid - 1;
                    }
                }
                d[pos + 1] = envelopes[i][1];
            }
        }
        return len;
    }


    public static void main(String[] args) {
        _354_俄罗斯套娃信封问题 a = new _354_俄罗斯套娃信封问题();
        int[][] data1 = {{5, 4}, {6, 4}, {6, 7}, {2, 3}};
        int[][] data = {{6, 10}, {11, 14}, {6, 1}, {16, 14}, {13, 2}};
        System.out.print(a.maxEnvelopes(data));
    }
}
