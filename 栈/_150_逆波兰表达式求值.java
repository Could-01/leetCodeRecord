package 栈;

import java.util.Stack;

public class _150_逆波兰表达式求值 {
    public int evalRPN(String[] tokens) {
        Stack<Integer> stack = new Stack<>();
        for (String s : tokens) {
            switch (s) {
                case "*":
                    stack.push(stack.pop() * stack.pop());
                    break;
                case "+":
                    stack.push(stack.pop() + stack.pop());
                    break;
                case "-":
                    stack.push(-(stack.pop() - stack.pop()));
                    break;
                case "/":
                    int x = stack.pop();
                    int y = stack.pop();
                    stack.push(y / x);
                    break;
                default:
                    stack.push(Integer.parseInt(s));
                    break;
            }
        }
        return stack.pop();
    }

    // 使用数组减少stack空间开支
    public int evalRPN1(String[] tokens) {
        int[] arr = new int[tokens.length / 2 + 1]; //定义一个数组用来存放字符数组内容
        int i = 0;
        for (String token : tokens) {
            switch (token) {
                case "+":
                    arr[i - 2] += arr[--i];  //遇到加法运算符就前两个相加
                    break;
                case "-":
                    arr[i - 2] -= arr[--i]; //遇到减法运算符就前两个相减
                    break;
                case "*":
                    arr[i - 2] *= arr[--i]; //遇到乘法运算符就前两个相乘
                    break;
                case "/":
                    arr[i - 2] /= arr[--i]; //遇到除法运算符就前两个相除
                    break;
                default:
                    arr[i++] = Integer.valueOf(token); //若没有遇到运算符就把字符串存放进数组
                    break;
            }
        }
        return arr[0]; //最后取数组第一个元素的值就是计算后的值

    }

    public static void main(String[] args) {
        _150_逆波兰表达式求值 a = new _150_逆波兰表达式求值();
        String[] data1 = {"10", "6", "9", "3", "+", "-11", "*", "/", "*", "17", "+", "5", "+"};
        String[] data = {"4", "13", "5", "/", "+"};
        System.out.print(a.evalRPN(data));
    }
}
