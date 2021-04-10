package 数组;

public class _495_提莫攻击 {
    public int findPoisonedDuration(int[] timeSeries, int duration) {
        if (timeSeries.length == 0) {
            return 0;
        }
        int res = 0;
        for (int i = 0; i < timeSeries.length - 1; i++) {
            if (timeSeries[i + 1] - timeSeries[i] >= duration) {
                res += duration;
            } else {
                res += (timeSeries[i + 1] - timeSeries[i]);
            }
        }
        res += duration;
        return res;

    }

    public static void main(String[] args) {
        _495_提莫攻击 a = new _495_提莫攻击();
        int[] data = {1, 4};
        System.out.println(a.findPoisonedDuration(data, 2));
    }
}
