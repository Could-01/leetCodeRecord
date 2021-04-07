package 数组;

public class _81_搜索旋转排序数组II {
    public boolean search(int[] nums, int target) {
        return binarySearch(nums, 0, nums.length, target);
    }

    boolean binarySearch(int[] nums, int start, int end, int target) {
        if (start == end && nums[start] != target) return false;
        if (start + 1 == end && nums[start] != target && nums[end - 1] != target) return false;
        if (nums[start] == target && nums[end - 1] == target) return true;
        int mid = start + (end - start) / 2;
        if (nums[mid] == target) return true;
        return binarySearch(nums, start, mid, target) || binarySearch(nums, mid, end, target);
    }

    public static void main(String[] args) {
        _81_搜索旋转排序数组II a = new _81_搜索旋转排序数组II();
        int[] data = {2, 5, 6, 0, 0, 1, 2};
        System.out.println(a.search(data, 3));
    }
}
