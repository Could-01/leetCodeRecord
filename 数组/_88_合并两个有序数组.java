package 数组;

import java.util.Arrays;

public class _88_合并两个有序数组 {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int i = m-- + --n;

        while (n >= 0) {
            nums1[i--] = m >= 0 && nums1[m] > nums2[n] ? nums1[m--] : nums2[n--];
        }
    }

    public static void main(String[] args) {
        _88_合并两个有序数组 a = new _88_合并两个有序数组();
        int[] data1 = {1, 2, 3, 0, 0, 0};
        int[] data2 = {2, 5, 6};
        a.merge(data1, 3, data2, 3);
        System.out.println(Arrays.toString(data1));
    }
}
