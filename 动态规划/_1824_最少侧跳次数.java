package 动态规划;

public class _1824_最少侧跳次数 {
    public int minSideJumps(int[] obstacles) {
        int n = obstacles.length;
        int[][] dp = new int[n][3];
        dp[0][0] = 1;
        dp[0][2] = 1;

        for (int i = 1; i < n; ++i) {
            if (obstacles[i] == 1) {
                dp[i][0] = Integer.MAX_VALUE - 1;
                dp[i][1] = Math.min(dp[i - 1][1], dp[i - 1][2] + 1);
                dp[i][2] = Math.min(dp[i - 1][2], dp[i - 1][1] + 1);
            } else if (obstacles[i] == 2) {
                dp[i][1] = Integer.MAX_VALUE - 1;
                dp[i][0] = Math.min(dp[i - 1][0], dp[i - 1][2] + 1);
                dp[i][2] = Math.min(dp[i - 1][2], dp[i - 1][0] + 1);
            } else if (obstacles[i] == 3) {
                dp[i][2] = Integer.MAX_VALUE - 1;
                dp[i][0] = Math.min(dp[i - 1][0], dp[i - 1][1] + 1);
                dp[i][1] = Math.min(dp[i - 1][1], dp[i - 1][0] + 1);
            } else {
                dp[i][0] = Math.min(dp[i - 1][0], Math.min(dp[i - 1][1], dp[i - 1][2]) + 1);
                dp[i][1] = Math.min(dp[i - 1][1], Math.min(dp[i - 1][0], dp[i - 1][2]) + 1);
                dp[i][2] = Math.min(dp[i - 1][2], Math.min(dp[i - 1][0], dp[i - 1][1]) + 1);
            }
        }
        return Math.min(dp[n - 1][0], Math.min(dp[n - 1][1], dp[n - 1][2]));
    }

    public int minSideJumps1(int[] obstacles) {
        int curr = 2;
        int res = 0;
        for (int i = 0; i < obstacles.length; i++) {
            if (obstacles[i] == curr) {
                res++;
                if (obstacles[i - 1] != 0) {
                    curr = 6 - curr - obstacles[i - 1];
                    continue;
                }
                while (obstacles[i] == 0 || obstacles[i] == curr) {
                    if (i < obstacles.length - 1)
                        i++;
                    else break;
                }
                curr = 6 - curr - obstacles[i];
            } else continue;
        }

        return res;

    }


    public static void main(String[] args) {
        _1824_最少侧跳次数 a = new _1824_最少侧跳次数();
        int[] data = {0, 1, 2, 3, 0};
        System.out.println(a.minSideJumps(data));
    }
}
