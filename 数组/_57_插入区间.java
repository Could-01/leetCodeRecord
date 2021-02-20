package 数组;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class _57_插入区间 {

    public int[][] insert(int[][] in, int[] cur) {
        List<int[]> res = new ArrayList<>();
        for(int[] i : in) {
            if(i[1] < cur[0]) {
                // 当前区间在插入区间之前
                res.add(i);
            } else if(i[0] > cur[1]) {
                // 当前区间在插入区间之后
                res.add(cur);
                // 更新插入区间
                cur = i;
            } else {
                // 合并存在交集的两个区间
                cur[0] = Math.min(i[0], cur[0]);
                cur[1] = Math.max(i[1], cur[1]);
            }
        }
        // 添加最后的区间
        res.add(cur);

        return res.toArray(new int[res.size()][]);
    }

    public static void main(String[] args) {
        _57_插入区间 a = new _57_插入区间();
        int[][] data = {{1, 2}, {3, 5}, {6, 7}, {8, 10}, {12, 16}};
        int[] data1 = {4, 8};
        // [1,2],[3,10],[12,16]
        for (int[] arr : a.insert(data, data1)) {
            System.out.println(Arrays.toString(arr));
        }
    }
}
