package 栈;

import java.util.Arrays;

public class _1209_删除字符串中的所有相邻重复项II {
    public String removeDuplicates(String s, int k) {
        char[] ss = s.toCharArray();
        int index = 0, len = ss.length;//模拟栈大小
        char[] chStack = new char[len];//字符栈
        int[] numStack = new int[len];//计数栈
        for (char ch : ss) {
            // deeedbbcccbdaa
            // 栈为空或者ch和栈顶元素不相同，入栈，并初始化连续出现数量为1
            if (index == 0 || chStack[index - 1] != ch) {
                chStack[index] = ch;
                numStack[index++] = 1;
            } else if (chStack[index - 1] == ch) {
                // 字符栈顶元素已连续出现k-1次，且加上当前字符后满足连续k个，2个栈顶都出栈
                if (numStack[index - 1] + 1 == k) {
                    index--;
                } else {
                    // 与字符栈顶元素相同但未满足k，计数栈栈顶加1
                    numStack[index - 1]++;
                }
            }
        }
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < index; i++) {
            for (int j = 0; j < numStack[i]; j++) {
                sb.append(chStack[i]);
            }
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        _1209_删除字符串中的所有相邻重复项II a = new _1209_删除字符串中的所有相邻重复项II();
        System.out.println(a.removeDuplicates("deeedbbcccbdaa", 3));
    }
}
