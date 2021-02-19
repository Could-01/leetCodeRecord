package 贪心;

import java.util.Arrays;

public class _870_优势洗牌 {
    public int[] advantageCount(int[] a, int[] b) {
        int n = b.length;
        Arrays.sort(a);
        int[][] pair = new int[n][2];
        for (int i = 0; i < n; i++)
            pair[i] = new int[]{b[i], i};//把下标保存下来
        Arrays.sort(pair, (x, y) -> x[0] - y[0]);

        int[] res = new int[n];
        for (int i = 0, r = n - 1, l = 0; i < n; i++)//r最大值，l标明最小值；
        {
            if (a[i] <= pair[l][0]) res[pair[r--][1]] = a[i];//要放到原数组对应的位置上
            else res[pair[l++][1]] = a[i];////要放到原数组对应的位置上
        }
        return res;
    }

    public static void main(String[] args) {
        _870_优势洗牌 a = new _870_优势洗牌();
        int[] A = {718967141, 189971378, 341560426, 23521218, 339517772};
        int[] B = {967482459, 978798455, 744530040, 3454610, 940238504};
        // 718967141,341560426,339517772,23521218,189971378
        int[] A1 = {5621, 1743, 5532, 3549, 9581};
        int[] B1 = {913, 9787, 4121, 5039, 1481};
        System.out.println(Arrays.toString(a.advantageCount(A1, B1)));
    }
}
