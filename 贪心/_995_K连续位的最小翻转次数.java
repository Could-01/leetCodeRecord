package 贪心;

import java.util.Arrays;

public class _995_K连续位的最小翻转次数 {
    public int minKBitFlips(int[] A, int K) {
        int left = 0, right = K, length = A.length, count = 0;
        while (right <= length) {
            if (A[left] == 0) {
                count++;
                for (int i = left; i < right; i++) {
                    A[i] ^= 1;
                }
            }
            if (A[left] == 1) {
                left++;
                right++;
            }
        }
        for (int i = left; i < length; i++) {
            if (A[i] == 0) return -1;
        }
        return count;
    }


    public int minKBitFlips1(int[] A, int K) {
        int n = A.length;
        int ans = 0, revCnt = 0;
        for (int i = 0; i < n; ++i) {
            if (i >= K && A[i - K] > 1) {
                revCnt ^= 1;
                A[i - K] -= 2; // 复原数组元素，若允许修改数组 A，则可以省略
            }
            if (A[i] == revCnt) {
                if (i + K > n) {
                    return -1;
                }
                ++ans;
                revCnt ^= 1;
                A[i] += 2;
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        _995_K连续位的最小翻转次数 a = new _995_K连续位的最小翻转次数();
        int[] data = {0, 0, 0, 1, 0, 1, 1, 0};
        int[] data1 = {1, 0, 1};
        int[] data2 = {0, 1, 0};
        System.out.println(a.minKBitFlips(data1, 3));
    }
}
