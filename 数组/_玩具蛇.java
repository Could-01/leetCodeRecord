package 数组;

public class _玩具蛇 {
    static int res = 0;

    static void dfs(int[][] arrs, int x, int y, int index) {
        if (x < 0 || x > 3 || y < 0 || y > 3) return;
        if (arrs[x][y] != 0) return;
        if (index == 16 && arrs[x][y] == 0) {
            res++;
            return;
        }
        arrs[x][y] = index++;
        dfs(arrs, x + 1, y, index);
        dfs(arrs, x - 1, y, index);
        dfs(arrs, x, y + 1, index);
        dfs(arrs, x, y - 1, index);
        arrs[x][y] = 0;
    }


    public static void main(String[] args) {
        _玩具蛇 a = new _玩具蛇();
        int[][] arr = new int[4][4];
        for (int x = 0; x < 4; x++) {
            for (int y = 0; y < 4; y++) {
                a.dfs(arr, x, y, 1);
            }
        }
        System.out.println(a.res);
    }
}
