package 数组;
//
public class _剑指_Offer_42_连续子数组的最大和 {
    public int maxSubArray(int[] nums) {
        int len = nums.length;
        if (len == 0) {
            return 0;
        }
        int dp = nums[0];
        int max = dp;
        for (int i = 1; i < len; i++) {
            if (dp <= 0) {
                dp = nums[i];
            } else {
                dp = nums[i] + dp;
            }
            max = Math.max(dp, max);
        }
        return max;
    }

    public static void main(String[] args) {

    }
}
