package 数组;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class _697_数组的度 {
    public int findShortestSubArray(int[] nums) {
        // Integer表示数字,list包含开始位置和最后一次位置
        Map<Integer, List<Integer>> map = new HashMap<>();
        int max = 0, res = Integer.MAX_VALUE;
        for (int i = 0; i < nums.length; i++) {
            List<Integer> list = new ArrayList<>();
            int num = nums[i];
            if (!map.containsKey(num)) {
                list.add(i);
                map.put(num, list);
            } else {
                list = map.get(num);
                list.add(i);
                map.put(num, list);
                max = Math.max(list.size(), max);
            }
        }
        for (List<Integer> list : map.values()) {
            if (list.size() == max) {
                res = Math.min(res, list.get(max - 1) - list.get(0));
            }
        }
        return ++res < 0 ? 1 : res;
    }


    public int findShortestSubArray1(int[] nums) {
        // Integer表示数字,list包含开始位置和最后一次位置
        Map<Integer, List<Integer>> map = new HashMap<>();
        int max = 0, res = Integer.MAX_VALUE;
        for (int i = 0; i < nums.length; i++) {
            List<Integer> list = new ArrayList<>();
            int num = nums[i];
            if (!map.containsKey(num)) {
                list.add(i);
                map.put(num, list);
            } else {
                list = map.get(num);
                list.add(i);
                map.put(num, list);
                if (list.size() > max) {
                    max = list.size();
                    res = list.get(max - 1) - list.get(0);
                } else if (list.size() == max) {
                    res = Math.min(res, list.get(max - 1) - list.get(0));
                }
            }
        }
        return ++res < 0 ? 1 : res;
    }


    public static void main(String[] args) {
        _697_数组的度 a = new _697_数组的度();
        int[] data = {1, 2, 2, 3, 1, 4, 2};
        System.out.println(a.findShortestSubArray1(data));
    }
}
