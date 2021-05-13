package 数组;

import java.util.*;

public class _LCP_03机器人大冒险 {
    public boolean robot(String command, int[][] obstacles, int x, int y) {
        Map<Integer, List<Integer>> map1 = new HashMap();
        for (int i = 0; i < obstacles.length; i++) {
            if (map1.get(obstacles[i][0]) != null) {
                map1.get(obstacles[i][0]).add(obstacles[i][1]);
            } else map1.put(obstacles[i][0], new ArrayList<Integer>(Arrays.asList(obstacles[i][1])));
        }
        int row = 0;
        int cul = 0;
        int i = 0;
        while (row <= x && cul <= y) {
            if (command.charAt(i) == 'U') {
                cul++;
            } else {
                row++;
            }
            if ((map1.get(row) != null && map1.get(row).contains(cul))) return false;
            if (row == x && cul == y) return true;
            if (++i >= command.length()) i = 0;
        }
        return false;
    }

    public static void main(String[] args) {
        _LCP_03机器人大冒险 a = new _LCP_03机器人大冒险();
        int[][] data = {{2, 2}};
        System.out.println(a.robot("URR", data, 3, 2));
    }
}

class Solution_LCP_03 {
    public boolean robot(String command, int[][] obstacles, int x, int y) {
        int length = command.length();
        TreeMap<Integer, List<Integer>> map = new TreeMap<Integer, List<Integer>>();
        // 记录obstacles
        for (int[] obstacle : obstacles) {
            int obx = obstacle[0];
            int oby = obstacle[1];
            if (obx > x || oby > y) continue;
            if (map.containsKey(obx)) {
                map.get(obx).add(oby);
            } else {
                map.put(obx, new ArrayList<Integer>(Collections.singletonList(oby)));
            }
        }

        //寻找规律
        int top = 0, right = 0;
        for (int i = 0; i < length; i++) {
            char ch = command.charAt(i);
            if (ch == 'U') {
                top++;
            } else {
                right++;
            }
        }


        int posx = 0, posy = 0;
        while (posx < x && posy < y || !map.isEmpty()) {
            posx += right;
            posy += top;

            while (!map.isEmpty() && map.firstKey() <= posx) {
                // 取得上一步中所有的障碍
                int ox = map.firstKey();
                List<Integer> list = map.get(ox);
                // 回退
                posx -= right;
                posy -= top;
                for (int i = 0; i < length; i++) {
                    if (command.charAt(i) == 'U') {
                        posy++;
                    } else {
                        posx++;
                    }
                    // 到达障碍行
                    if (posx == ox) {
                        if (list.contains(posy)) {
                            return false;
                        }
                    }
                    if (posx <= ox && i == command.length() - 1) {
                        i = -1;
                    }
                }
                map.remove(ox);
            }
        }
        // 检测是否跳过了终点
        posx -= right;
        posy -= top;
        for (int i = 0; i < length; i++) {
            if (command.charAt(i) == 'U') {
                posy++;
            } else {
                posx++;
            }
            if (posx > x || posy > y) return false;
            if (posx == x && posy == y) return true;
            if (i == length - 1) i = -1;
        }

        return false;
    }

    public static void main(String[] args) {
        Solution_LCP_03 a = new Solution_LCP_03();
        int[][] data1 = {{5, 5}, {9, 4}, {9, 7}, {6, 4}, {7, 0}, {9, 5}, {10, 7}, {1, 1}, {7, 5}};
        int[][] data2 = {{3, 0}};
        int[][] data3 = {{10, 5}, {1, 6}, {6, 10}, {3, 0}, {0, 3}, {0, 10}, {6, 2}};
        int[][] data = {};
        System.out.println(a.robot("UUR", data, 1, 4));
    }
}