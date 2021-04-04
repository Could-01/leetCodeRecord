package 数组;

public class _79_单词搜索 {
    public boolean exist(char[][] board, String word) {
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if (search(board, word, i, j, 0)) {
                    return true;
                }
            }
        }
        return false;
    }


    // 每一次递归都寻找是不是有相对应的这个字符
    // 如果有，占用并且寻找下一个
    // 如果没有，直接退出
    // 如果这个附近没有下一个字符，复原
    boolean search(char[][] board, String word, int i, int j, int k) { // i表示行,j表示列
        if (k >= word.length()) return true;
        if (i < 0 || j < 0 || i >= board.length || j >= board[0].length) return false;
        if (board[i][j] != word.charAt(k)) return false;
        // 此处是寻找到了相对应的字符
        board[i][j] += 256;
        //开始寻找下一个
        boolean result = search(board, word, i + 1, j, k + 1) ||
                search(board, word, i - 1, j, k + 1) ||
                search(board, word, i, j + 1, k + 1) ||
                search(board, word, i, j - 1, k + 1);
        // 寻找失败
        board[i][j] -= 256;
        return result;
    }

    public static void main(String[] args) {
        _79_单词搜索 a = new _79_单词搜索();
        char[][] data = {{'A', 'B', 'C', 'E'}, {'S', 'F', 'C', 'S'}, {'A', 'D', 'E', 'E'}};
        System.out.println(a.exist(data, "ABCCED"));
    }
}
