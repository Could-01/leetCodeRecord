package 栈;

import java.util.Stack;

public class _1249_移除无效的括号 {
    public String minRemoveToMakeValid(String s) {
        // int[0] 0代表"(", 1代表")" int[1] 表示index
        Stack<int[]> stack = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            if (ch == '(') {
                int[] arr = new int[]{0, i};
                stack.push(arr);
            } else if (ch == ')') {
                if (!stack.isEmpty()) {
                    int[] top = stack.peek();
                    if (top[0] == 0) {
                        stack.pop();
                        continue;
                    }
                }
                int[] arr = new int[]{1, i};
                stack.push(arr);
            }
        }
        StringBuilder sb = new StringBuilder(s);
        while (!stack.isEmpty()) {
            int[] a = stack.pop();
            sb.replace(a[1], a[1] + 1, String.valueOf(1));
        }
        String res = sb.toString();
        res = res.replace("1", "");
        return res;
    }

    public String minRemoveToMakeValid1(String s) {
        StringBuilder sb = new StringBuilder();
        int balance = 0;
        for (char c : s.toCharArray()) {
            if (c == '(') {
                balance++;
                sb.append(c);
            } else if (c == ')') {
                balance--;
                if (balance < 0) {
                    balance = 0;
                } else {
                    sb.append(c);
                }
            } else {
                sb.append(c);
            }
        }
        int i = sb.length() - 1;
        while (balance != 0) {
            if (sb.charAt(i) == '(') {
                balance--;
                sb.deleteCharAt(i);
            }
            i--;
        }
        return sb.toString();
    }


    public static void main(String[] args) {
        _1249_移除无效的括号 a = new _1249_移除无效的括号();
        System.out.println(a.minRemoveToMakeValid("(a(b(c)d)"));
    }
}
