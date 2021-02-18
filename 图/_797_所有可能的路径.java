package 图;

import java.util.ArrayList;
import java.util.List;

public class _797_所有可能的路径 {
    public List<List<Integer>> allPathsSourceTarget(int[][] graph) {
        List<List<Integer>> rtn = new ArrayList<>();
        // int[][] data = {{4, 3, 1}, {3, 2, 4}, {3}, {4}, {}};
        if (graph == null || graph.length == 0) return rtn;
        ArrayList<Integer> tmp = new ArrayList<>();
        tmp.add(0);
        allPathsSourceTarget(rtn, tmp, graph, 0);
        return rtn;
    }

    private void allPathsSourceTarget(List<List<Integer>> rtn, List<Integer> integers, int[][] graph, int idx) {
        // int[][] data = {{4, 3, 1}, {3, 2, 4}, {3}, {4}, {}};
        if (graph[idx].length == 0) {
            rtn.add(new ArrayList<>(integers));
            return;
        }
        for (int i : graph[idx]) {
            integers.add(i);
            allPathsSourceTarget(rtn, integers, graph, i);

            integers.remove(integers.size() - 1);
        }
    }

    public static void main(String[] args) {
        Test_797 a = new Test_797();
        int[][] data = {{4, 3, 1}, {3, 2, 4}, {3}, {4}, {}};
        System.out.println(a.allPathsSourceTarget(data));
    }
}

class Test_797 {
    List<List<Integer>> res = null;

    public List<List<Integer>> allPathsSourceTarget(int[][] graph) {
        res = new ArrayList<>();
        if (graph[0] == null) return res;
        int des = graph.length - 1;
        dfs(0, des, graph, new ArrayList<>());
        return res;
    }

    private void dfs(Integer st, int ed, int[][] graph, List<Integer> tem) {
        if (st == null) return;
        tem.add(st);
        if (st == ed) {
            res.add(new ArrayList<>(tem));
        }
        for (Integer g : graph[st]) {
            //if(g == null) return;
            dfs(g, ed, graph, tem);
            tem.remove(tem.size() - 1);
        }
        return;
    }
}

class Test_797_1 {
    public List<List<Integer>> allPathsSourceTarget(int[][] graph) {
        int[][] g = graph;
        List<Integer> c = new ArrayList<>();
        List<List<Integer>> r = new ArrayList<>();
        c.add(0);
        DFS(c, r, 0, g);
        return r;
    }

    public void DFS(List<Integer> c, List<List<Integer>> r, int n, int[][] g) {
        if (n == g.length - 1) {
            r.add(new ArrayList<>(c));
            return;
        }

        int[] neighbors = g[n];
        for (int neighbor : neighbors) {
            c.add(neighbor);
            DFS(c, r, neighbor, g);
            c.remove(c.size() - 1);
            //add at the front of the list & delete a blank space from the back to unchange the size
        }
    }
}