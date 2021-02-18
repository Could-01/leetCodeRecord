package 图;

import java.util.ArrayDeque;
import java.util.LinkedList;
import java.util.Queue;

public class _1162_地图分析 {
    public int maxDistance(int[][] grid) {
        int n = grid.length;
        if (n <= 1) return -1;
        int[][] directions = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
        Queue<int[]> queue = new LinkedList<>();
        //首先将所有陆地都放进队列，进行层序遍历
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 1) {
                    queue.offer(new int[]{i, j});
                }
            }
        }
        //全是陆地或者海洋返回-1
        if (queue.size() == 0 || queue.size() == n * n) {
            return -1;
        }

        int len = -1;
        while (!queue.isEmpty()) {
            int size = queue.size();
            while (size-- > 0) {
                int[] cur = queue.poll();
                int x = cur[0];
                int y = cur[1];

                for (int[] direction : directions) {
                    int x1 = x + direction[0];
                    int y1 = y + direction[1];
                    //只要是海洋就放入队列,为了防止重复，将值变更为2
                    if (x1 >= 0 && x1 < n && y1 >= 0 && y1 < n
                            && grid[x1][y1] == 0) {
                        grid[x1][y1] = 2;
                        queue.add(new int[]{x1, y1});
                    }

                }
            }
            len++;
        }
        //遍历结束，所有的海洋都变为2
        return len;
    }


    public static void main(String[] args) {
        _1162_地图分析 a = new _1162_地图分析();
        int[][] data = {{1, 0, 1}, {0, 0, 0}, {1, 0, 1}};
        System.out.println(a.maxDistance(data));
    }

}


class Test_1162 {
    public int maxDistance(int[][] grid) {
        int[] dx = {0, 0, 1, -1};
        int[] dy = {1, -1, 0, 0};

        Queue<int[]> queue = new ArrayDeque<>();
        int m = grid.length, n = grid[0].length;
        // 先把所有的陆地都入队。
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 1) {
                    queue.offer(new int[]{i, j});
                }
            }
        }

        if(queue.size() == 0 || queue.size() == m * n){
            return -1;
        }


        // 从各个陆地开始，一圈一圈的遍历海洋，最后遍历到的海洋就是离陆地最远的海洋。
        boolean hasOcean = false;
        int[] point = null;
        while (!queue.isEmpty()) {
            point = queue.poll();
            int x = point[0], y = point[1];
            // 取出队列的元素，将其四周的海洋入队。
            for (int i = 0; i < 4; i++) {
                int newX = x + dx[i];
                int newY = y + dy[i];
                if (newX < 0 || newX >= m || newY < 0 || newY >= n || grid[newX][newY] != 0) {
                    continue;
                }
                grid[newX][newY] = grid[x][y] + 1; // 这里我直接修改了原数组，因此就不需要额外的数组来标志是否访问
                hasOcean = true;
                queue.offer(new int[]{newX, newY});
            }
        }

        // 返回最后一次遍历到的海洋的距离。
        return grid[point[0]][point[1]] - 1;

    }


    public static void main(String[] args) {
        Test_1162 a = new Test_1162();
        int[][] data = {{1, 0, 1}, {0, 0, 0}, {1, 0, 1}};
        System.out.println(a.maxDistance(data));
    }
}