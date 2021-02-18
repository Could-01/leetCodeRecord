package 并查集;

public class _547_省份数量 {
    public int findCircleNum(int[][] isConnected) {
        int provinces = isConnected.length;
        int[] parent = new int[provinces];
        for (int i = 0; i < provinces; i++) {
            parent[i] = i;
        }
        for (int i = 0; i < provinces; i++) {
            for (int j = i + 1; j < provinces; j++) {
                if (isConnected[i][j] == 1) {
                    union(parent, i, j);
                }
            }
        }
        int circles = 0;
        for (int i = 0; i < provinces; i++) {
            if (parent[i] == i) {
                circles++;
            }
        }
        return circles;
    }

    public void union(int[] parent, int index1, int index2) {
        parent[find(parent, index1)] = find(parent, index2);
    }

    public int find(int[] parent, int index) {
        if (parent[index] != index) {
            parent[index] = find(parent, parent[index]);
        }
        return parent[index];
    }
}

class Test_547 {

    public int findCircleNum(int[][] isConnected) {
        int provinces = isConnected.length;
        int[] parent = new int[provinces];
        for (int i = 0; i < provinces; i++) {
            parent[i] = i;
        }

        for (int i = 0; i < provinces; i++) {
            for (int j = i + 1; j < provinces; j++) {
                if (isConnected[i][j] == 1) {
                    union(parent, i, j);
                }
            }
        }
        int circles = 0;
        for (int i = 0; i < provinces; i++) {
            if (parent[i] == i) {
                circles++;
            }
        }
        return circles;
    }

    public void union(int[] parent, int v1, int v2) {
        int p1 = find(parent, v1);
        int p2 = find(parent, v2);
        if (p1 == p2) return;

        for (int i = 0; i < parent.length; i++) {
            if (parent[i] == p1) {
                parent[i] = p2;
            }
        }
    }

    public int find(int[] parent, int v) {
        return parent[v];
    }

    public static void main(String[] args) {
        Test_547 a = new Test_547();
        int[][] data = {{1, 1, 0}, {1, 1, 0}, {0, 0, 1}};
        int[][] data1 = {{1, 0, 0}, {0, 1, 0}, {0, 0, 1}};
        System.out.println(a.findCircleNum(data1));
    }
}