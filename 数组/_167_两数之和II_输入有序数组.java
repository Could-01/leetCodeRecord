package 数组;

import java.util.Arrays;

public class _167_两数之和II_输入有序数组 {
    public int[] twoSum(int[] numbers, int target) {
        //二分法找到目标所在范围
        int[] result = new int[2];
        int start = 0;
        int end = numbers.length - 1;
        int mid;
        while (end - start > 1) {
            mid = start + (end - start) / 2;
            if (target <= numbers[mid]) end = mid;
            else start = mid;
        }

        // 1 3 5 7 12
        // 13
        /*
        双指针法：左指针lp指向锁定范围的最小值索引，右指针rp指向锁定范围最大值索引。
                两指针向中合并查找，由于是生序数列，所以若两指针之和大于目标数，则
                右指针向左移一位；若两指针之和小于目标数，则左指针向右移一位。如此
                操作直至找出构成目标数的组合。
        */
        int lp = 0;
        int rp = end;

        while (numbers[lp] + numbers[rp] != target) {
            if (numbers[lp] + numbers[rp] < target) lp += 1;
            else rp -= 1;
        }

        //由于输出结果要求索引是从1开始的，所以要+1
        result[0] = lp + 1;
        result[1] = rp + 1;

        return result;
    }

    public static void main(String[] args) {
        _167_两数之和II_输入有序数组 a = new _167_两数之和II_输入有序数组();
        int[] data = {2, 3, 4, 5, 6};
        int[] data1 = {0, 0, 3, 4};
        int[] data2 = {-1, 3, 5, 7, 99};
        int[] res = a.twoSum(data2, 6);
        System.out.println(Arrays.toString(res));
    }
}
