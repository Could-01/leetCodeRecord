package 数组;


public class _剑指_Offer_51_数组中的逆序对 {
    public static void DecTest(int[] a) {
        // System.out.println(Arrays.toString(a));
        System.out.println("逆序对个数：" + mergeSort(a));

    }

    private static int mergeSort(int[] nums) {
        int count = 0;
        int n = nums.length;
        if (n <= 1) {
            return 0;
        }
        int[] b = new int[n / 2];
        System.arraycopy(nums, 0, b, 0, n / 2);
        int[] c;
        if (n % 2 == 0) {
            c = new int[n / 2];
            System.arraycopy(nums, n / 2, c, 0, n / 2);
        } else {
            c = new int[n / 2 + 1];
            System.arraycopy(nums, n / 2, c, 0, n / 2 + 1);
        }

        count += mergeSort(b);
        count += mergeSort(c);
        count += merge(b, c, nums);
        return count;
    }

    private static int merge(int[] b, int[] c, int[] a) {
        int count = 0;      //标志
        int i = 0, j = 0, k = 0;
        int p = b.length, q = c.length;
        while (i < p && j < q) {
            if (b[i] <= c[j]) {
                a[k] = b[i];
                i++;
            } else {
                a[k] = c[j];
                j++;
                count += p - i;     //记录逆序对个数
            }
            k++;
        }
        if (i == p) {
            for (; j < q; j++, k++) {
                a[k] = c[j];
            }
        } else if (j == q) {
            for (; i < p; i++, k++) {
                a[k] = b[i];
            }
        }
        return count;
    }


    public static void main(String[] args) {
        _剑指_Offer_51_数组中的逆序对 c = new _剑指_Offer_51_数组中的逆序对();
        System.out.print(5 >> 1);
        int[] a = new int[2];
        a[0] = 1;
        int[] b = new int[1];

//        int a[];
//        int n = (int) (Math.random() * 1000000 + 1);
//        a = new int[n];
//        for (int i = 0; i < n; i++) {
//            a[i] = (int) (Math.random() * 10);
//        }
//        long t = System.currentTimeMillis();
//        DecTest(a);
//        System.out.print("耗时：");
//        System.out.println(System.currentTimeMillis() - t);

    }
}
