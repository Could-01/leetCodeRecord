package 数组;

public class _674_最长连续递增序列 {
    public int findLengthOfLCIS(int[] nums) {
        int len = nums.length;
        if (len == 0) {
            return 0;
        } else if (len == 1) {
            return 1;
        }
        int index = 2;
        int Incremental = nums[1] - nums[0];
        if (Incremental == 0) return 1;
        while (index < len) {
            if (nums[index - 1] + Incremental != nums[index]) {
                return index;
            } else {
                index++;
                continue;
            }
        }
        return len;
    }

    public static void main(String[] args) {
        int[] ints = new int[]{2, 3};
        _674_最长连续递增序列 a = new _674_最长连续递增序列();
        System.out.println(a.findLengthOfLCIS(ints));
    }
}
