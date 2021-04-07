package 数组;

import java.util.Arrays;

public class _739_每日温度 {
    public int[] dailyTemperatures(int[] T) {
        int length = T.length;
        int[] res = new int[length];
        int max = T[length - 1];
        for (int i = length - 1; i > -1; i--) {
            int num = T[i];
            //右侧没有比它大的了
            if (max <= num) {
                max = num;
                res[i] = 0;
                continue;
            }
            //右侧有比它大的
            int cur = i + 1;
            while (cur < length && T[cur] <= num) {
                if (T[cur + 1] > num) {
                    cur += 1;
                    break;
                }
                cur += res[cur + 1]; //右侧第一个
            }
            res[i] = cur - i;
        }
        return res;
    }

    public static void main(String[] args) {
        _739_每日温度 a = new _739_每日温度();
        int[] T = {73, 74, 75, 71, 69, 72, 76, 73};
        int[] T1 = {55, 38, 53, 81, 61, 93, 97, 32, 43, 78};
        //[3,1,1,2,1,1,0,1,1,0]

        //          1, 1, 4, 2, 1, 1, 0, 0
        System.out.println(Arrays.toString(a.dailyTemperatures(T)));
    }
}
