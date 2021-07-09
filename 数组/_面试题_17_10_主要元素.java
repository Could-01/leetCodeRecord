package 数组;

public class _面试题_17_10_主要元素 {
    public int majorityElement(int[] nums) {
        int length = nums.length;
        if (length < 2) return length == 0 ? -1 : nums[0];
        int count = 0, res = nums[0];
        for (int i = 0; i < length; i++) {
            if (count == 0) res = nums[i];
            if (nums[i] == res) {
                count++;
            } else {
                count--;
            }
        }

        if (length % 2 == 1 && count == 1) {
            int tmp = res;
            count = 0;
            for (int i = length - 1; i >= 0; i--) {
                if (count == 0) res = nums[i];
                if (nums[i] == res) {
                    count++;
                } else {
                    count--;
                }
            }
            if (res != tmp) return -1;
        }
        return count == 0 ? -1 : res;
    }

    public int majorityElement1(int[] nums) {
        int n = nums.length;
        int x = -1, cnt = 0;
        for (int i : nums) {
            if (cnt == 0) {
                x = i;
                cnt = 1;
            } else {
                cnt += x == i ? 1 : -1;
            }
        }
        cnt = 0;
        for (int i : nums) if (x == i) cnt++;
        return cnt > n / 2 ? x : -1;
    }


    public static void main(String[] args) {
        _面试题_17_10_主要元素 a = new _面试题_17_10_主要元素();
        int[] data = {1, 2, 3};
        System.out.println(a.majorityElement(data));
    }
}
