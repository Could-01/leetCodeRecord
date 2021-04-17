package 数组;

import java.util.Arrays;

public class _130_被围绕的区域 {
    public void solve(char[][] board) {
        dfs(board, 0, 0);
    }

    void dfs(char[][] board, int x, int y) {
        int width = board[0].length;
        int height = board.length;
        if (y >= height || x >= width) return;
        int tmpx = x, tmpy = y;
        if (tmpx == width - 1) {
            tmpx = 0;
            tmpy += 1;
        } else {
            tmpx += 1;
        }
        char ch = board[y][x];
        if (ch == 'X' || x == 0 || y == 0 || x == width - 1 || y == height - 1) {
            dfs(board, tmpx, tmpy);
        } else {
            boolean widthconform = false, heightconform = false;
            int left = x, right = x, top = y, down = y;

            // 横向[][] 0不变，1变
            while (left > 0 && board[y][left] != 'X') left--;
            while (right < width - 1 && board[y][right] != 'X') right++;
            if (board[y][left] == 'X' && board[y][right] == 'X') widthconform = true;

            //纵向 0变，1不变
            while (top > 0 && board[top][x] != 'X') top--;
            while (down < height - 1 && board[down][x] != 'X') down++;
            if (board[top][x] == 'X' && board[down][x] == 'X') heightconform = true;
            if (widthconform && heightconform) board[y][x] = 'X';

            dfs(board, tmpx, tmpy);
        }
    }

    public static void main(String[] args) {
        _130_被围绕的区域 a = new _130_被围绕的区域();
        char[][] arr3 = {{'X', 'O', 'X', 'X'}, {'O', 'X', 'O', 'X'}, {'X', 'O', 'X', 'O'}, {'O', 'X', 'O', 'X'}};
        char[][] arr2 = {{'X', 'X', 'X', 'X'}, {'X', 'O', 'O', 'X'}, {'X', 'X', 'O', 'X'}, {'X', 'O', 'X', 'X'}};
        char[][] arr1 = {{'O', 'O', 'O'}, {'O', 'O', 'O'}, {'O', 'O', 'O'}};
        char[][] arr4 = {{'X', 'O', 'X'}, {'X', 'O', 'X'}, {'X', 'O', 'X'}};
        char[][] arr = {{'X', 'O', 'X', 'O', 'X', 'O'}, {'O', 'X', 'O', 'X', 'O', 'X'}, {'X', 'O', 'X', 'O', 'X', 'O'}, {'O', 'X', 'O', 'X', 'O', 'X'}};
        a.solve(arr);
        for (char[] chars : arr) {
            System.out.println(Arrays.toString(chars));
        }
    }
}

class Solution_130 {
    public void dfs(char[][] board, int x, int y) {
        if (x >= 0 && x < board.length && y >= 0 && y < board[0].length && board[x][y] == 'O') {
            board[x][y] = '1';
            dfs(board, x - 1, y);
            dfs(board, x + 1, y);
            dfs(board, x, y + 1);
            dfs(board, x, y - 1);
        }
    }

    public void solve(char[][] board) {
        if (board.length == 0 || board[0].length == 0) return;
        int m = board.length, n = board[0].length;
        for (int i = 0; i < m; ++i) {
            if (board[i][0] == 'O') dfs(board, i, 0);
            if (board[i][n - 1] == 'O') dfs(board, i, n - 1);
        }
        for (int j = 0; j < n; ++j) {
            if (board[0][j] == 'O') dfs(board, 0, j);
            if (board[m - 1][j] == 'O') dfs(board, m - 1, j);
        }
        for (int i = 0; i < m; ++i) {
            for (int j = 0; j < n; ++j) {
                if (board[i][j] != '1') {
                    board[i][j] = 'X';
                } else {
                    board[i][j] = 'O';
                }
            }
        }
    }
}