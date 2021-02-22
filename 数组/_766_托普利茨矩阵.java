package 数组;

public class _766_托普利茨矩阵 {
    public boolean isToeplitzMatrix(int[][] matrix) {
        if (matrix[0].length == 1) return true;
        for (int i = 0; i < matrix.length - 1; i++) {
            if (!check(matrix[i], matrix[i + 1])) {
                return false;
            }
        }
        return true;
    }

    private boolean check(int[] nums1, int[] num2) {
        for (int i = 0; i < nums1.length - 1; i++) {
            if (num2[i + 1] != nums1[i]) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        _766_托普利茨矩阵 a = new _766_托普利茨矩阵();
        int[][] data = {{1, 2}, {2, 2}};
        System.out.println(a.isToeplitzMatrix(data));
    }
}
