package 图;

import java.util.*;

public class _207_课程表 {
    int k = 0;

    // 是否存在环
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        if (numCourses == 0) return true;
        int[] in = new int[numCourses]; // 入度
        List<Integer>[] edges = new List[numCourses]; // 边关系
        for (int i = 0; i < numCourses; i++) {
            edges[i] = new ArrayList<Integer>();
        }
        for (int[] pre : prerequisites) {
            in[pre[0]]++; // 是否需要先修课程，不为0表示需要。是否可以当作起点的点
            edges[pre[1]].add(pre[0]); // 修完该课程后才可以修的课程。 起点可以走的路线
        }
        for (int i = 0; i < numCourses; i++) {
            if (in[i] == 0) { // 入度为0, 表示直接学。 找到起点
                k++;
                in[i] = -1; // 已经学过了，改成-1
                topologicalSorting(edges, edges[i], in);
            }
        }
        return k == numCourses;
    }

    public void topologicalSorting(List[] edges, List<Integer> list, int[] in) {
        for (int course : list) {
            in[course]--; // 可以到这个点了
            if (in[course] == 0) {
                k++;
                in[course] = -1;
                topologicalSorting(edges, edges[course], in); // 表示这个点已经可以完全到达了，可以把这个点当作起点了。
            }
        }
    }


    public static void main(String[] args) {
        _207_课程表 a = new _207_课程表();
        int[][] data = {{0, 10}, {3, 18}, {5, 5}, {6, 11}, {11, 14}, {13, 1}, {15, 1}, {17, 4}};
        System.out.println(a.canFinish(20, data));
    }
}

class Test_207 {
    // BFS 解法
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        int[] indegrees = new int[numCourses];
        List<List<Integer>> adjacency = new ArrayList<>();
        Queue<Integer> queue = new LinkedList<>();
        for (int i = 0; i < numCourses; i++)
            adjacency.add(new ArrayList<>());
        // Get the indegree and adjacency of every course.
        for (int[] cp : prerequisites) {
            indegrees[cp[0]]++;
            adjacency.get(cp[1]).add(cp[0]);
        }
        // Get all the courses with the indegree of 0.
        for (int i = 0; i < numCourses; i++)
            if (indegrees[i] == 0) queue.add(i); // 找到起点入队列
        // BFS TopSort.
        while (!queue.isEmpty()) {
            int pre = queue.poll(); // 出队列
            numCourses--;
            for (int cur : adjacency.get(pre))
                if (--indegrees[cur] == 0) queue.add(cur);
        }
        return numCourses == 0;
    }
}

class Test_207_1 {
    /**
     * 输入: 2, [[1,0]]
     * 输出: true
     * 解释: 总共有 2 门课程。学习课程 1 之前，你需要完成课程 0。所以这是可能的。
     * <p>
     * 输入: 2, [[1,0],[0,1]]
     * 输出: false
     * 解释:总共有 2 门课程。学习课程 1 之前，你需要先完成课程 0；并且学习课程 0 之前，你还应先完成课程 1。这是不可能的。
     * <p>
     * 输入: 4, [[1,0],[2,0],[3,1],[3,2]]
     * 输出: [0,1,2,3] or [0,2,1,3]
     * 解释:总共有 4 门课程。要学习课程 3，你应该先完成课程 1 和课程 2。并且课程 1 和课程 2 都应该排在课程 0 之后。
     * 因此，一个正确的课程顺序是[0,1,2,3] 。另一个正确的排序是[0,2,1,3]
     */
    // DFS 解法
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        List<List<Integer>> adjacency = new ArrayList<>();
        for (int i = 0; i < numCourses; i++)
            adjacency.add(new ArrayList<>());
        int[] flags = new int[numCourses];
        for (int[] cp : prerequisites)
            adjacency.get(cp[1]).add(cp[0]);
        for (int i = 0; i < numCourses; i++)
            if (!dfs(adjacency, flags, i)) return false;
        return true;
    }

    private boolean dfs(List<List<Integer>> adjacency, int[] flags, int i) {
        if (flags[i] == 1) return false;
        if (flags[i] == -1) return true;
        flags[i] = 1; // 标记方法
        for (Integer j : adjacency.get(i))
            if (!dfs(adjacency, flags, j)) return false;
        flags[i] = -1;
        return true;
    }

    public static void main(String[] args) {
        Test_207_1 a = new Test_207_1();
        int[][] data = {{0, 10}, {3, 18}, {5, 5}, {6, 11}, {11, 14}, {13, 1}, {15, 1}, {17, 4}};
        int[][] data1 = {{1, 0}, {0, 1}};
        int[][] p = {{1, 0}, {2, 0}, {3, 1}, {3, 2}};
        System.out.println(a.canFinish(4, p));
    }
}