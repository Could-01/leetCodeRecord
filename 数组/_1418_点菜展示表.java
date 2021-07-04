package 数组;


import java.util.*;

public class _1418_点菜展示表 {
    public List<List<String>> displayTable(List<List<String>> orders) {
        List<List<String>> res = new ArrayList<>();
        // 菜顺序
        List<String> fooditem = new ArrayList<>();
        fooditem.add("");
        for (int i = 0; i < orders.size(); i++) {
            String food = orders.get(i).get(2);
            if (!fooditem.contains(food)) {
                fooditem.add(food);
            }
        }
        Collections.sort(fooditem);
        fooditem.set(0, "Table");
        res.add(fooditem);
        // 面向桌号记录
        TreeMap<Integer, int[]> map = new TreeMap<>();
        for (List<String> list : orders) {
            String food = list.get(2);
            int table = Integer.parseInt(list.get(1));
            int[] tmp = new int[fooditem.size() - 1];
            if (map.containsKey(table)) {
                tmp = map.get(table);
            }
            tmp[fooditem.indexOf(food) - 1]++;
            map.put(table, tmp);
        }
        // 拆箱
        for (Integer in : map.keySet()) {
            int[] fooditems = map.get(in);
            List<String> list = new ArrayList<>();
            list.add(String.valueOf(in));
            for (int n : fooditems) {
                list.add(String.valueOf(n));
            }
            res.add(list);
        }
        return res;
    }

    public static void main(String[] args) {
        _1418_点菜展示表 a = new _1418_点菜展示表();
        List<List<String>> data = new ArrayList<>();
        String[] a1 = {"CWdAM","10"," FlzD"};
        String[] a2 = {"Corina", "10", "Beef Burrito"};
        String[] a3 = {"David", "3", "Fried Chicken"};
        String[] a4 = {"Carla", "5", "Water"};
        String[] a5 = {"Carla", "5", "Ceviche"};
        String[] a6 = {"Rous", "3", "Ceviche"};
        List<String> list1 = new ArrayList<>(Arrays.asList(a1));
        List<String> list2 = new ArrayList<>(Arrays.asList(a2));
        List<String> list3 = new ArrayList<>(Arrays.asList(a3));
        List<String> list4 = new ArrayList<>(Arrays.asList(a4));
        List<String> list5 = new ArrayList<>(Arrays.asList(a5));
        List<String> list6 = new ArrayList<>(Arrays.asList(a6));
        data.add(list1);
        data.add(list2);
        data.add(list3);
        data.add(list4);
        data.add(list5);
        data.add(list6);
        System.out.println(a.displayTable(data));
    }
}
