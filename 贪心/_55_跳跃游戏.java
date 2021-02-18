package 贪心;

public class _55_跳跃游戏 {
    public boolean canJump(int[] nums) {
        int n = nums.length;
        int rightmost = 0;
        for (int i = 0; i < n; ++i) {
            if (i <= rightmost) {
                rightmost = Math.max(rightmost, i + nums[i]);
                if (rightmost >= n - 1) {
                    return true;
                }
            }
        }
        return false;
    }


    public static void main(String[] args) {
        _55_跳跃游戏 a = new _55_跳跃游戏();
        int[] data = {0};
        System.out.println(a.canJump(data));
    }
}
