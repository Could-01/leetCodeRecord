package 栈;

import java.util.Stack;

public class _921_使括号有效的最少添加 {
    public int minAddToMakeValid(String S) {
        Stack<Character> stack = new Stack<>();
        for(int i = 0; i< S.length(); i++){
            char ch = S.charAt(i);
            if (!stack.isEmpty() && stack.peek() == '(' && ch == ')'){
                    stack.pop();
                    continue;
            }
            stack.push(ch);
        }
        return stack.size();
    }

    public static void main(String[] args) {
        _921_使括号有效的最少添加 a = new _921_使括号有效的最少添加();
        String data = "()";
        System.out.println(a.minAddToMakeValid(data));
    }
}
