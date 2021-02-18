package 动态规划;

import java.util.Arrays;

public class _322_零钱兑换 {
    public int coinChange(int[] faces, int n) {
        if (n < 1) return -1;
        int[] dp = new int[n + 1];
        for (int face : faces) {
            if (n < face) break;
            dp[face] = 1;
        }
        return coins2(n, dp);
    }

    int coins2(int n, int[] dp) {
        if (n < 1) return Integer.MAX_VALUE;
        if (dp[n] == 0) {
            int min1 = Math.min(coins2(n - 25, dp), coins2(n - 20, dp));
            int min2 = Math.min(coins2(n - 5, dp), coins2(n - 1, dp));
            dp[n] = Math.min(min1, min2) + 1;
        }
        return dp[n];
    }


    int coins5(int[] faces, int n) {
        //  int[] faces = {1, 10, 20, 25};
        if (n < 1 || faces == null || faces.length == 0) return 0;
        int[] dp = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            int min = Integer.MAX_VALUE;
            for (int face : faces) {
                if (i < face) continue;
                int v = dp[i - face];
                // 查找特定距离前的硬币数量 1, 10, 20, 25
                if (v < 0 || v >= min) continue;
                min = v;
            }
            if (min == Integer.MAX_VALUE) {
                dp[i] = -1;
            } else {
                dp[i] = min + 1;
            }
            System.out.println(Arrays.toString(dp));
        }
        return dp[n];
    }


    public static void main(String[] args) {
        _322_零钱兑换 a = new _322_零钱兑换();
        int[] data = {1, 10, 20, 25};
        System.out.println(a.coins5(data, 41));
    }
}


class Test_322 {
    int min = Integer.MIN_VALUE;

    public int coinChange(int[] coins, int amount) {
        if (amount < 1 || coins == null || coins.length == 0) return 0;
        Arrays.sort(coins);
        int[] ans = new int[]{Integer.MAX_VALUE};
        dfs(coins, amount, coins.length - 1, 0, ans);
        return ans[0] == Integer.MAX_VALUE ? -1 : ans[0];
    }

    /**
     * @param coins   待选的硬币面值
     * @param amount  需要凑够的金额
     * @param coinIdx 当前选择的硬币面值的索引
     * @param count   目前已选的硬币数量
     * @param ans     最终的答案
     */
    private void dfs(int[] coins, int amount, int coinIdx, int count, int[] ans) {
        System.out.println("coinIdx : " + Arrays.toString(ans));
        /*
        整体策略：优先尽可能多地选择较大面值的硬币（假设要凑够的金额是amount，当前正在选择的硬币面值是coin）
        <1> 如果凑够了amount，说明得到了一个潜在答案，计算出目前能凑够amount的最少硬币数量ans，剪枝
        <2> 如果没凑够amount
            (1) 如果coin是最小面值，说明这个凑法不合理，剪枝
            (2) 如果(目前已选择的硬币数量 + 1) >= ans，说明继续往下凑，硬币数量不会小于ans，剪枝
            (3) 否则尝试选择面值比coin小的硬币去凑剩余的金额
            (4) 减少面值为coin的硬币数量，进入 <1>
        */
        for (int c = amount / coins[coinIdx]; c >= 0; c--) {
            int remain = amount - c * coins[coinIdx];
            int curCount = count + c;
            if (remain == 0) {
                // 已经优先用面值较大的硬币了
                // 如果用面值较小的硬币，凑出来的数量只会更多
                // 所以直接剪枝，没必要尝试减少大面值硬币的数量，用小面值的硬币去凑

                ans[0] = Math.min(ans[0], curCount);
                return;
            }

            // 已经是最小面值了，如果还凑不够amount，说明不可能凑出这个数目，直接剪枝
            if (coinIdx == 0) return;

            // 继续往下凑，硬币数量不会小于ans，直接剪枝
            if (curCount + 1 >= ans[0]) return;

            // 选择较小的面值凑够剩余的金额
            dfs(coins, remain, coinIdx - 1, curCount, ans);
        }
    }

    // [1, 7, 10], 30
    // 3*10（刚好）, ans = 3

    // [1, 7, 10], 34
    // 3*10 -> 0*7 -> 4*1（刚好）, ans = 7
    // 2*10 -> 2*7（刚好）, ans = 4
    // 1*10 -> 3*7（没必要）, ans = 4
    // 0*10 -> 4*7（没必要）, ans = 4

    // [1, 10, 20, 25], 41
    // 1*25 -> 0*20 -> 1*10 -> 6*1（刚好）, ans = 8
    // 1*25 -> 0*20 -> 0*10 -> 16*1（刚好）, ans = 8
    // 0*25 -> 2*20 -> 0*10 -> 1*1（刚好）, ans = 3
    // 0*25 -> 1*20 -> 2*10（没必要）
    // 0*25 -> 0*20 -> 4*10（没必要）

    // [2, 5, 10], 21
    // 2*10 -> 0*5 -> 0*2（无法凑）, ans = MAX
    // 1*10 -> 2*5 -> 0*2（无法凑）, ans = MAX
    // 1*10 -> 1*5 -> 3*2（刚好）, ans = 5
    // 1*10 -> 0*5 -> 5*2（无法凑）, ans = 5
    // 0*10 -> 4*5（没必要）, ans = 5

    // [2, 4, 6], 11
    // 1*6 -> 1*4 -> 0*2（无法凑）, ans = MAX
    // 1*6 -> 0*4 -> 2*2（无法凑）, ans = MAX
    // 0*6 -> 2*4 -> 1*2（无法凑）, ans = MAX
    // 0*6 -> 1*4 -> 3*2（无法凑）, ans = MAX
    // 0*6 -> 0*4 -> 5*2（无法凑）, ans = MAX

    public static void main(String[] args) {
        Test_322 a = new Test_322();
        int[] data = {1, 10, 20, 25};
        System.out.println(a.coinChange(data, 41));
    }
}

class Test_322_1 {
    private int min = Integer.MAX_VALUE;
    public int coinChange(int[] coins, int amount) {
        if (amount < 1 || coins == null || coins.length == 0) return 0;
        Arrays.sort(coins);
        dfs(coins, amount, coins.length - 1, 0);
        return min == Integer.MAX_VALUE ? -1 : min;
    }

    /**
     * @param coins   待选的硬币面值
     * @param amount  需要凑够的金额
     * @param coinIdx 当前选择的硬币面值的索引
     * @param count   目前已选的硬币数量
     */
    public void dfs(int[] coins, int amount, int coinIdx, int count) {
        /*
        整体策略：优先尽可能多地选择较大面值的硬币（假设要凑够的金额是amount，当前正在选择的硬币面值是coin）
        <1> 如果凑够了amount，说明得到了一个潜在答案，计算出目前能凑够amount的最少硬币数量ans，剪枝
        <2> 如果没凑够amount
            (1) 如果coin是最小面值，说明这个凑法不合理，剪枝
            (2) 如果(目前已选择的硬币数量 + 1) >= ans，说明继续往下凑，硬币数量不会小于ans，剪枝
            (3) 否则尝试选择面值比coin小的硬币去凑剩余的金额
            (4) 减少面值为coin的硬币数量，进入 <1>
        */
        for (int c = amount / coins[coinIdx]; c >= 0; c--) {
            int remain = amount - c * coins[coinIdx];
            int curCount = count + c;
            if (remain == 0) {
                // 已经优先用面值较大的硬币了
                // 如果用面值较小的硬币，凑出来的数量只会更多
                // 所以直接剪枝，没必要尝试减少大面值硬币的数量，用小面值的硬币去凑
                min = Math.min(min, curCount);
                return;
            }

            // 已经是最小面值了，如果还凑不够amount，说明不可能凑出这个数目，直接剪枝
            if (coinIdx == 0) return;

            // 继续往下凑，硬币数量不会小于ans，直接剪枝
            if (curCount + 1 >= min) return;

            // 选择较小的面值凑够剩余的金额
            dfs(coins, remain, coinIdx - 1, curCount);
        }
    }

    public static void main(String[] args) {
        Test_322_1 a = new Test_322_1();
        int[] data = {1, 10, 20, 25};
        System.out.println(a.coinChange(data, 41));
    }
}