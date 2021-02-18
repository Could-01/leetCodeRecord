package 动态规划;

import java.util.Arrays;

public class _486_预测赢家 {
    public boolean PredictTheWinner(int[] nums) {
        int length = nums.length;
        //results[i][j]存储的是piles中第i个数到第j个数->组成序列的最佳拿取方式下的得分
        int[][] results = new int[length][length];
        //当集合中只有一个堆的时候，拿的那个人直接得分
        for (int i = 0; i < length; i++) {
            results[i][i] = nums[i];
        }
        //当集合中有两个数的时候，先选的人肯定是拿较大数,分数为max-min
        for (int i = 0; i < length - 1; i++) {
            results[i][i + 1] = Math.abs(nums[i] - nums[i + 1]);
        }
        /**当集合中元素大于2时，先选的人从序列两头拿，可以分成两种情况
         *以ABC为例，可以拿A，剩余BC，后手会选择BC的最佳拿取方式，
         *所以先手得分为A-BC得分，即：results[i][j]=piles[i]-results[i+1][j]；
         *也可以拿C，剩余AB，同理有results[i][j]=piles[j]results[i][j-1]；
         *选择分值较大的那个即可。上面两个式子都要求我们在求results[i][j]的时候知道
         *它的下面和左边一个格子的值，所以我们从下到上，从左到右计算填表。
         */
        for (int i = length - 3; i >= 0; i--) {
            for (int j = i + 2; j < length; j++) {
                results[i][j] = Math.max(nums[i] - results[i + 1][j], nums[j] - results[i][j - 1]);
            }
        }

        return results[0][length - 1] >= 0;
    }

    public static void main(String[] args) {
        _486_预测赢家 a = new _486_预测赢家();
        int[] data = {0, 0};
        System.out.println(a.PredictTheWinner(data));
    }
}
