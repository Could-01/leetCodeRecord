package 动态规划;

public class _1014_最佳观光组合 {
    public int maxScoreSightseeingPair(int[] values) {
        int MaxScore = Integer.MIN_VALUE, left = values[0];
        for (int i = 1; i < values.length; i++) {
            MaxScore = Math.max(MaxScore, values[i] - i + left);  //更新 最大值
            left = Math.max(left, values[i] + i);  //更新 values[i] + i
        }
        return MaxScore;
    }

    public static void main(String[] args) {
        _1014_最佳观光组合 a = new _1014_最佳观光组合();
        int[] data = {8, 1, 5, 2, 6};
        System.out.println(a.maxScoreSightseeingPair(data));
    }
}
