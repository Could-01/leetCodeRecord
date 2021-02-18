package 数组;

public class _162_寻找峰值 {
    public int findPeakElement(int[] nums) {
        int left = 0, right = nums.length - 1;
        while (left < right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] > nums[mid + 1]) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }
        return left;
    }

    public static void main(String[] args) {
        _162_寻找峰值 a = new _162_寻找峰值();
        int[] data = {1, 2, 3, 1};
        System.out.println(a.findPeakElement(data));
    }
}
