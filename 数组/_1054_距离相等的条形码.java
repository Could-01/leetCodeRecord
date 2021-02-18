package 数组;

import java.util.*;

public class _1054_距离相等的条形码 {

    public int[] rearrangeBarcodes(int[] barcodes) {
//        int[] arr = new int[10001];
        int[] arr = new int[10];
        for (int barcode : barcodes) {
            arr[barcode]++;
        }
        System.out.println(Arrays.toString(arr));
        int len = barcodes.length, even = 0, odd = 1, count = 0;
        int[] re = new int[len];
        for (int i = 0; i < 10001; i++) {
            System.out.println("even : " + even);
            if (arr[i] == 0) {
                continue;
            }
            while (arr[i] > 0 && arr[i] < (len / 2 + 1) && odd < len) {
                re[odd] = i;
                System.out.println("re = " + Arrays.toString(re) + " odd = " + odd);
                count++;
                arr[i]--;
                odd += 2;
            }

            while (arr[i] > 0) {
                re[even] = i;
                count++;
                arr[i]--;
                even += 2;
            }
//            System.out.println("re : " + Arrays.toString(re));
            if (count == len) {
                break;
            }
        }
        return re;
    }


    public static void main(String[] args) {
        _1054_距离相等的条形码 a = new _1054_距离相等的条形码();
        int[] data = {3, 7, 3, 7, 7, 7, 7, 2, 2, 2};
        int[] data2 = {2, 2, 1, 3};
        int[] data1 = {0, 0, 2};
        System.out.println(Arrays.toString(a.rearrangeBarcodes(data1)));
    }
}
