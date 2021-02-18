package 数组;

public class _209_长度最小的子数组 {
    public int minSubArrayLen(int target, int[] nums) {
        int i = 0, sum = 0, len = 0;
        for (int j = 0; j < nums.length; j++) {
            sum += nums[j];
            while (sum >= target) {
                len = len == 0 ? j - i + 1 : Math.min(len, j - i + 1);
                sum -= nums[i++];
            }
        }
        return len;
    }

    public static void main(String[] args) {
        _209_长度最小的子数组 a = new _209_长度最小的子数组();
        int[] data = {2, 3, 1, 2, 4, 3};
        int[] data1 = {1, 4, 4};
        System.out.println(a.minSubArrayLen(7, data));
    }
}
