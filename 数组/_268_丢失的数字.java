package 数组;

public class _268_丢失的数字 {
    public int missingNumber(int[] nums) {
        int res = nums.length;
        for (int i = 0; i < nums.length; i++) {
            res ^= nums[i];
            res ^= i;
        }
        return res;
    }

    public static void main(String[] args) {
        _268_丢失的数字 a = new _268_丢失的数字();
        int[] data = {9, 6, 4, 2, 3, 5, 7, 0, 1};
        System.out.println(a.missingNumber(data));
    }

}
