package 数组;

public class _1482_制作m束花所需的最少天数 {
    public int minDays(int[] bloomDay, int m, int k) {
        // 首先想的是n(log10 ^ 9)
        int left = 1, right = (int) 1e9;
        int n = bloomDay.length;
        if (m * (long) k > n) {
            return -1;
        }
        while (left < right) {
            int mid = (left + right) / 2;
            // 开始检测
            int i;
            int temp = 0;
            int tempCount = m;
            for (i = 0; i < n; i++) {
                if (bloomDay[i] <= mid) {
                    temp++;
                    if (temp >= k) {
                        tempCount--;
                        temp = 0;
                    }
                } else {
                    temp = 0;  //前面的不能用了
                }
            }
            if (tempCount > 0) left = mid + 1;
            else right = mid;
        }
        return right;
    }

    public static void main(String[] args) {
        _1482_制作m束花所需的最少天数 a = new _1482_制作m束花所需的最少天数();
        int[] data = {1, 10, 3, 10, 2};
        System.out.println(a.minDays(data, 3, 1));
    }
}
