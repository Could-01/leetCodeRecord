package 数组;

import java.util.Arrays;

public class _274_H指数 {
    public int hIndex(int[] citations) {
        Arrays.sort(citations);
        for (int i = 0; i < citations.length; i++) {
            int h = citations.length - i;
            if (h <= citations[i]) {
                return h;
            }
        }
        return 0;
    }

    public static void main(String[] args) {
        _274_H指数 a = new _274_H指数();
        int[] data = {};
        System.out.println(a.hIndex(data));
    }
}
