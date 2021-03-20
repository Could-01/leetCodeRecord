package 数组;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class _290_单词规律 {
    public boolean wordPattern(String pattern, String s) {
        int[] record = new int[26];
        Arrays.fill(record, -1);
        Map<String, Integer> map = new HashMap<>();
        String[] strarr = s.split(" ");
        int len = pattern.length(), index = 0;
        if (len != strarr.length) return false;
        while (index < len) {
            int flag = pattern.charAt(index) - 'a';
            if (record[flag] == -1) { // 一个新的元素
                if (map.containsKey(strarr[index])) return false; // 如果这个元素之前被添加过
                map.put(strarr[index], index);
                record[flag] = index;
            } else { // 这个元素是存在的
                int Last = record[flag]; //上次出现的位置
                if (map.containsKey(strarr[index]) && map.get(strarr[index]) == Last) {
                    record[flag] = index;
                    map.remove(strarr[index]);
                    map.put(strarr[index], index);
                } else {
                    return false;
                }
            }
            index++;
        }
        return true;
    }

    public static void main(String[] args) {
        _290_单词规律 a = new _290_单词规律();
        System.out.println(a.wordPattern("deadbeef", "d e a d b e e f"));
    }

}
