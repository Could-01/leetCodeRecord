package 数组;

import java.util.Arrays;

public class _1769_移动所有球到每个盒子所需的最小操作数 {
    public int[] minOperations(String boxes) {
        int len = boxes.length();
        int[] res = new int[len];
        // 此位置往右所有的1移到此处所走步数 <--
        int[] RightDp = new int[len + 1];
        // 此位置往左所有的1移到此处所走步数 -->
        int[] LeftDp = new int[len + 1];
        int record = 0;
        // 从右往左
        for (int i = len - 1; i >= 0; i--) {
            RightDp[i] = RightDp[i + 1] + record;
            if (boxes.charAt(i) == '1') record++;
        }
        //从左往右 -> 把字符倒过来就是了
        StringBuilder sb = new StringBuilder(boxes);
        record = 0;
        boxes = sb.reverse().toString();
        for (int i = len - 1; i >= 0; i--) {
            LeftDp[i] = LeftDp[i + 1] + record;
            if (boxes.charAt(i) == '1') record++;
        }
        for (int i = 0; i < len; i++) {
            res[i] = RightDp[i] + LeftDp[len - 1 - i];
        }
        return res;
    }

    public static void main(String[] args) {
        _1769_移动所有球到每个盒子所需的最小操作数 a = new _1769_移动所有球到每个盒子所需的最小操作数();
        System.out.println(Arrays.toString(a.minOperations("0")));
    }
}
