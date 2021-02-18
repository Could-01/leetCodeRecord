package 数组;

public class _643_子数组最大平均数I {
    public double findMaxAverage(int[] nums, int k) {
        int n = nums.length;
        int sum = 0;
        for(int i = 0; i < k; i++) {
            sum += nums[i];
        }
        int ans = sum;
        for(int i = k; i < n; i++) {
            sum = sum - nums[i - k] + nums[i];
            ans = Math.max(ans, sum);
        }
        return 1.0 *ans/k;
    }

    public static void main(String[] args) {
        _643_子数组最大平均数I a = new _643_子数组最大平均数I();
        int[] data = {1,12,-5,-6,50,3};
        System.out.println(a.findMaxAverage(data, 4));
    }
}
