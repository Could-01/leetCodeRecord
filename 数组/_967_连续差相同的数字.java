package 数组;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class _967_连续差相同的数字 {
    List<Integer> list = new ArrayList<>();

    public int[] numsSameConsecDiff(int n, int k) {
        for (int i = 1; i < 10; i++) {
            Test(1, i, k, n);
        }
        int size = list.size();
        int[] res = new int[size];
        for (int i = 0; i < size; i++) {
            res[i] = list.get(i);
        }
        return res;
    }

    void Test(int index, int num, int differ, int length) {
        if (index == length) {
            list.add(num);
            return;
        }
        int lastnum = num % 10; //获取个位上的数
        int num1 = lastnum + differ;
        int num2 = lastnum - differ;
        if (num1 >= 0 && num1 < 10) {
            Test(index + 1, num * 10 + num1, differ, length);
        }
        if (num2 != num1 && num2 >= 0 && num2 < 10) {
            Test(index + 1, num * 10 + num2, differ, length);
        }
    }


    public static void main(String[] args) {
        _967_连续差相同的数字 a = new _967_连续差相同的数字();
        int[] res = a.numsSameConsecDiff(2, 0);
        System.out.println(Arrays.toString(res));
    }
}
