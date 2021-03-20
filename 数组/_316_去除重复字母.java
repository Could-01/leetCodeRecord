package 数组;

import java.util.*;

public class _316_去除重复字母 {
    public String removeDuplicateLetters(String s) {
        Stack<Character> stack = new Stack<>();
        int len = s.length();
        int[] record = new int[26];
        for (int i = 0; i < len; i++) {
            int flag = s.charAt(i) - 'a';
            record[flag]++;
        }

        // 如果某个元素剩余量为0，那么它之前的元素位置被确定 -> a_c_d < a_d_c
        boolean[] Use = new boolean[26]; //是否使用过这个字符
        for (int i = 0; i < len; i++) {
            char ch = s.charAt(i);
            int m = ch - 'a';
            while (stack.size() != 0) {
                char sp = stack.peek();
                if (sp >= ch && record[sp - 'a'] != 0 && !Use[m]) {
                    stack.pop();
                    if (sp != ch) Use[sp - 'a'] = false;
                } else {
                    break;
                }
            }
            // 如果这个元素没有被确定，添加
            if (!Use[m]) {
                stack.push(ch);
            }
            record[m]--;
            Use[m] = true;
        }
        StringBuilder sb = new StringBuilder();
        while (stack.size() != 0) sb.append(stack.pop());
        return sb.reverse().toString(); // acdb
    }


    public static void main(String[] args) {
        _316_去除重复字母 a = new _316_去除重复字母();
        System.out.println(a.removeDuplicateLetters( "cbacdcbc"));
    }
}
