package 数组;

public class _1822_数组元素积的符号 {
    public int arraySign(int[] nums) {
        int sum = 1;
        for (int i : nums) {
            if (i < 0) {
                sum *= -1;
            } else if(i == 0){
                return 0;
            }
        }
        return sum > 0 ? 1 : -1;
    }


    public static void main(String[] args) {
        _1822_数组元素积的符号 a = new _1822_数组元素积的符号();
        int[] data = {-1, -2, -3, -4, 3, 2, 1};
        System.out.println(a.arraySign(data));
    }
}
