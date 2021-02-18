package 并查集;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class _200_岛屿数量 {
    private int rows;
    private int cols;

    public int numIslands(char[][] grid) {
        rows = grid.length;
        if (rows == 0) {
            return 0;
        }
        cols = grid[0].length;

        // 空地的数量
        int spaces = 0;
        UnionFind unionFind = new UnionFind(rows * cols);
        int[][] directions = {{1, 0}, {0, 1}};
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (grid[i][j] == '0') {
                    spaces++;
                } else {
                    // 此时 grid[i][j] == '1'
                    for (int[] direction : directions) {
                        int newX = i + direction[0];
                        int newY = j + direction[1];
                        // 先判断坐标合法，再检查右边一格和下边一格是否是陆地
                        if (newX < rows && newY < cols && grid[newX][newY] == '1') {
                            unionFind.union(getIndex(i, j), getIndex(newX, newY));
                        }
                    }
                }
            }
        }
        return unionFind.getCount() - spaces;
    }

    private int getIndex(int i, int j) {
        return i * cols + j;
    }

    private class UnionFind {
        /**
         * 连通分量的个数
         */
        private int count;
        private int[] parent;

        public int getCount() {
            return count;
        }

        public UnionFind(int n) {
            this.count = n;
            parent = new int[n];
            for (int i = 0; i < n; i++) {
                parent[i] = i;
            }
        }

        private int find(int x) {
            while (x != parent[x]) {
                parent[x] = parent[parent[x]];
                x = parent[x];
            }
            return x;
        }

        public void union(int x, int y) {
            int xRoot = find(x);
            int yRoot = find(y);
            if (xRoot == yRoot) {
                return;
            }

            parent[xRoot] = yRoot;
            count--;
        }

        @Override
        public String toString() {
            return "  count=" + count +
                    ", parent=" + Arrays.toString(parent);
        }
    }

    public static void main(String[] args) {
        _200_岛屿数量 a = new _200_岛屿数量();
        Test_200_2 b = new Test_200_2();
        Test_200_1 c = new Test_200_1();
        char[][] data = new char[][]{
                {'1', '1', '1', '1', '0'},
                {'1', '1', '0', '1', '0'},
                {'1', '1', '0', '0', '0'},
                {'0', '0', '0', '0', '0'}
        };
        char[][] data1 = new char[][]{
                {'1', '1', '0', '0', '0'},
                {'1', '1', '0', '0', '0'},
                {'0', '0', '1', '0', '0'},
                {'0', '0', '0', '1', '1'}
        };

        char[][] data2 = new char[][]{
                {1, 1, 0},
                {1, 1, 0},
                {0, 0, 1}
        };
        System.out.println(a.numIslands(data2));
        //System.out.println(b.numIslands(data));
        System.out.println(c.numIslands(data2));
    }
}

class Test_200_1 {
    private int rows;
    private int cols;

    public int numIslands(char[][] grid) {

        rows = grid.length;
        if (rows == 0) {
            return 0;
        }
        cols = grid[0].length;

        int spaces = 0;
        UnionFind unionFind = new UnionFind(rows * cols);
        int[][] directions = {{1, 0}, {0, 1}};
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (grid[i][j] == '0') {
                    spaces++;
                } else {
                    for (int[] direction : directions) {
                        int newX = i + direction[0];
                        int newY = j + direction[1];
                        if (newX < rows && newY < cols && grid[newX][newY] == '1') {
                            unionFind.union(getIndex(i, j), getIndex(newX, newY));
                        }
                    }
                }
            }
        }

        return unionFind.getCount() - spaces;
    }

    private int getIndex(int i, int j) {
        return i * cols + j;
    }

    class UnionFind {
        int[] parent;
        int[] ranks;
        int count = 0;

        public UnionFind(int capacity) {
            this.count = capacity;
            parent = new int[capacity];
            ranks = new int[capacity];
            for (int i = 0; i < parent.length; i++) {
                parent[i] = i;
            }

            for (int i = 0; i < ranks.length; i++) {
                ranks[i] = 1;
            }
        }

        public int find(int v) {
            while (v != parent[v]) {
                parent[v] = parent[parent[v]];
                v = parent[v];
            }
            return v;
        }

        public void union(int v1, int v2) {
            int p1 = find(v1);
            int p2 = find(v2);
            if (p1 == p2) return;

            if (ranks[p1] < ranks[p2]) {
                parent[p1] = p2;
            } else if (ranks[p1] > ranks[p2]) {
                parent[p2] = p1;
            } else {
                parent[p1] = p2;
                ranks[p2] += 1;
            }
            count--;
        }


        public int getCount() {
            return count;
        }
    }
}

class Test_200_2 {
    public int numIslands(char[][] grid) {
        if (grid == null || grid.length == 0) {
            return 0;
        }
        int m = grid.length;
        int n = grid[0].length;
        UnionFind uf = new UnionFind(grid);
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == '1') {
                    //二维矩阵m*n,z在一维数组的位置是：（第几行×矩阵宽度）+ 在第几列
                    //前面已经执行过，不用往回查
                    if (i + 1 < m && grid[i + 1][j] == '1') {
                        uf.union(i * n + j, (i + 1) * n + j);
                    }
                    if (j + 1 < n && grid[i][j + 1] == '1') {
                        uf.union(i * n + j, i * n + j + 1);
                    }
                }
            }
        }
        return uf.count;
    }

    class UnionFind {
        int[] parent;
        int count;

        public UnionFind(char[][] grid) {
            int m = grid.length;
            int n = grid[0].length;
            parent = new int[m * n];
            for (int i = 0; i < m; ++i) {
                for (int j = 0; j < n; ++j) {
                    if (grid[i][j] == '1') {
                        //二维变一维
                        parent[i * n + j] = i * n + j;
                        count++;
                    }
                }
            }
        }

        public int find(int p) {
            while (p != parent[p]) {
                //压缩路径，optional
                parent[p] = parent[parent[p]];
                p = parent[p];
            }
            return p;
        }

        public void union(int p, int q) {
            int rootP = find(p);
            int rootQ = find(q);
            if (rootP == rootQ) return;
            parent[rootP] = rootQ;
            count--;
        }
    }
}

class Test_200_3 {
    // 会找到第一个0后停止
    public int numIslands(char[][] grid) {
        int count = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == '1') {
                    bfs(grid, i, j);
                    count++;
                }
            }
        }
        return count;
    }

    private void bfs(char[][] grid, int i, int j) {
        Queue<int[]> list = new LinkedList<>();
        list.add(new int[]{i, j});
        while (!list.isEmpty()) {
            int[] cur = list.remove();
            i = cur[0];
            j = cur[1];
            if (0 <= i && i < grid.length && 0 <= j && j < grid[0].length && grid[i][j] == '1') {
                grid[i][j] = '0';
                list.add(new int[]{i + 1, j});
                list.add(new int[]{i - 1, j});
                list.add(new int[]{i, j + 1});
                list.add(new int[]{i, j - 1});
            }
        }
    }

    public static void main(String[] args) {
        Test_200_3 a = new Test_200_3();
        char[][] data = new char[][]{
                {'1', '1', '1', '1', '0'},
                {'1', '1', '0', '1', '0'},
                {'1', '1', '0', '0', '0'},
                {'0', '0', '0', '0', '0'}
        };
        char[][] data1 = new char[][]{
                {'1', '1', '0', '0', '0'},
                {'1', '1', '0', '0', '0'},
                {'0', '0', '1', '0', '0'},
                {'0', '0', '0', '1', '1'}
        };

        char[][] data2 = new char[][]{
                {1, 1, 0},
                {1, 1, 0},
                {0, 0, 1}
        };
        System.out.println(a.numIslands(data));
    }
}

class Test_200_4 {

    private static final int[][] DIRECTIONS = {{-1, 0}, {0, -1}, {1, 0}, {0, 1}};
    private boolean[][] visited;
    private int rows;
    private int cols;
    private char[][] grid;

    public int numIslands(char[][] grid) {
        rows = grid.length;
        if (rows == 0) {
            return 0;
        }
        cols = grid[0].length;

        this.grid = grid;
        visited = new boolean[rows][cols];
        int count = 0;
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                // 如果是岛屿中的一个点，并且没有被访问过，就进行深度优先遍历
                if (!visited[i][j] && grid[i][j] == '1') {
                    dfs(i, j);
                    count++;
                }
            }
        }
        return count;
    }

    /**
     * 从坐标为 (i, j) 的点开始进行深度优先遍历
     *
     * @param i
     * @param j
     */
    private void dfs(int i, int j) {
        visited[i][j] = true;
        for (int k = 0; k < 4; k++) {
            int newX = i + DIRECTIONS[k][0];
            int newY = j + DIRECTIONS[k][1];
            // 如果不越界、还是陆地、没有被访问过
            if (inArea(newX, newY) && grid[newX][newY] == '1' && !visited[newX][newY]) {
                dfs(newX, newY);
            }
        }
    }

    /**
     * 封装成 inArea 方法语义更清晰
     *
     * @param x
     * @param y
     * @return
     */
    private boolean inArea(int x, int y) {
        return x >= 0 && x < rows && y >= 0 && y < cols;
    }
}