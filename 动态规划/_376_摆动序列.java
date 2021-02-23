package 动态规划;

public class _376_摆动序列 {

    public int wiggleMaxLength(int[] nums) {
        int n = nums.length;
        if (n < 2) {
            return n;
        }
        // dp1 是代表正数, dp2代表负数
        int[] dp1 = new int[n], dp2 = new int[n];
        dp1[0] = dp2[0] = 1;
        for (int i = 1; i < n; i++) {
            dp1[i] = dp1[i - 1];
            dp2[i] = dp2[i - 1];
            // 只有其中一个更新了，另一个才会更近，相互制约
            if (nums[i] > nums[i - 1]) {
                dp1[i] = dp2[i] + 1;
            } else if (nums[i] < nums[i - 1]) {
                dp2[i] = dp1[i] + 1;
            }
        }
        return Math.max(dp1[n - 1], dp2[n - 1]);
    }

    public static void main(String[] args) {
        _376_摆动序列 a = new _376_摆动序列();
        int[] data = {1, 17, 5, 10, 13, 15, 10, 5, 16, 8};
        System.out.println(a.wiggleMaxLength(data));
    }

}
