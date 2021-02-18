package 数组;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class _1748_唯一元素的和 {
    public int sumOfUnique(int[] nums) {
        int sum = 0;
        int[] mark = new int[101];
        for (int i : nums) {
            mark[i]++;
        }
        for (int i = 0; i < mark.length; i++) {
            if (mark[i] == 1) sum += i;
        }
        return sum;
    }

    public static void main(String[] args) {
        _1748_唯一元素的和 a = new _1748_唯一元素的和();
        int[] data = {1,1,1,1,1};
        System.out.println(a.sumOfUnique(data));
    }
}
