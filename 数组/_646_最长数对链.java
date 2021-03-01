package 数组;

import java.util.Arrays;

public class _646_最长数对链 {
    // 贪心
    public int findLongestChain(int[][] pairs) {
        if (pairs.length == 0) return 0;
        Arrays.sort(pairs, (o1, o2) -> o1[1] - o2[1]);
        int res = 1, tmp = pairs[0][1];
        for (int i = 1; i < pairs.length; i++) {
            if (pairs[i][0] > tmp) {
                res++;
                tmp = pairs[i][1];
            }
        }
        return res;
    }

    public static void main(String[] args) {
        _646_最长数对链 a = new _646_最长数对链();
        int[][] data = {{1, 2}, {2, 3}, {3, 4}};
        System.out.println(a.findLongestChain(data));
    }
}
