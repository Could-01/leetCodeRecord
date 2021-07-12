package 数组;

public class _1411_给Nx3网格图涂色的方案数 {

    /*
    在第一层可以摆出6个ABA类型的和6个ABC类型的涂法。
    对于下面每一层，每一个ABA涂法可以拼接2个ABC涂法和3个ABA涂法，
    每一个ABC涂法可以拼接2个ABC涂法和2个ABA涂法。
    这样迭代可以算出第N层有几种ABA涂法和ABC涂法，相加就是答案。
    */
    public int numOfWays(int n) {
        // dpi 表示使用 i 种颜色组成网格
        // 当 n 为 1 时没有上一个网格的限制
        long dp2 = 6, dp3 = 6, mod = 1000000007;
        // 注意加法、乘法中任何可能溢出 1e9+7 的地方都要进行取模
        for (int i = 1; i < n; i++) {
            long temp2 = dp2;
            long temp3 = dp3;
            // 若当前使用 2 种颜色组成网格
            // 如果上一个网格是 2 种颜色，则当前网格有 3 种可能
            // 如果上一个网格是 3 种颜色，则当前网格有 2 种可能
            dp2 = (temp2 * 3 % mod + temp3 * 2 % mod) % mod;
            // 若当前使用 3 种颜色组成网格
            // 如果上一个网格是 2 种颜色，则当前网格有 2 种可能
            // 如果上一个网格是 3 种颜色，则当前网格有 2 种可能
            dp3 = (temp2 * 2 % mod + temp3 * 2 % mod) % mod;
        }
        return (int) ((dp2 + dp3) % mod);
    }

    public static void main(String[] args) {
        _1411_给Nx3网格图涂色的方案数 a = new _1411_给Nx3网格图涂色的方案数();
        System.out.println(a.numOfWays(1));
    }
}
