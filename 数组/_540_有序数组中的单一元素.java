package 数组;

public class _540_有序数组中的单一元素 {
    public int singleNonDuplicate(int[] nums) {
        int left = 0, right = nums.length - 1;
        while (left < right) {
            int mid = (left + right) / 2;
            mid = mid % 2 == 0 ? mid : mid - 1;
            if (nums[mid] == nums[mid + 1]) {
                left = mid + 2;
            } else {
                right = mid;
            }
        }
        return nums[left];
    }


    public static void main(String[] args) {
        _540_有序数组中的单一元素 a = new _540_有序数组中的单一元素();
        // 1, 1, 3, 3, 4, 4, 2, 8, 8
        int[] data = {3, 3, 7, 7, 10, 11, 11};
        System.out.println(a.singleNonDuplicate(data));
    }
}
