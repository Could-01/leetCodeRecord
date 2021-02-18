package 图;

import java.util.*;

public class _210_课程表II {
    // 方法 1 最简单的 BFS
    public static int[] findOrder(int numCourses, int[][] prerequisites) {
        if (numCourses == 0) return new int[0];
        int[] inDegrees = new int[numCourses];
        // 建立入度表
        for (int[] p : prerequisites) { // 对于有先修课的课程，计算有几门先修课
            inDegrees[p[0]]++;
        }
        // 入度为0的节点队列
        Queue<Integer> queue = new LinkedList<>();
        for (int i = 0; i < inDegrees.length; i++) {
            if (inDegrees[i] == 0) queue.offer(i);
        }
        int count = 0;  // 记录可以学完的课程数量
        int[] res = new int[numCourses];  // 可以学完的课程
        // 根据提供的先修课列表，删除入度为 0 的节点
        while (!queue.isEmpty()) {
            int curr = queue.poll();
            res[count++] = curr;   // 将可以学完的课程加入结果当中
            for (int[] p : prerequisites) {
                if (p[1] == curr) {
                    inDegrees[p[0]]--;
                    if (inDegrees[p[0]] == 0) queue.offer(p[0]);
                }
            }
        }
        if (count == numCourses) return res;
        return new int[0];
    }

    public static void main(String[] args) {
        int[][] p = {{1, 0}, {2, 0}, {3, 1}, {3, 2}};
        int[] b = findOrder(4, p);
        System.out.print(Arrays.toString(b));
    }
}

class Test_210 {
    private int k = 0;

    public int[] findOrder(int numCourses, int[][] prerequisites) {
        if (numCourses == 0) return new int[0];
        int[] in = new int[numCourses];
        int[] ans = new int[numCourses];
        Map<Integer, List<Integer>> map = new HashMap<>();
        for (int i = 0; i < numCourses; i++) {
            map.put(i, new ArrayList<>());
        }
        for (int[] pre : prerequisites) {
            List<Integer> list = new ArrayList<>();
            int pre1 = pre[1];
            int pre0 = pre[0];
            in[pre0]++;
            list = map.get(pre1);
            list.add(pre0);
            map.put(pre1, list);
        }
        for (int i = 0; i < numCourses; i++) {
            if (in[i] == 0) { // 入度为0, 表示直接学
                ans[k++] = i;
                in[i] = -1;
                // 查出入度为0的是哪些课程的先修
                List<Integer> list = map.get(i);
                topologicalSorting(map, list, in, ans);
            }
        }
        return k == numCourses ? ans : new int[0];
    }

    public void topologicalSorting(Map<Integer, List<Integer>> map, List<Integer> list, int[] in, int[] ans) {
        if (list.size() == 0) return;
        for (int course : list) {
            // 表示已经有一个0的课程, 拓扑减一。
            in[course]--;
            if (in[course] == 0) {
                ans[k++] = course;
                in[course] = -1;
                List<Integer> l = map.get(course) == null ? new ArrayList() : map.get(course);
                topologicalSorting(map, l, in, ans);
            }
        }
    }

    public static void main(String[] args) {
        Test_210 a = new Test_210();
        int[][] p = {{1, 0}, {2, 0}, {3, 1}, {3, 2}};
        int[][] p1 = {{1, 0}, {0, 1}};
        int[][] p2 = {{1, 0}, {1, 2}, {0, 1}};
        int[][] p3 = {};
        int[] b = a.findOrder(1, p3);
        System.out.print(Arrays.toString(b));
    }
}


class Test_210_1 {
    private int k = 0;

    public int[] findOrder(int numCourses, int[][] prerequisites) {
        int[] in = new int[numCourses];
        int[] ans = new int[numCourses];
        List[] edges = new ArrayList[numCourses];
        for (int i = 0; i < numCourses; i++) {
            edges[i] = new ArrayList<Integer>();
        }
        // int[][] p = {{1, 0}, {2, 0}, {3, 1}, {3, 2}}
        for (int[] pre : prerequisites) {
            in[pre[0]]++;
            edges[pre[1]].add(pre[0]);
        }
        for (int i = 0; i < numCourses; i++) {
            if (in[i] == 0) {
                ans[k++] = i;
                in[i] = -1;
                topologicalSorting(edges, edges[i], in, ans);
            }
        }
        return k == numCourses ? ans : new int[0];
    }

    // list 存放关系 {{1, 2}}
    public void topologicalSorting(List[] edges, List<Integer> list, int[] in, int[] ans) {
        for (int course : list) {
            in[course]--;
            if (in[course] == 0) {
                ans[k++] = course;
                in[course] = -1;
                topologicalSorting(edges, edges[course], in, ans);
            }
        }
    }

    public static void main(String[] args) {
        Test_210_1 a = new Test_210_1();
        int[][] p = {{1, 0}, {2, 0}, {3, 1}, {3, 2}};
        int[][] p1 = {{1, 0}, {0, 1}};
        int[][] p2 = {{1, 0}, {1, 2}, {0, 1}};
        int[][] p3 = {};
        int[] b = a.findOrder(1, p3);
        System.out.print(Arrays.toString(b));
    }
}