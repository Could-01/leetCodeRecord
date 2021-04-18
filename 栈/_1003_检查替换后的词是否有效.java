package 栈;

import java.util.Stack;

public class _1003_检查替换后的词是否有效 {
    public boolean isValid(String s) {
        char[] arrs = s.toCharArray();
        if (arrs.length < 3) return false;
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < arrs.length; i++) {
            char ch = arrs[i];
            if (stack.isEmpty() && ch != 'a') return false;
            if (ch == 'c') {
                if (!stack.isEmpty() && stack.peek() == 'b') {
                    stack.pop();
                    if (!stack.isEmpty() && stack.peek() == 'a') {
                        stack.pop();
                    } else {
                        stack.push('b');
                    }
                } else {
                    stack.push(ch);
                }
            } else {
                stack.push(ch);
            }
        }
        return stack.size() == 0;
    }


    public static void main(String[] args) {
        _1003_检查替换后的词是否有效 a = new _1003_检查替换后的词是否有效();
        System.out.println(a.isValid("abacbcabcc"));
    }
}
