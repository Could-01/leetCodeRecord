package 动态规划;

public class _397_整数替换 {
    public int integerReplacement(int n) {
        if (n == Integer.MAX_VALUE)
            return 32;
        if (n <= 3)
            return n - 1;
        if (n % 2 == 0)
            return integerReplacement(n / 2) + 1;
        else
            return (n & 2) == 0 ? integerReplacement(n - 1) + 1 : integerReplacement(n + 1) + 1;
    }

    public static void main(String[] args) {
        _397_整数替换 a = new _397_整数替换();
        System.out.println(a.integerReplacement(7));
    }
}
