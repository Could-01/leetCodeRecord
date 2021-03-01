package 数组;

public class _50_Pow {
    public double myPow(double x, int n) {
        if (x == 0.0f) return 0.0d;
        long b = n;
        double res = 1.0;
        if (b < 0) {
            x = 1 / x;
            b = -b;
        }
        while (b > 0) {
            if ((b & 1) == 1) res *= x;
            x *= x;
            b >>= 1;
        }
        return res;
    }


    public static void main(String[] args) {
        _50_Pow a = new _50_Pow();
        System.out.println(a.myPow(2.00000, 10));
    }
}
