package 动态规划;

import java.util.Arrays;

public class _718_最长重复子数组 {

    public int findLength(int[] A, int[] B) {
        int lenA = A.length, lenB = B.length;
        int[][] dp = new int[lenA + 1][lenB + 1];
        int last = 0;
        for (int i = 1; i <= lenA; i++) {
            for (int j = 1; j <= lenB; j++) {
                if (A[i - 1] == B[j - 1]) {
                    if (i - 2 >= 0 && j - 2 >= 0) { // 有前一位
                        int preI = A[i - 2];
                        int preJ = B[j - 2];
                        if (preI == preJ) {
                            if (last < i) {
                                dp[i][j] = ++last;
                            } else {
                                dp[i][j] = last;
                            }
                        } else {
                            dp[i][j] = last;
                        }
                    } else {
                        dp[i][j] = Math.max(dp[i - 1][j - 1] + 1, last);
                    }
                } else {
                    dp[i][j] = last;
                }
                last = dp[i][j];
            }
        }
//        for (int[] arr : dp) {
//            System.out.println(Arrays.toString(arr));
//        }

        return dp[lenA][lenB];
    }

    public int findLength1(int[] A, int[] B) {

        int n = A.length;
        int m = B.length;
        int max = 0;
        int[][] dp = new int[n + 1][m + 1];

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= m; j++) {
                if (A[i - 1] == B[j - 1]) {
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                } else {
                    dp[i][j] = 0;
                }
                max = Math.max(max, dp[i][j]);
            }
        }
        return max;
    }

    public static void main(String[] args) {
        _718_最长重复子数组 a = new _718_最长重复子数组();
//        int[] A = {0, 1, 1, 1, 1};
//        int[] B = {1, 0, 1, 0, 1};
        int[] A = {1, 2, 3, 2, 1};
        int[] B = {3, 2, 1, 4, 7};
        System.out.println(a.findLength(A, B));
    }
}
