package 图;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class _685_冗余连接II {
    public int[] findRedundantDirectedConnection(int[][] edges) {
        int n = edges.length;

        // 出入度，邻接表
        int[] ins = new int[n + 1], outs = new int[n + 1];
        boolean[][] adj = new boolean[n + 1][n + 1];
        // edges = [[1,2],[1,3],[2,3]]
        int[] res = null;
        int tt = -1; // 记录入度为 2 的有问题的点，最多一个
        for (int[] e : edges) {
            int from = e[0], to = e[1];
            ins[to]++;
            outs[from]++;
            adj[from][to] = true;

            // 入度为 2，该点有问题
            // 不急着处理，因还需遍历所有点，完善所有点出入度信息
            if (ins[to] == 2) tt = to;

            // 所有入度为 1，必成环，随便删哪个都能断开环
            // 删除最后一个、使入度点同时又有出度的那条边
            if (ins[to] == 1 && outs[to] > 0) res = e;
        }

        if (tt != -1) {
            // 有入度为 2 的点
            res = null;
            // 找指向 tt 的边 && 来源点 f 又有出又有入——删此边不影响脱环
            for (int i = n - 1; i >= 0; i--) { // 逆序
                int f = edges[i][0], t = edges[i][1];
                if (t == tt && outs[f] + ins[f] > 1) {
                    // 只算最后一个
                    if (res == null) {
                        res = edges[i];
                    }

                    // 相互指向则肯定有问题，如 [[4,2],[1,5],[5,2],[5,3],[2,4]]
                    if (adj[t][f]) return edges[i];
                }
            }
        }

        return res;
    }

    public static void main(String[] args) {
        _685_冗余连接II a = new _685_冗余连接II();
        int[][] data = {{1, 2}, {1, 3}, {2, 3}};
        int[][] data1 = {{1, 2}, {2, 3}, {3, 4}, {4, 1}, {1, 5}};
        System.out.println(Arrays.toString(a.findRedundantDirectedConnection(data)));
    }
}


class Test_685 {
    public int[] findRedundantDirectedConnection(int[][] edges) {
        int n = edges.length;
        int[] inDegree = new int[n + 1];
        int[] res = null;
        int tt = -1; // 记录入度为 2 的有问题的点，最多一个
        List<Integer>[] Edges = new ArrayList[n + 1];
        for (int i = 0; i < n + 1; i++) {
            Edges[i] = new ArrayList();
        }
        for (int[] arr : edges) {
            int from = arr[0], to = arr[1];
            inDegree[to]++; //入度表
            Edges[from].add(to); //出度表
            //入度为2
            if (inDegree[to] == 2) tt = to;
            if (inDegree[to] == 1 && Edges[to].size() > 0) res = arr;
        }
        if (tt != -1) {
            // 有入度为 2 的点
            res = null;
            // 找指向 tt 的边 && 来源点 f 又有出又有入——删此边不影响脱环
            for (int i = n - 1; i >= 0; i--) { // 逆序
                int f = edges[i][0], t = edges[i][1];
                int in = inDegree[f]; // 入
                int out = Edges[f].size(); //出
                if (t == tt && in + out > 1) {
                    if (res == null) res = edges[i];
                    if (Edges[t].contains(f)) {
                        return edges[i];
                    }
                }
            }
        }
        return res;
    }

    public static void main(String[] args) {
        Test_685 a = new Test_685();
        int[][] data = {{1, 2}, {1, 3}, {2, 3}};
        int[][] data1 = {{1, 2}, {2, 3}, {3, 4}, {4, 1}, {1, 5}};
        System.out.println(Arrays.toString(a.findRedundantDirectedConnection(data1)));
    }
}