package 图;

import java.util.*;

public class _329_矩阵中的最长递增路径 {
    class Node {
        int x;
        int y;
        int val;

        public Node(int x, int y, int val) {
            this.x = x;
            this.y = y;
            this.val = val;
        }
    }

    public int longestIncreasingPath(int[][] g) {
        if (g.length == 0) return 0;
        int n = g.length, m = g[0].length;
        List<Node> nodes = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                nodes.add(new Node(i, j, g[i][j]));
            }
        }
        nodes.sort(Comparator.comparingInt(o -> o.val));
        int[][] f = new int[n][m];
        int ans = 0;
        int[] dirs = {0, 1, 0, -1, 0};
        for (Node node : nodes) {
            int x = node.x;
            int y = node.y;

            for (int i = 0; i < 4; i++) {
                int sx = x + dirs[i], sy = y + dirs[i + 1];
                if (0 <= sx && sx < n && 0 <= sy && sy < m && g[sx][sy] < node.val) {
                    f[x][y] = Math.max(f[x][y], f[sx][sy] + 1);
                }
            }
            ans = Math.max(ans, f[x][y]);
        }
        return ans + 1;
    }

    public int longestIncreasingPath1(int[][] g) {
        if (g.length == 0) return 0;
        int n = g.length, m = g[0].length;
        int[][] NodeArr = new int[n * m][3];
        int index = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                NodeArr[index][0] = i;
                NodeArr[index][1] = j;
                NodeArr[index][2] = g[i][j];
                index++;
            }
        }
        Arrays.sort(NodeArr, (Comparator.comparingInt(o -> o[2])));
        int[][] f = new int[n][m];

        int ans = 0;
        int[] dirs = {0, 1, 0, -1, 0};
        for (int i = 0; i < index; i++) {
            int x = NodeArr[i][0];
            int y = NodeArr[i][1];
            for (int j = 0; j < 4; j++) {
                int sx = x + dirs[j], sy = y + dirs[j + 1];
                if (0 <= sx && sx < n && 0 <= sy && sy < m && g[sx][sy] < NodeArr[i][2]) {
                    f[x][y] = Math.max(f[x][y], f[sx][sy] + 1);
                }
            }
            ans = Math.max(ans, f[x][y]);
        }
        return ans + 1;
    }


    public static void main(String[] args) {
        _329_矩阵中的最长递增路径 a = new _329_矩阵中的最长递增路径();
        int[][] data = {{9, 9, 4}, {6, 6, 8}, {2, 1, 1}};
        System.out.println(a.longestIncreasingPath1(data));
    }
}
