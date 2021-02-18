package 数组;

public class _74_搜索二维矩阵 {
    public boolean searchMatrix(int[][] matrix, int target) {
        int length = matrix[0].length - 1, down = matrix.length - 1, top = 0;
        while (down >= top) {
            if (matrix[down][0] > target) {
                down--;
            } else {
                for (int i = 0; i <= length; i++) {
                    if (matrix[down][i] == target) return true;
                }
                return false;
            }
            if (matrix[top][length] < target) {
                top++;
            } else {
                for (int i = 0; i <= length; i++) {
                    if (matrix[top][i] == target) return true;
                }
                return false;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        _74_搜索二维矩阵 a = new _74_搜索二维矩阵();
        int[][] data = {{1, 3, 5, 7}, {10, 11, 16, 20}, {23, 30, 34, 60}};
        System.out.println(a.searchMatrix(data, 23));
    }
}
