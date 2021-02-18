package 数组;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class _888_公平的糖果棒交换 {
    public int[] fairCandySwap(int[] A, int[] B) {
        int diff = 0;
        int[] res = new int[2];
        Set<Integer> dicB = new HashSet();
        diff += Arrays.stream(A).sum();
        diff -= Arrays.stream(B).sum();
        for (int b : B) {
            dicB.add(b);
        }
        for (int a : A) {
            if (dicB.contains(a - diff / 2)) {
                res[0] = a;
                res[1] = a - diff / 2;
                return res;
            }
        }
        return res;
    }

    public static void main(String[] args) {
        boolean[] a = new boolean[3];
        for (boolean b : a) {
            System.out.println(b);
        }

    }
}

class Test_888 {
    // 使用 布尔类型 数组来标记是否出现过。
    public int[] fairCandySwap(int[] A, int[] B) {
        int diff = 0;
        boolean[] flags = new boolean[100001];
        for (int num : A)
            diff -= num;
        for (int num : B) {
            diff += num;
            flags[num] = true;
        }
        diff /= 2;
        System.out.println(diff);
        for (int num : A) {
            int numB = num + diff;
            if (numB > 0 && numB < 100001 && flags[numB])
                return new int[]{num, num + diff};
        }
        return null;
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(new Test_888().fairCandySwap(new int[]{1, 2, 5}, new int[]{2, 4})));
    }
}