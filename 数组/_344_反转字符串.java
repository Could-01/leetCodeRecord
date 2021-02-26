package 数组;

import java.util.Arrays;

public class _344_反转字符串 {
    public void reverseString(char[] s) {
        int length = s.length - 1;
        if (length < 1) return;
        for (int i = length >> 1; i >= 0; i--) {
            int j = length - i;
            char c = s[i];
            s[i] = s[j];
            s[j] = c;
        }
    }


    public static void main(String[] args) {
        _344_反转字符串 a = new _344_反转字符串();
        char[] s = {'h', 'e', 'l', 'l', 'o'};
        a.reverseString(s);
        System.out.println(Arrays.toString(s));
    }
}
