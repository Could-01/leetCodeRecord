package 数组;

public class _1052_爱生气的书店老板 {
    public int maxSatisfied(int[] customers, int[] grumpy, int X) {
        int len = customers.length, sum = 0, max = 0, tmp = 0;
        if (X == len - 1) {
            for (int i = 0; i < len; i++) {
                sum += customers[i];
            }
            return sum;
        }
        for (int i = 0; i < len; i++) {
            if (grumpy[i] == 0) {
                sum += customers[i];
                customers[i] = 0;
            }
        }
        for (int i = 0; i < X; i++) {
            max += customers[i];
        }
        tmp = max;
        for (int i = 1; i < len - X + 1; i++) {
            tmp -= customers[i - 1] - customers[i + X - 1];
            max = Math.max(max, tmp);
        }
        return sum + max;
    }

    public static void main(String[] args) {
        _1052_爱生气的书店老板 a = new _1052_爱生气的书店老板();
        int[] customers = {1, 0, 1, 2, 1, 1, 7, 5};
        int[] grumpy = {0, 1, 0, 1, 0, 1, 0, 1};
        System.out.println(a.maxSatisfied(customers, grumpy, 3));
    }
}
