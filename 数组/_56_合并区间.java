package 数组;

import java.util.Arrays;

public class _56_合并区间 {

    public int[][] merge(int[][] intervals) {
        int size = 0, length = intervals.length;
        Arrays.sort(intervals, (v1, v2) -> v1[0] - v2[0]);
        int[][] data = new int[length][2];
        for (int i = 0; i < length; i++) {
            data[size][0] = intervals[i][0];
            if (i == length - 1) {
                data[size][1] = intervals[i][1];
                size++;
                break;
            }

            while (intervals[i + 1][0] <= intervals[i][1]) {
                i++;
                if (i == length - 1) {
                    break;
                }
            }
            data[size][1] = intervals[i][1];
            size++;
        }
        int[][] res = new int[size][2];
        System.arraycopy(data, 0, res, 0, size);
        return res;
    }

    public int[][] merge1(int[][] intervals) {
        // 先按照区间起始位置排序
        Arrays.sort(intervals, (v1, v2) -> v1[0] - v2[0]);
        // 遍历区间
        int[][] res = new int[intervals.length][2];
        int idx = -1;
        for (int[] interval : intervals) {
            // 如果结果数组是空的，或者当前区间的起始位置 > 结果数组中最后区间的终止位置，
            // 则不合并，直接将当前区间加入结果数组。
            if (idx == -1 || interval[0] > res[idx][1]) {
                res[++idx] = interval;
            } else {
                // 反之将当前区间合并至结果数组的最后区间
                res[idx][1] = Math.max(res[idx][1], interval[1]);
            }
        }
        return Arrays.copyOf(res, idx + 1);
    }

    public static void main(String[] args) {
        _56_合并区间 a = new _56_合并区间();
        int[][] data = {{1, 3}, {2, 6}, {8, 10}, {15, 18}};
        int[][] data1 = {{1, 4}, {4, 5}};
        int[][] data2 = {{0, 4}, {1, 4}};
        int[][] res = a.merge(data2);
        for (int[] arr : res) {
            System.out.println(Arrays.toString(arr));
        }
    }
}
