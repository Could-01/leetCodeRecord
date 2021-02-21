package 数组;

public class _154_寻找旋转排序数组中的最小值II {
    public int findMin(int[] nums) {
        int left = 0, right = nums.length - 1;
        if (right == 0) return nums[right];
        if (nums[right] > nums[left]) return nums[left];
        int min = nums[0];
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
        _154_寻找旋转排序数组中的最小值II a = new _154_寻找旋转排序数组中的最小值II();
        int[] data = {3, 1, 3};
        System.out.println(a.findMin(data));
    }
}
