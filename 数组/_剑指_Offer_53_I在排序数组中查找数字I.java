package 数组;

public class _剑指_Offer_53_I在排序数组中查找数字I {
    public int search(int[] nums, int target) {
        int length = nums.length;
        int left = 0, right = length - 1;
        int count = 0;
        if (length == 0) return 0;
        if (nums[left] == target) {
            while (left < length && nums[left] == target) {
                left++;
                count++;
            }
            return count;
        }
        if (nums[right] == target) {
            while (right > 0 && nums[right] == target) {
                right--;
                count++;
            }
            return count;
        }


        while (left < right) {
            int pos = (left + right) / 2;
            if (nums[left] == target) pos = left;
            if (nums[right] == target) pos = right;
            if (nums[pos] < target) {
                left = pos + 1;
            } else if (nums[pos] > target) {
                right = pos - 1;
            } else {
                left = pos;
                right = pos;
                while (nums[left] == target && left > 0) {
                    left--;
                }
                while (nums[right] == target && right < length - 1) {
                    right++;
                }
                count += right - left - 1;
                count = count == 0 ? 1 : count;
                break;
                // 1 2 2 3
            }
        }


        return count;
    }

    public static void main(String[] args) {
        _剑指_Offer_53_I在排序数组中查找数字I a = new _剑指_Offer_53_I在排序数组中查找数字I();
        int[] data = {1};
//        int[] data = {5, 7, 7, 8, 8, 10};
//        int[] data = {1, 2, 2, 3};
        System.out.println(a.search(data, 1));
    }
}
