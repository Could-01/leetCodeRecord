package 数组;

import java.awt.desktop.SystemSleepEvent;

public class _724_寻找数组的中心索引 {
    public int pivotIndex(int[] nums) {
        if (nums.length <= 2) return -1;
        int left = 0, right = 0;
        int l = 0, r = nums.length - 1;
        while (l != r) {
            if (left > right) {
                right += nums[r];
//                System.out.println("right : " + right + " r : " + r);
                r--;
            } else {
                left += nums[l];
//                System.out.println("left : " + left + " l : " + l);
                l++;
            }
        }
        System.out.println(left + "  " + right);
        return left == right ? l : -1;
    }

    public int pivotIndex1(int[] nums) {
        if (nums.length <= 2) return -1;
        int sumTotal = 0;
        int sumLeft = 0;
        for (int i = 0; i < nums.length; i++) {
            sumTotal += nums[i];
        }
        for (int p = 0; p < nums.length; p++) {

            if (sumLeft * 2 == sumTotal - nums[p]) {
                return p;
            }
            sumLeft += nums[p];
        }
        return -1;
    }

    public static void main(String[] args) {
        _724_寻找数组的中心索引 a = new _724_寻找数组的中心索引();
        int[] c = new int[]{1, 7, 3, 6, 5, 6};
        int[] d = new int[]{-1, -1, -1, -1, -1, 0};
        System.out.println(a.pivotIndex1(d));
    }
}
