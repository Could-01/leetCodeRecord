package 数组;

public class _1004_最大连续1的个数III {
    public int longestOnes(int[] A, int K) {
        int max = 0, left = 0, right = 0;
        while (right < A.length) {
            if (A[right] == 0) {
                K--;
                max = Math.max(max, right - left);
            }
            right++;
        }
        return max;
    }

    public int longestOnes1(int[] A, int K) {
        int l = 0, r = 0, res = 0;
        while (r < A.length) {
            if (A[r] == 0) {
                if (K == 0) {
                    while (A[l] == 1) l++;
                    l++;
                } else {
                    K--;
                }
            }
            res = Math.max(res, ++r - l);
        }
        return res;
    }


    public int longestOnes2(int[] A, int K) {
        int left = 0;
        int right = 0;
        //关键在于:左走看K<0
        while (right < A.length) {
            if (A[right] == 0) {
                K--;
            }
            if (K < 0) {
                if (A[left] == 0) {
                    K++;
                }
                left++;
            }
            right++;
        }
        return right - left;
    }


    public static void main(String[] args) {
        _1004_最大连续1的个数III a = new _1004_最大连续1的个数III();
        int[] data = {1, 1, 1, 0, 0, 0, 1, 1, 1, 1, 1, 1, 1};
        int[] data2 = {0, 0, 1, 1, 0, 0, 1, 1, 1, 0, 1, 1, 0, 0, 0, 1, 1, 1, 1};
        System.out.println(a.longestOnes1(data, 2));
    }
}
