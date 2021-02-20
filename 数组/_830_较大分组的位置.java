package 数组;

import java.util.ArrayList;
import java.util.List;

public class _830_较大分组的位置 {
    public List<List<Integer>> largeGroupPositions(String s) {
        List<List<Integer>> res = new ArrayList<>();
        int length = s.length();
        if (length < 3) return res;
        int count = 1;
        for (int i = 1; i < length; i++) {
            char c = s.charAt(i);
            if (c == s.charAt(i - 1)) {
                count++;
            } else {
                count = 1;
            }
            if (count == 3) {
                List<Integer> list = new ArrayList<>();
                list.add(i - 2);
                while (i < length && s.charAt(i) == c) {
                    i++;
                }
                list.add(i - 1);
                res.add(list);
                count = 1;
            }
        }
        return res;
    }


    public static void main(String[] args) {
        _830_较大分组的位置 a = new _830_较大分组的位置();
        System.out.println(a.largeGroupPositions("aaa"));
    }
}
