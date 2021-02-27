package 数组;

public class _169_多数元素 {

    // 摩尔投票法
    public int majorityElement(int[] nums) {
        int length = nums.length;
        if (length < 2) return length == 0 ? 0 : nums[0];
        int count = 0, res = nums[0];
        for (int i = 0; i < length; i++) {
            if (count == 0) res = nums[i];
            if (nums[i] == res) {
                count++;
            } else {
                count--;
            }
        }
        return res;
    }


    public static void main(String[] args) {
        _169_多数元素 a = new _169_多数元素();
        int[] data = {3, 2, 3};
        System.out.println(a.majorityElement(data));
    }
}
