package 栈;

import java.util.Stack;

public class _1047_删除字符串中的所有相邻重复项 {
    public String removeDuplicates(String S) {
        StringBuilder sb = new StringBuilder();
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < S.length(); i++) {
            char ch = S.charAt(i);
            if (!stack.isEmpty() && stack.peek() == ch) {
                stack.pop();
            } else {
                stack.push(ch);
            }
        }
        while (!stack.isEmpty()) {
            sb.append(stack.pop());
        }
        return sb.reverse().toString();
    }

    public static void main(String[] args) {
        _1047_删除字符串中的所有相邻重复项 a = new _1047_删除字符串中的所有相邻重复项();
        System.out.println(a.removeDuplicates("aababaab"));
    }
}
