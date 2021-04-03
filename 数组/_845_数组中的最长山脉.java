package 数组;

public class _845_数组中的最长山脉 {
    public int longestMountain(int[] arr) {
        int length = arr.length;
        int[] LeftDp = new int[length];
        int[] RightDp = new int[length];
        for (int i = 1; i < length; i++) {
            if (arr[i - 1] < arr[i]) {
                LeftDp[i] = LeftDp[i - 1] + 1;
            }
        }
        for (int i = length - 2; i >= 0; i--) {
            if (arr[i + 1] < arr[i]) {
                RightDp[i] = RightDp[i + 1] + 1;
            }
        }
        int res = 0;
        for (int i = 0; i < length; i++) {
            if (LeftDp[i] != 0 && RightDp[i] != 0) {
                int sum = LeftDp[i] + RightDp[i];
                res = Math.max(res, sum);
            }
        }
        return res == 0 ? 0 : res + 1;
    }


    public static void main(String[] args) {
        _845_数组中的最长山脉 a = new _845_数组中的最长山脉();
        int[] data = {0, 1, 2, 3, 4, 5, 6, 7, 8, 9};
        System.out.println(a.longestMountain(data));
    }
}
