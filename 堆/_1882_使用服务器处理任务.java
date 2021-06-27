package 堆;

import java.util.*;

public class _1882_使用服务器处理任务 {
    public int[] assignTasks(int[] servers, int[] tasks) {
        int tasklength = tasks.length, serverslength = servers.length;
        int[] ans = new int[tasklength];
        int nowtime = 0;
        PriorityQueue<int[]> avaqueue = new PriorityQueue<>(((o1, o2) -> { // {weight, index}   可用的服务器堆
            if (o1[0] == o2[0]) {
                return o1[1] - o2[1];
            } else {
                return o1[0] - o2[0];
            }
        }));
        PriorityQueue<int[]> unavaqueue = new PriorityQueue<>(Comparator.comparingInt(o -> o[0])); //{time, index}    正在执行任务的服务器堆
        for (int i = 0; i < serverslength; i++) {
            int[] arr = {servers[i], i};
            avaqueue.add(arr);
        }
        for (int i = 0; i < tasklength; i++) {
            if (nowtime < i) nowtime = i;
            int time = tasks[i];
            int[] avalist;
            int[] unavalist;
            if (unavaqueue.size() == 0) { //全部都可用
                avalist = avaqueue.poll();
                unavalist = new int[]{nowtime + time, avalist[1]};
                unavaqueue.add(unavalist);
            } else {
                if (avaqueue.size() == 0) nowtime = unavaqueue.peek()[0];
                while (unavaqueue.size() > 0 && unavaqueue.peek()[0] <= nowtime) {
                    int index = unavaqueue.poll()[1]; //取出那些可用的服务器
                    avalist = new int[]{servers[index], index};
                    avaqueue.add(avalist);
                }
                unavalist = avaqueue.poll();
                if (unavalist == null) { // 表示全部都不可用，但是被时间拖住了
                    avalist = unavaqueue.poll(); // 找到最短时间内可用的服务器
//                    nowtime = avalist[0];
                    avaqueue.add(avalist);
                    while (avalist[0] == unavaqueue.peek()[0]) {
                        avaqueue.add(unavaqueue.poll());
                    }
                    unavalist = avaqueue.poll();
                }
                unavalist[0] = nowtime + time;
                unavaqueue.add(unavalist);
            }
            ans[i] = unavalist[1];
        }
        return ans;
    }

    public static void main(String[] args) {
        _1882_使用服务器处理任务 a = new _1882_使用服务器处理任务();
        int[] servers = {31, 96, 73, 90, 15, 11, 1, 90, 72, 9, 30, 88};
        int[] tasks = {87, 10, 3, 5, 76, 74, 38, 64, 16, 64, 93, 95, 60, 79, 54, 26, 30, 44, 64, 71};
        System.out.println(Arrays.toString(a.assignTasks(servers, tasks)));
    }
}
