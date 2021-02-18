package 数组;

public class _485_最大连续1的个数 {
    public int findMaxConsecutiveOnes(int[] nums) {
        int count = 0, max = 0;
        for (int num : nums) {
            if (num != 0) {
                max = Math.max(max, ++count);
            } else {
                count = 0;
            }
        }
        return max;
    }

    public static void main(String[] args) {
        _485_最大连续1的个数 a = new _485_最大连续1的个数();
        int[] nums = {0, 0, 0, 1};
        System.out.println(a.findMaxConsecutiveOnes(nums));
    }
}
