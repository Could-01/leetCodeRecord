package 动态规划;

import java.util.Arrays;

public class _64_最小路径和 {
    public int minPathSum(int[][] grid) {
        int width = grid[0].length, high = grid.length;
        // 初始化
        for (int i = 1; i < high; i++) grid[i][0] += grid[i - 1][0];
        for (int i = 1; i < width; i++) grid[0][i] += grid[0][i - 1];
        for (int i = 1; i < high; i++)
            for (int j = 1; j < width; j++)
                grid[i][j] += Math.min(grid[i - 1][j], grid[i][j - 1]);
        return grid[high - 1][width - 1];
    }

    public static void main(String[] args) {
        _64_最小路径和 a = new _64_最小路径和();
        int[][] data = {{1, 3, 1}, {1, 5, 1}, {4, 2, 1}};
        System.out.println(a.minPathSum(data));
    }
}

class Test_64 {
    private int M;
    private int N;
    private int[][] memo;

    //dfs + 记忆
    public int minPathSum(int[][] grid) {
        M = grid.length;
        N = grid[0].length;
        memo = new int[M][N];
        for (int i = 0; i < M; i++) {
            Arrays.fill(memo[i], -1);
        }
        return dfs(grid, 0, 0);
    }

    private int dfs(int[][] grid, int r, int c) {
        //若越界，则认为不可达，距离为无穷大
        if (r < 0 || r >= M || c < 0 || c >= N) return Integer.MAX_VALUE;
        if (memo[r][c] > -1) return memo[r][c];
        //若到达终点，终点的贡献值是其本身
        if (r == M - 1 && c == N - 1) return grid[M - 1][N - 1];
        //右边的点到终点最短的路径
        int right = dfs(grid, r, c + 1);
        //下面的点到终点的最短路径
        int down = dfs(grid, r + 1, c);
        //取两者的较小值，计算出当前点的最小路径值
        int ans = Math.min(right, down) + grid[r][c];
        memo[r][c] = ans;
        return ans;
    }

    public static void main(String[] args) {
        Test_64 a = new Test_64();
        int[][] data = {{1, 3, 1}, {1, 5, 1}, {4, 2, 1}};
        System.out.println(a.minPathSum(data));
    }
}