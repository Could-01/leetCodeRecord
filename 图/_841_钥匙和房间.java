package 图;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class _841_钥匙和房间 {
    private void dfs(int i, boolean[] marked, List<List<Integer>> rooms) {
        marked[i] = true;
        for (int j : rooms.get(i)) {
            if (!marked[j]) {
                dfs(j, marked, rooms);
            }
        }
    }

    public boolean canVisitAllRooms(List<List<Integer>> rooms) {
        boolean[] marked = new boolean[rooms.size()];
        dfs(0, marked, rooms);
        for (boolean flag : marked) {
            if (!flag) return false;
        }
        return true;
    }

    public static void main(String[] args) {
        _841_钥匙和房间 a = new _841_钥匙和房间();
        List<List<Integer>> rooms = new ArrayList<>();
        List<Integer> list0 = new ArrayList<>();
        List<Integer> list1 = new ArrayList<>();
        List<Integer> list2 = new ArrayList<>();
        List<Integer> list3 = new ArrayList<>();
//        list0.add(1);
//        list1.add(2);
//        list2.add(3);
        list0.add(1);
        list0.add(3);

        list1.add(3);
        list1.add(0);
        list1.add(1);

        list2.add(2);

        list3.add(0);
        rooms.add(list0);
        rooms.add(list1);
        rooms.add(list2);
        rooms.add(list3);
        System.out.println(a.canVisitAllRooms(rooms));
    }
}
