package 栈;

public class _334_递增的三元子序列 {
    public boolean increasingTriplet(int[] nums) {
        int num1 = Integer.MAX_VALUE;
        int num2 = Integer.MAX_VALUE;
        for (int i = 0; i < nums.length; i++) {
            int num = nums[i];
            if (num <= num1) {
                num1 = num;
            } else if (num <= num2) {
                num2 = num;
            } else {
                return true;
            }
        }
        return false;
    }


    public static void main(String[] args) {
        _334_递增的三元子序列 a = new _334_递增的三元子序列();
        int[] data = {5, 1, 6};
        System.out.println(a.increasingTriplet(data));
    }
}
