package 数组;

public class _153_寻找旋转排序数组中的最小值 {
    public int findMin(int[] nums) {
        int left = 0, right = nums.length - 1;
        if (right == 0) return nums[right];
        int min = Integer.MAX_VALUE;
        while (left <= right) {
            min = Math.min(min, Math.min(nums[left], nums[right]));
            left++;
            right--;
        }
        return min;
    }

    public int findMin1(int[] nums) {
        int left = 0, right = nums.length - 1;
        if (right == 0) return nums[right];
        if (nums[right] > nums[left]) return nums[left];
        int min = Integer.MAX_VALUE;
        // 说明被旋转了
        while (left <= right) {
            if (nums[right - 1] > nums[right]) {
                return nums[right];
            }
            if (nums[left + 1] < nums[left]) {
                return nums[left + 1];
            }
            right--;
            left++;
        }
        return min;
    }


    public static void main(String[] args) {
        _153_寻找旋转排序数组中的最小值 a = new _153_寻找旋转排序数组中的最小值();
        int[] data = {4, 5, 6, 7, 0, 1, 2};
        System.out.println(a.findMin1(data));
    }
}
