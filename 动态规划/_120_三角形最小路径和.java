package 动态规划;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class _120_三角形最小路径和 {
    // 二维数组dp
    public int minimumTotal(List<List<Integer>> triangle) {
        int size = triangle.size();
        int[][] dp = new int[size][triangle.get(size - 1).size()];
        int res = Integer.MAX_VALUE;
        dp[0][0] = triangle.get(0).get(0);
        for (int i = 1; i < size; i++) {
            for (int j = 0; j < triangle.get(i).size(); j++) {
                int num = triangle.get(i).get(j);
                if (j == 0) {
                    dp[i][j] = dp[i - 1][j];
                } else if (j == triangle.get(i).size() - 1) {
                    dp[i][j] = dp[i - 1][j - 1];
                } else {
                    dp[i][j] = Math.min(dp[i - 1][j], dp[i - 1][j - 1]);
                }
                dp[i][j] += num;
            }
        }
        for (int i : dp[size - 1]) {
            res = Math.min(i, res);
        }
        return res;
    }

    // 一维数组
    public int minimumTotal1(List<List<Integer>> triangle)  {
        if (triangle == null || triangle.size() == 0){
            return 0;
        }
        // 只需要记录每一层的最小值即可
        int[] dp = new int[triangle.size()+1];

        for (int i = triangle.size() - 1; i >= 0; i--) {
            List<Integer> curTr = triangle.get(i);
            for (int j = 0; j < curTr.size(); j++) {
                //这里的dp[j] 使用的时候默认是上一层的，赋值之后变成当前层
                dp[j] = Math.min(dp[j],dp[j+1]) + curTr.get(j);
            }
        }
        return dp[0];
    }

    public static void main(String[] args) {
        _120_三角形最小路径和 a = new _120_三角形最小路径和();
        List<List<Integer>> data = new ArrayList<>();
        List<Integer> list1 = new ArrayList<>();
        List<Integer> list2 = new ArrayList<>();
        List<Integer> list3 = new ArrayList<>();
        List<Integer> list4 = new ArrayList<>();
        list1.add(-1);
        list2.add(2);
        list2.add(3);
        list3.add(1);
        list3.add(-1);
        list3.add(-3);
        list4.add(4);
        list4.add(1);
        list4.add(8);
        list4.add(3);
        data.add(list1);
        data.add(list2);
        data.add(list3);
//        data.add(list4);

        System.out.println(a.minimumTotal(data));
    }



}
