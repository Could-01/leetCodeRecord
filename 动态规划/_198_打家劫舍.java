package 动态规划;

public class _198_打家劫舍 {
    public int rob(int[] nums) {
        int len = nums.length;
        if (len <= 1) return len == 0 ? 0 : nums[0];
        int[] memo = new int[len];
        memo[0] = nums[0];
        memo[1] = Math.max(nums[0], nums[1]);
        for (int i = 2; i < len; i++)
            memo[i] = Math.max(memo[i - 1], nums[i] + memo[i - 2]);
        return memo[len - 1];
    }

    public static void main(String[] args) {
        _198_打家劫舍 a = new _198_打家劫舍();
        int[] data = {2, 7, 9, 3, 1};
        System.out.println(a.rob(data));
    }
}
