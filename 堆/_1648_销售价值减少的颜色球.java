package 堆;

import java.util.Arrays;

public class _1648_销售价值减少的颜色球 {
    int MOD = (int) (1e9 + 7);
    long ans = 0;

    public int maxProfit(int[] inventory, int orders) {
        int[] temp = new int[inventory.length + 1];
        for (int i = 0; i < inventory.length; i++) {
            temp[i] = inventory[i];
        }
        temp[inventory.length] = 0;
        Arrays.sort(temp);
        for (int i = temp.length - 1; i >= 1; i--) {
            long sub = (temp[i] - temp[i - 1]) * (temp.length - i);
            if (orders >= sub) {
                long s = temp[i - 1] + 1;
                long t = temp[i];
                long num = t - s + 1;
                ans = (ans + (((s + t) * num / 2) % MOD) * (temp.length - i)) % MOD;
                orders -= sub;
            } else {
                long num = orders / (temp.length - i);
                long t = temp[i];
                long s = t - num + 1;
                ans = (ans + (((s + t) * num / 2) % MOD) * (temp.length - i)) % MOD;
                long r = orders % (temp.length - i);
                ans = (ans + (r * (t - num))) % MOD;
                break;
            }
        }
        return (int) (ans % MOD);
    }


    // 不知道错哪里了
    public int maxProfit1(int[] inventory, int orders) {
        int length = inventory.length;
        long res = 0;
        Arrays.sort(inventory);
        if (length == 1) { // 只有一个
            long num = inventory[0];
            res = (long) orders * (num + (num - orders + 1)) / 2;
            orders = 0;
        }
        for (int i = length - 1; i >= 0; i--) {
            if (orders == 0) break;
            long num = inventory[i];
            int flag = i;
            while (flag > 0 && inventory[flag] == num) {
                flag--;
            }
            if (inventory[flag] < num) { // 找到了一个小的
                // 1 7 7
                int gap = i - flag;
                long gap_num = num - inventory[flag]; // 中间相差多少
                if (gap_num * gap <= orders) { // 如果支持取出全部大于的数
                    long tmp = gap_num * (num + (num - gap_num + 1)) / 2; // 隔的数的总和
                    for (; i > flag; i--) {
                        orders -= gap_num;
                        inventory[i] = inventory[flag];
                        res += tmp;
                    }
                } else {
                    long n = orders / gap_num;
                    int r = orders % gap;
                    res += (long) gap * n * (num + (num - n + 1)) / 2; //找到统一拿的
                    res += (long) r * (num - n); //额外再拿几个
                    orders = 0;
                }
                i = length;
            } else { //没有更小的了
                int n = orders / length;
                int r = orders % length;
                res += (long) length * n * (num + (num - n + 1)) / 2; //找到统一拿的
                res += (long) r * (num - n); //额外再拿几个
                orders = 0;
            }
        }
        return (int) (res % 1000000007);
    }


    public static void main(String[] args) {
        _1648_销售价值减少的颜色球 a = new _1648_销售价值减少的颜色球();
//        int[] data = {2, 8, 4, 10, 6};
//        int[] data = {773160767};
        int[] data = {497978859, 167261111, 483575207, 591815159};
//        int[] data = {1000000000};
        System.out.println(a.maxProfit(data, 836556809));
    }
}
