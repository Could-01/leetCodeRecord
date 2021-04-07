package 动态规划;

import java.util.Arrays;

public class _1105_填充书架 {
    public int minHeightShelves(int[][] books, int shelf_width) {
        // [0]表示厚度 [1]表示高度
        int length = books.length;
        int max = 0, last = 0;
        int res = 0;
        int[] dp = new int[length]; // 第几层放到第几个
        int width = 0, index = 0;
        for (int i = 0; i < length; i++) {
            width += books[i][0];
            if (width == shelf_width) {
                dp[index++] = i;
                width = 0;
                continue;
            }
            if (width > shelf_width) {
                if (i - 1 > 0) {
                    i--;
                    dp[index++] = i - 1;
                } else {
                    dp[index++] = 0;
                    i = 0;
                }
                width = 0;
            }
            if (i == length - 1 && width <= shelf_width) {
                dp[index] = i;
            }
        }
        for (int i = 0; i < length; i++) {
            if (last > dp[i]) break;
            for (int j = last; j <= dp[i]; j++) {
                max = Math.max(max, books[j][1]);
            }
            last = dp[i] + 1;
            res += max;
            max = 0;
        }
        return res;
    }

    public int minHeightShelves1(int[][] books, int shelf_width) {
        int m = books.length;
        // corner case
        if (m == 1) {
            return books[0][1];
        }

        int[] dp = new int[m + 1];
        Arrays.fill(dp, Integer.MAX_VALUE);
        dp[0] = 0;

        for (int i = 1; i <= m; i++) {
            int height = 0;
            int width = 0;

            int j = i;
            while (j > 0) {
                width += books[j - 1][0];
                if (width > shelf_width) break;
                height = Math.max(books[j - 1][1], height);
                dp[i] = Math.min(dp[i], dp[j - 1] + height);
                j--;
            }
        }

        return dp[m];
    }

    public static void main(String[] args) {
        _1105_填充书架 a = new _1105_填充书架();
        int[][] data = {{1, 1}, {2, 3}, {2, 3}, {1, 1}, {1, 1}, {1, 1}, {1, 2}};
        int[][] data1 = {{7, 3}, {8, 7}, {2, 7}, {2, 5}}; // 15
        int[][] data2 = {{9, 9}, {5, 4}, {3, 1}, {1, 5}, {7, 3}}; //10
        int[][] data3 = {{3, 10}, {8, 2}, {3, 4}, {3, 2}, {9, 8}, {10, 4}};
        System.out.println(a.minHeightShelves(data2, 10));
    }
}
