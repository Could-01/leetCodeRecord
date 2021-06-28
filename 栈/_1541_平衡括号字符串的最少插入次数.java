package 栈;

public class _1541_平衡括号字符串的最少插入次数 {
    public int minInsertions(String s) {
        int left = 0;
        int res = 0;
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            if (ch == '(') {
                left++;
            } else {
                if (left == 0) {
                    res++;
                } else {
                    left--;
                }

                if (i == s.length() - 1 || s.charAt(i + 1) != ')') {
                    res++;
                } else {
                    i++;
                }
            }
        }
        return res + left * 2;
    }

    public static void main(String[] args) {
        _1541_平衡括号字符串的最少插入次数 a = new _1541_平衡括号字符串的最少插入次数();
        System.out.println(a.minInsertions("(()))"));
    }

}
