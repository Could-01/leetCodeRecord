package 动态规划;

import java.util.Arrays;

public class _63_不同路径II {
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int m = obstacleGrid.length;
        int n = obstacleGrid[0].length;
        int[][] paths = new int[m][n];
        if (m + n == 2 && obstacleGrid[0][0] == 0) {
            return 1;
        } else if (obstacleGrid[0][0] == 1) {
            return 0;
        }
        for (int i = 0; i < m; i++) {
            if (obstacleGrid[i][0] == 1) continue;
            paths[i][0] = 1;
        }
        for (int i = 0; i < n; i++) {
            if (obstacleGrid[0][i] == 1) continue;
            paths[0][i] = 1;
        }
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; ++j) {
                if (obstacleGrid[i][j] == 1) {
                    continue;
                }
                paths[i][j] = paths[i - 1][j] + paths[i][j - 1];
            }
        }
        return paths[m - 1][n - 1];
    }

    public static void main(String[] args) {
        _63_不同路径II a = new _63_不同路径II();
        int[][] data = {{0, 0, 0}, {0, 1, 0}, {0, 0, 0}};
        int[][] data1 = {{0}, {1}, {0}};
        int[][] data2 = {{0, 1}, {0, 0}};
        int[][] data3 = {{0}};
        int[][] data4 = {{0, 0}};
        System.out.println(a.uniquePathsWithObstacles(data4));
    }
}


class Test_63 {
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {

        if (obstacleGrid[0][0] == 1) return 0; // 出发即灭亡

        int[][] dp = new int[obstacleGrid.length][obstacleGrid[0].length];
        dp[0][0] = 1;
        for (int j = 1; j < obstacleGrid[0].length; j++) { // 将 第一行中 障碍物以前的节点路径更新
            if (obstacleGrid[0][j] == 0) {
                dp[0][j] = dp[0][j - 1];
            } else {
                break;
            }
        }
        for (int i = 1; i < obstacleGrid.length; i++) { // 将 第一列中 障碍物以前的节点路径更新
            if (obstacleGrid[i][0] == 0) {
                dp[i][0] = dp[i - 1][0];
            } else {
                break;
            }
        }

        for (int i = 1; i < obstacleGrid.length; i++) {
            for (int j = 1; j < obstacleGrid[0].length; j++) {
                if (obstacleGrid[i][j] == 0) { // 没有障碍物，继续根据状态转移公式计算路径，有的话，默认dp[i][j]为0
                    dp[i][j] = dp[i - 1][j] + dp[i][j - 1];
                }
            }
        }

        return dp[obstacleGrid.length - 1][obstacleGrid[0].length - 1];
    }

    public static void main(String[] args) {
        Test_63 a = new Test_63();
        int[][] data = {{0, 0, 0}, {0, 1, 0}, {0, 0, 0}};
        int[][] data1 = {{0}, {1}, {0}};
        int[][] data2 = {{0, 1}, {0, 0}};
        int[][] data3 = {{0}};
        int[][] data4 = {{0, 0}};
        System.out.println(a.uniquePathsWithObstacles(data4));
    }
}

class Test_63_1 {
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int m = obstacleGrid.length, n = obstacleGrid[0].length;
        int[][] dp = new int[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                //遇到障碍物，dp[i][j] = 0
                if (obstacleGrid[i][j] == 1)
                    continue;
                if (i == 0 && j == 0) {
                    dp[i][j] = 1;
                } else if (i == 0) {
                    dp[i][j] = dp[i][j - 1];
                } else if (j == 0) {
                    dp[i][j] = dp[i - 1][j];
                } else {
                    dp[i][j] = dp[i - 1][j] + dp[i][j - 1];
                }
            }
        }
        for (int[] arr : dp) {
            System.out.println(Arrays.toString(arr));
        }
        return dp[m - 1][n - 1];
    }

    public static void main(String[] args) {
        Test_63_1 a = new Test_63_1();
        int[][] data = {{0, 1, 0}, {0, 0, 0}, {0, 0, 0}};
        int[][] data1 = {{0}, {1}, {0}};
        int[][] data2 = {{0, 1}, {0, 0}};
        int[][] data3 = {{0}};
        int[][] data4 = {{0, 0}};
        System.out.println(a.uniquePathsWithObstacles(data));
    }
}

class Test_63_2 {
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int m = obstacleGrid.length;
        int n = obstacleGrid[0].length;
        int[] dp = new int[n + 1];
        dp[1] = 1;
        for (int i = 0; i < m; i++) {
            for (int j = 1; j <= n; j++) {
                if (obstacleGrid[i][j - 1] == 1) {
                    dp[j] = 0;
                } else {
                    dp[j] += dp[j - 1];
                }
            }
            System.out.println(Arrays.toString(dp));
        }
        return dp[n];
    }

    public static void main(String[] args) {
        Test_63_2 a = new Test_63_2();
        int[][] data = {{0, 0, 0}, {0, 1, 0}, {0, 0, 0}};
        int[][] data1 = {{0}, {1}, {0}};
        int[][] data2 = {{0, 1}, {0, 0}};
        int[][] data3 = {{0}};
        int[][] data5 = {{0, 0}, {1, 1}, {0, 0}};
        int[][] data4 = {{0, 0}};
        System.out.println(a.uniquePathsWithObstacles(data5));
    }
}