package 数组;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class _986_区间列表的交集 {
    public int[][] intervalIntersection(int[][] firstList, int[][] secondList) {
        int fn = firstList.length, sn = secondList.length;
        if (fn == 0 || sn == 0) return new int[0][];
        int[][] res = new int[fn + sn][];
        int lc = 0, rc = 0, count = 0;
        while (lc < fn && rc < sn) {
            int left = Math.max(firstList[lc][0], secondList[rc][0]);
            int right = Math.min(firstList[lc][1], secondList[rc][1]);
            if (left <= right) {
                res[count++] = new int[]{left, right};
            }
            if (firstList[lc][1] < secondList[rc][1]) {
                lc++;
            } else {
                rc++;
            }
        }
        return Arrays.copyOf(res, count);
    }

    public static void main(String[] args) {
        _986_区间列表的交集 a = new _986_区间列表的交集();
        int[][] data1 = {{0, 2}, {5, 10}, {13, 23}, {24, 25}};
        int[][] data2 = {{1, 5}, {8, 12}, {15, 24}, {25, 26}};
        int[][] res = a.intervalIntersection(data1, data2);
        for (int[] arr : res) {
            System.out.println(Arrays.toString(arr));
        }
    }
}

class Test_986 {
    public int[][] intervalIntersection(int[][] A, int[][] B) {
        int na = A.length, nb = B.length;
        if (na == 0 || nb == 0) {
            return new int[0][0];
        }
        int[][] res = new int[na + nb][];
        int idxRes = 0, idxA = 0, idxB = 0;
        while (idxA < na && idxB < nb) {
            int max_left = Math.max(A[idxA][0], B[idxB][0]);
            int min_right = Math.min(A[idxA][1], B[idxB][1]);
            //得到交集，添加到结果数组
            if (max_left <= min_right) {
                res[idxRes++] = new int[]{max_left, min_right};
            }
            //右移指针
            if (A[idxA][1] < B[idxB][1]) {
                idxA++;
            } else {
                idxB++;
            }
        }
        res = Arrays.copyOf(res, idxRes);
        return res;
    }

}
