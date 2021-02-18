package 图;

import java.util.*;

public class _684_冗余连接 {
    public int[] findRedundantConnection(int[][] edges) {
        //拓扑实现
        //构建邻接表和入度表
        if (edges == null || edges.length == 0 || edges[0].length == 0) {
            return new int[0];
        }
        int len = edges.length;

        int[] inDegree = new int[len + 1]; // 入度表
        Set<Integer>[] map = new HashSet[len + 1]; // 线段关系
        // 建立完整关系
        for (int[] edge : edges) {
            // 是某点的入度同时也是另一点出度
            inDegree[edge[0]]++;
            inDegree[edge[1]]++;

            if (map[edge[0]] == null) {
                map[edge[0]] = new HashSet<>();
            }
            map[edge[0]].add(edge[1]);

            if (map[edge[1]] == null) {
                map[edge[1]] = new HashSet<>();
            }
            map[edge[1]].add(edge[0]);
        }

        //如果一个无向图的入度为1，可作为遍历起点，建立队列入队
        Queue<Integer> queue = new LinkedList<>();
        for (int i = 1; i < len + 1; i++) {
            if (inDegree[i] == 1) {
                queue.add(i);
            }
        }
        //将队列中的入度为1 的点出队，将与其相邻的点入度减一，如果剩余1，可以作为新的遍历起点
        while (!queue.isEmpty()) {
            int num = queue.poll();
            for (int j : map[num]) {
                if (--inDegree[j] == 1) {
                    queue.add(j);
                }
            }
        }
        for (int i = len; i > 0; i--) {
            if (inDegree[edges[i - 1][0]] > 1 && inDegree[edges[i - 1][1]] > 1) {
                return edges[i - 1];
            }
        }
        return new int[0];
    }

    public static void main(String[] args) {
        _684_冗余连接 a = new _684_冗余连接();
        int[][] data1 = {{1, 2}, {1, 3}, {2, 3}};
        int[][] data2 = {{1, 2}, {2, 3}, {3, 4}, {1, 4}, {1, 5}};
        int[][] data = {{1, 2}, {2, 3}, {3, 4}, {2, 4}, {1, 5}};
        int[] res = a.findRedundantConnection(data);
        System.out.println(Arrays.toString(res));
    }
}

class Test_684 {
    /*
     * 相比于DFS不仅需要邻接表，还需要各点入度表，针对有向图，入度为0的端点作为遍历的起点。
     * 本题为无向图，入度最少为1，将入度为1的点加入队列，然后每次删除队列中弹出的入度为1的点所连的点，
     * 表现为对应端点的入度值减一，如果对应端点入度为1，将其加入队列，重复步骤。针对有向图，
     * 如果有入度不为0的点存在，表示删除结束后仍存在入度不为0的点，即存在环；针对本题（无向图），
     * 从后往前遍历每条边，如果某条边两端端点入度均大于1时，返回该边。
     * */
    public int[] findRedundantConnection(int[][] edges) {
        //拓扑实现
        //构建邻接表和入度表
        if (edges == null || edges.length == 0 || edges[0].length == 0) {
            return new int[0];
        }
        int len = edges.length + 1;
        int[] inDegree = new int[len]; // 入度表
        List<Integer>[] Edges = new ArrayList[len];
        for (int i = 0; i < len; i++) {
            Edges[i] = new ArrayList<Integer>();
        }
        // 建立完整关系
        // int[][] data2 = {{1, 2}, {2, 3}, {3, 4}, {1, 4}, {1, 5}};
        for (int[] edge : edges) {
            // 是某点的入度同时也是另一点出度
            inDegree[edge[0]]++;
            inDegree[edge[1]]++;

            Edges[edge[0]].add(edge[1]);
            Edges[edge[1]].add(edge[0]);
        }
        System.out.println("inDegree: " + Arrays.toString(inDegree));
        System.out.println("Edges:    " + Arrays.toString(Edges));
        //如果一个无向图的入度为1，可作为遍历起点，建立队列入队
        Queue<Integer> queue = new LinkedList<>();
        for (int i = 1; i < len; i++) {
            if (inDegree[i] == 1) {
                queue.add(i);
            }
        }
        //将队列中的入度为1 的点出队，将与其相邻的点入度减一，如果剩余1，可以作为新的遍历起点
        while (!queue.isEmpty()) {
            int num = queue.poll();
            for (int j : Edges[num]) {
                if (--inDegree[j] == 1) {
                    queue.add(j);
                }
            }
            System.out.println("queue=  " + queue);
            System.out.println("inDegree= " + Arrays.toString(inDegree));
        }
        for (int i = len - 1; i > 0; i--) {
            if (inDegree[edges[i - 1][0]] > 1 && inDegree[edges[i - 1][1]] > 1) {
                return edges[i - 1];
            }
        }
        return new int[0];
    }

    public static void main(String[] args) {
        Test_684 a = new Test_684();
        int[][] data1 = {{1, 2}, {1, 3}, {2, 3}};
        int[][] data2 = {{1, 2}, {2, 3}, {3, 4}, /*{1, 4}, {1, 5}*/ {4, 5}};
        int[][] data = {{1, 2}, {2, 3}, {3, 4}, {2, 4}, {1, 5}};
        int[] res = a.findRedundantConnection(data2);
        System.out.println(Arrays.toString(res));
    }
}