package 数组;

import java.util.Stack;

public class _125_验证回文串 {
    public boolean isPalindrome(String s) {
        Stack<Character> stack = new Stack<>();
        int length = s.length();
        s = s.toUpperCase();
        for (int i = 0; i < length; i++) {
            char ch = s.charAt(i);
            if (Character.isDigit(ch) || Character.isLetter(ch)) {
                stack.push(ch);
            }
        }
        for (int i = 0; i < length; i++) {
            char ch = s.charAt(i);
            if (Character.isDigit(ch) || Character.isLetter(ch)) {
                if (stack.size() == 0) return false;
                if (stack.pop() != ch) return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        _125_验证回文串 a = new _125_验证回文串();
        System.out.println(a.isPalindrome(".,"));
    }
}
