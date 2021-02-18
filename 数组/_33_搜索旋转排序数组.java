package 数组;

public class _33_搜索旋转排序数组 {
    public int search(int[] nums, int target) {
        return -1;
    }


    int erfen(int nums[], int target, int index, int stop) {
        int tmp = index;
        while (index >= tmp && index < stop) {
            int num = nums[index];
            int divide = index / 2;
            if (num > target) {
                index = divide;
                continue;
            }
            if (num == target) {
                return index;
            }
            if (num < target) {
                if (index + divide >= stop) {
                    index++;
                } else {
                    index += divide;
                }
            }
        }
        return nums[0] == target ? 0 : -1;
    }

    public static void main(String[] args) {
        _33_搜索旋转排序数组 a = new _33_搜索旋转排序数组();
        int[] data = {1, 2, 3, 4, 5, 6};
        int[] data1 = {1, 2, 3, 4, 5, 6, 7};
        System.out.println(a.search(data, 7));
    }
}

class Test_33 {
    public int search(int[] nums, int target) {
        int len = nums.length;
        int left = 0, right = len - 1;
        while (left <= right) {
            int mid = (left + right) / 2;
            if (nums[mid] == target)
                return mid;
            else if (nums[mid] < nums[right]) {
                if (nums[mid] < target && target <= nums[right])
                    left = mid + 1;
                else
                    right = mid - 1;
            } else {
                if (nums[left] <= target && target < nums[mid])
                    right = mid - 1;
                else
                    left = mid + 1;
            }
        }
        return -1;
    }
}
