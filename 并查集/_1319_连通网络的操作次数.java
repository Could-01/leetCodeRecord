package 并查集;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class _1319_连通网络的操作次数 {

    //quick_find 方法
    int line = 0;

    public int makeConnected(int n, int[][] connections) {
        if (n == 1) {
            if (connections.length == 1 && connections[0].length == 1) {
                return 0;
            } else {
                return -1;
            }
        }
        int[] parents = new int[n];
        int flag = 0;
        for (int i = 0; i < n; i++) {
            parents[i] = i;
        }
        for (int[] arr : connections) {
            union(parents, arr[0], arr[1]);
        }
        Set<Integer> set = new HashSet<>();
        for (int i : parents) {
            if (!set.contains(i)) {
                flag++;
                set.add(i);
            }
        }
        System.out.println("_1319_连通网络的操作次数 line : " + line + " parebts : " + Arrays.toString(parents) + " flag : " + flag);
        return line - (flag - 1) >= 0 ? flag - 1 : -1;
    }

    public int find(int[] parents, int v) {
        return parents[v];
    }

    public void union(int[] parents, int v1, int v2) {
        int p1 = find(parents, v1);
        int p2 = find(parents, v2);
        if (p1 == p2) {
            line++;
            return;
        }
        for (int i = 0; i < parents.length; i++) {
            if (parents[i] == p1) {
                parents[i] = p2;
            }
        }
    }

    public static void main(String[] args) {
        _1319_连通网络的操作次数 a = new _1319_连通网络的操作次数();
        int[][] data = {{0, 1}, {0, 2}, {1, 2}};
        int[][] data1 = {{0, 1}, {0, 2}, {0, 3}, {1, 2}, {1, 3}};
        int[][] data2 = {{0, 1}, {0, 2}, {3, 4}, {2, 3}};
        int[][] data3 = {{0, 1}, {0, 2}, {0, 3}, {1, 2}};
        int[][] data4 = {{1}};
        int[][] data5 = {{0, 4}, {1, 6}, {2, 9}, {4, 7}, {0, 6}, {6, 9}, {4, 8}, {1, 4}, {4, 9}, {1, 8}, {2, 8}, {3, 4}, {0, 9}};
        int[][] data6 = {{4, 12}, {7, 11}, {3, 10}, {0, 12}, {8, 11}, {2, 5}, {2, 11}, {9, 10}, {3, 6}, {6, 10}, {2, 8}, {10, 11}, {2, 7}, {7, 13}, {12, 14}, {1, 8}, {3, 7}, {9, 11}, {3, 11}, {10, 14}, {0, 3}, {0, 14}, {7, 9}, {0, 8}, {3, 14}, {2, 4}};
        System.out.println(a.makeConnected(15, data6));
    }
}

class Test_1319 {
    int line = 0;

    //基于size的优化
    public int makeConnected(int n, int[][] connections) {
        if (n == 1) {
            if (connections.length == 1 && connections[0].length == 1) {
                return 0;
            } else {
                return -1;
            }
        }
        int[] sizes = new int[n];
        Arrays.fill(sizes, 1);
        int[] parents = new int[n];
        int flag = 0;
        for (int i = 0; i < n; i++) {
            parents[i] = i;
        }
        for (int[] arr : connections) {
            union(sizes, parents, arr[0], arr[1]);
        }


        Set<Integer> s = new HashSet();
        for (int i : parents) {
            int p = find(parents, i);
            if (!s.contains(p)) {
                flag++;
                s.add(p);
            }
        }
        return line - (flag - 1) >= 0 ? flag - 1 : -1;
    }

    public void union(int[] sizes, int[] parents, int v1, int v2) {
        int p1 = find(parents, v1);
        int p2 = find(parents, v2);
        if (p1 == p2) {
            line++;
            return;
        }

        if (sizes[p1] < sizes[p2]) {
            parents[p1] = p2;
            sizes[p2] += sizes[p1];
        } else {
            parents[p2] = p1;
            sizes[p1] += sizes[p2];
        }
    }

    public int find(int[] parents, int v) {
        while (v != parents[v]) {
            v = parents[v];
        }
        return v;
    }

    public static void main(String[] args) {
        Test_1319 a = new Test_1319();
        _1319_连通网络的操作次数 b = new _1319_连通网络的操作次数();
        int[][] data = {{0, 1}, {0, 2}, {1, 2}};
        int[][] data1 = {{0, 1}, {0, 2}, {0, 3}, {1, 2}, {1, 3}};
        int[][] data2 = {{0, 1}, {0, 2}, {3, 4}, {2, 3}};
        int[][] data3 = {{0, 1}, {0, 2}, {0, 3}, {1, 2}};
        int[][] data4 = {{1}};
        int[][] data5 = {{0, 4}, {1, 6}, {2, 9}, {4, 7}, {0, 6}, {6, 9}, {4, 8}, {1, 4}, {4, 9}, {1, 8}, {2, 8}, {3, 4}, {0, 9}};
        int[][] data6 = {{4, 12}, {7, 11}, {3, 10}, {0, 12}, {8, 11}, {2, 5}, {2, 11}, {9, 10}, {3, 6}, {6, 10}, {2, 8}, {10, 11}, {2, 7}, {7, 13}, {12, 14}, {1, 8}, {3, 7}, {9, 11}, {3, 11}, {10, 14}, {0, 3}, {0, 14}, {7, 9}, {0, 8}, {3, 14}, {2, 4}};
        System.out.println(a.makeConnected(15, data6));
        System.out.println(b.makeConnected(15, data6));
    }

}

class Test_1319_1 {
    //Quick Union - 基于rank的优化 - 路径压缩(Path Compression)
    public int makeConnected(int n, int[][] connections) {
        if (connections.length < n - 1) {
            return -1;
        }
        int[] rank = new int[n];
        Arrays.fill(rank, 1);
        int[] parents = new int[n];
        for (int i = 0; i < n; i++) {
            parents[i] = i;
        }
        for (int[] arr : connections) {
            union(rank, parents, arr[0], arr[1]);
        }
        int count = 0;
        for (int i = 0; i < n; i++) {
            if (parents[i] == i) {
                count++;
            }
        }
        return count - 1;
    }

    public void union(int[] ranks, int[] parents, int v1, int v2) {
        int p1 = find(parents, v1);
        int p2 = find(parents, v2);
        if (p1 == p2) {
            return;
        }

        if (ranks[p1] < ranks[p2]) {
            parents[p1] = p2;
        } else if (ranks[p1] > ranks[p2]) {
            parents[p2] = p1;
        } else {
            parents[p1] = p2;
            ranks[p2] += 1;
        }
    }
    public int find(int[] parents, int v) {
        if (parents[v] != v) {
            parents[v] = find(parents, parents[v]);
        }
        return parents[v];
    }


    public static void main(String[] args) {
        Test_1319_1 a = new Test_1319_1();
        int[][] data = {{0, 1}, {0, 2}, {1, 2}};
        int[][] data1 = {{0, 1}, {0, 2}, {0, 3}, {1, 2}, {1, 3}};
        int[][] data2 = {{0, 1}, {0, 2}, {3, 4}, {2, 3}};
        int[][] data3 = {{0, 1}, {0, 2}, {0, 3}, {1, 2}};
        int[][] data4 = {{1}};
        int[][] data5 = {{0, 4}, {1, 6}, {2, 9}, {4, 7}, {0, 6}, {6, 9}, {4, 8}, {1, 4}, {4, 9}, {1, 8}, {2, 8}, {3, 4}, {0, 9}};
        int[][] data6 = {{4, 12}, {7, 11}, {3, 10}, {0, 12}, {8, 11}, {2, 5}, {2, 11}, {9, 10}, {3, 6}, {6, 10}, {2, 8}, {10, 11}, {2, 7}, {7, 13}, {12, 14}, {1, 8}, {3, 7}, {9, 11}, {3, 11}, {10, 14}, {0, 3}, {0, 14}, {7, 9}, {0, 8}, {3, 14}, {2, 4}};
        System.out.println(a.makeConnected(10, data5));
    }

}

class Test_1319_2{
    private int[] parent;

    public int makeConnected(int n, int[][] connections) {
        // n 个节点相互连通至少需要n-1条线
        if (connections.length < n - 1) {
            return -1;
        }
        // 初始化
        parent = new int[n];
        for (int i = 0; i < n; i++) {
            parent[i] = i;
        }
        // 合并
        for (int[] connection : connections) {
            union(connection[0], connection[1]);
        }
        int count = 0;
        for (int i = 0; i < n; i++) {
            if (parent[i] == i) {
                count++;
            }
        }
        return count - 1;
    }

    private int find(int node) {
        return parent[node] == node ? node : (parent[node] = find(parent[node]));
    }

    private void union(int node1, int node2) {
        int root1 = find(node1);
        int root2 = find(node2);
        if (root1 == root2) {
            return;
        }
        parent[root1] = root2;
    }
}