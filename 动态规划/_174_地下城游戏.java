package 动态规划;

public class _174_地下城游戏 {
    // 求的是如何到达公主身边时血量更多？？
    public int calculateMinimumHP1(int[][] dungeon) {
        int m = dungeon.length;
        int n = dungeon[0].length;
        int[][] dp = new int[m][n];
        dp[0][0] = dungeon[0][0];
        int res = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (i == 0) {
                    if (j == 0) continue;
                    dp[i][j] = dp[i][j - 1] + dungeon[i][j];
                } else if (j == 0) { // i != 0
                    dp[i][j] = dp[i - 1][j] + dungeon[i][j];
                } else {
                    int max = Math.max(dp[i][j - 1], dp[i - 1][j]);

                    dp[i][j] = max + dungeon[i][j];
                }
            }
        }
        return dp[m - 1][n - 1];
    }


    // 每个dp装的是如果你到这个区域，你最好情况下几滴血能到达
    public int calculateMinimumHP(int[][] dungeon) {
        int row = dungeon.length;
        int col = dungeon[0].length;
        //这个数组表示在i,j位置骑士需要的最小生命值
        int[][] dp = new int[row][col];
        for (int i = row - 1; i >= 0; i--) {
            for (int j = col - 1; j >= 0; j--) {
                if (i == row - 1 && j == col - 1) { //终点的情况
                    dp[i][j] = Math.max(1, 1 - dungeon[i][j]);
                } else if (i == row - 1) { //最后一行的情况
                    dp[i][j] = Math.max(1, dp[i][j + 1] - dungeon[i][j]);
                } else if (j == col - 1) { //最后一列的情况
                    dp[i][j] = Math.max(1, dp[i + 1][j] - dungeon[i][j]);
                } else {
                    dp[i][j] = Math.max(1, Math.min(dp[i + 1][j], dp[i][j + 1]) - dungeon[i][j]);
                }
            }
        }
        return dp[0][0];
    }

    public static void main(String[] args) {
        _174_地下城游戏 a = new _174_地下城游戏();
        int[][] data = {{-2, -3, 3}, {-5, -10, 1}, {10, 30, -5}};
        System.out.println(a.calculateMinimumHP(data));
    }
}
