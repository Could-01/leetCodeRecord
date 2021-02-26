package 动态规划;

public class _1504_统计全1子矩形 {
    public int numSubmat(int[][] mat) {
        int res = 0;
        int row = mat.length;
        int col = mat[0].length;
        int[][] dp = new int[row][col];
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (mat[i][j] == 0) continue;
                dp[i][j] = j == 0 ? 1 : dp[i][j - 1] + 1;
                int min = dp[i][j];
                for (int k = i; k >= 0; k--) {
                    min = Math.min(min, dp[k][j]);//依次往上找，与上一行的矩形个数为与上一行dp[i][j]的最小值
                    if (min == 0) break;
                    res += min;
                }
            }
        }
        return res;
    }

    public int numSubmat1(int[][] mat) {
        int res = 0;

        if (mat == null || mat.length == 0 || mat[0].length == 0) return res;
        int row = mat.length;
        int col = mat[0].length;

        int[][] dp = new int[row][col];

        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (mat[i][j] == 0) continue;
                //dp[i][j] 代表 第i行， 0~j组成的矩形个数
                int min = 0;
                for (int k = j; k >= 0; k--) {
                    if (mat[i][k] == 1) {
                        min++;
                    } else break;//若有0，则停止
                }
                dp[i][j] = min;

                for (int k = i; k >= 0; k--) {
                    min = Math.min(min, dp[k][j]);//依次往上找，与上一行的矩形个数为与上一行dp[i][j]的最小值
                    if (min == 0) break;
                    res += min;
                }
            }
        }

        return res;
    }


    public static void main(String[] args) {
        _1504_统计全1子矩形 a = new _1504_统计全1子矩形();
        int[][] data = {{0, 1, 1, 0}, {0, 1, 1, 1}, {1, 1, 1, 0}};
        System.out.println(a.numSubmat(data));
    }
}
