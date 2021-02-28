package 数组;

public class _896_单调数列 {
    public boolean isMonotonic(int[] A) {
        if (A.length < 3) return true;
        boolean increase;
        int ab;
        for (int i = 1; i < A.length; i++) {
            ab = A[i] - A[i - 1];
            if (ab == 0) continue;
            increase = ab > 0; // 查看是否为递增数列
            for (; i < A.length; i++) {
                ab = A[i] - A[i - 1];
                if (!increase && ab > 0) return false;
                if (increase && ab < 0) return false;
            }
        }
        return true;
    }


    public static void main(String[] args) {
        _896_单调数列 a = new _896_单调数列();
        int[] data = {11, 11, 9, 4, 3, 3, 3, 1, -1, -1, 3, 3, 3, 5, 5, 5};
        System.out.println(a.isMonotonic(data));
    }
}
