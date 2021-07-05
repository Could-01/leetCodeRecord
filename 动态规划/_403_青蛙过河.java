package 动态规划;

public class _403_青蛙过河 {
    public boolean canCross(int[] stones) {
        boolean[][] dp = new boolean[stones.length][stones.length];
        dp[0][0] = true;
        for (int i = 1; i < stones.length; i++) {
            for (int j = i - 1; j >= 0; j--) {
                //得到从j跳到i的步数
                int k = stones[i] - stones[j];
                //此处为优化
                if (k > j + 1)
                    break;
                dp[i][k] = dp[j][k] || dp[j][k - 1] || dp[j][k + 1];
                if (i == stones.length - 1 && dp[i][k])
                    return true;
            }

        }
        return false;
    }

    public static void main(String[] args) {
        _403_青蛙过河 a = new _403_青蛙过河();
        int[] data = {0, 1, 3, 5, 6, 8, 12, 17};
        System.out.println(a.canCross(data));
    }
}
