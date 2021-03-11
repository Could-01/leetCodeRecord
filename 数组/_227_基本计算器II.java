package 数组;

public class _227_基本计算器II {
    int length = 0;

    public int calculate(String s) {
        length = s.length();
        int sign = 1, tmp = 0, res = 0, X = 0;
        char lasting = '+';
        for (int i = 0; i < length; i++) {
            while (s.charAt(i) == ' ') i++;
            char ch = s.charAt(i);
            if (Character.isDigit(ch)) {
                int cur = getcount(s, i);
                while (i + 1 < length && (s.charAt(i + 1) == ' ' || Character.isDigit(s.charAt(i + 1)))) i++;
                tmp = sign * cur;
                res += tmp;
            } else if (ch == '+') {
                sign = 1;
                lasting = '+';
            } else if (ch == '-') {
                sign = -1;
                lasting = '-';
            } else if (ch == '*') {
                int cur = getcount(s, i + 1);
                while (i + 1 < length && (s.charAt(i + 1) == ' ' || Character.isDigit(s.charAt(i + 1)))) i++;
                if (lasting == '-' || lasting == '+') {
                    res -= tmp;
                    res += (tmp * cur);
                    X = tmp * cur;
                } else {
                    res -= X;
                    res += X * cur;
                    X = X * cur;
                }

                tmp = cur;
                lasting = '*';
            } else if (ch == '/') {
                int cur = getcount(s, i + 1);
                while (i + 1 < length && (s.charAt(i + 1) == ' ' || Character.isDigit(s.charAt(i + 1)))) i++;
                if (lasting == '-' || lasting == '+') {
                    res -= tmp;
                    res += (tmp / cur);
                    X = tmp / cur;
                } else {
                    res -= X;
                    res += X / cur;
                    X = X / cur;
                }
                tmp = cur;
                lasting = '/';
            }
        }
        return res;
    }

    private int getcount(String s, int start) {
        while (start < length && s.charAt(start) == ' ') start++;
        int cur = s.charAt(start) - '0';
        while (start + 1 < length && (Character.isDigit(s.charAt(start + 1)) || s.charAt(start + 1) == ' ')) {
            while (start + 1 < length && s.charAt(start + 1) == ' ') start++;
            if (start + 1 < length && Character.isDigit(s.charAt(start + 1))) cur = cur * 10 + s.charAt(++start) - '0';
        }
        return cur;
    }

    public static void main(String[] args) {
        _227_基本计算器II a = new _227_基本计算器II();
        System.out.println(a.calculate("1+2*5/3+6/4*2"));
        System.out.println(a.calculate("2*3*4*5"));
        System.out.println(2 * 3 * 4 * 5);
    }
}
