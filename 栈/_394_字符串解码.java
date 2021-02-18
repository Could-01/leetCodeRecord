package 栈;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Stack;

public class _394_字符串解码 {
    private static int index;

    public static String decodeString(String s) {
        //使用递归 使用index标记，递归函数出来的位置，
        int num = 0;
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) >= '0' && s.charAt(i) <= '9') {
                num = num * 10 + s.charAt(i) - '0';
            } else if (s.charAt(i) == '[') {
                String tmp = decodeString(s.substring(i + 1));
                for (int j = 0; j < num; j++)
                    sb.append(tmp);
                num = 0;
                i = s.length() - index; //从递归函数结尾处开始计算
            } else if (s.charAt(i) == ']') {
                index = s.length() - i; //由于传入的是后半截，这里保存的是和结束位置相对的距离
                break;
            } else
                sb.append(s.charAt(i));
        }
        return sb.toString();
    }

    public static String decodeString2(String s) {
        //中间替换， 最右边的[ 以及从它索引开始的最左边的 ] 计算好以后替换
        StringBuilder sb = new StringBuilder(s);
        while (sb.indexOf("[") != -1) {
            int leftIndex = sb.lastIndexOf("[");
            int rightIndex = sb.indexOf("]", leftIndex);
            String str = sb.substring(leftIndex + 1, rightIndex);
            int i = leftIndex - 1, count = 0, base = 1;
            while (i >= 0 && Character.isDigit(sb.charAt(i))) {
                count += base * (sb.charAt(i) - '0');
                base *= 10;
                i--;
            }
            StringBuilder tmp = new StringBuilder();
            for (int j = 0; j < count; j++) tmp.append(str);
            sb = sb.replace(i + 1, rightIndex + 1, tmp.toString());
        }
        return sb.toString();
    }

    public static String decodeString3(String s) {
        //使用双栈 一个记录数字，一个记录数字之前的字符串
        Stack<Integer> iStack = new Stack<>();
        Stack<String> sStack = new Stack<>();
        StringBuilder sb = new StringBuilder();
        int num = 0;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) >= '0' && s.charAt(i) <= '9') {
                num = num * 10 + s.charAt(i) - '0';
            } else if (s.charAt(i) == '[') { //保存双栈必要信息
                iStack.push(num);
                num = 0;
                sStack.push(sb.toString());
                sb = new StringBuilder();
            } else if (s.charAt(i) == ']') { //结算sb中全部数据
                int n = iStack.pop();
                String tmp = sb.toString();
                for (int j = 1; j < n; j++) {
                    sb.append(tmp);
                }
                sb = new StringBuilder(sStack.pop() + sb.toString());
            } else {
                sb.append(s.charAt(i));
            }
        }
        return sb.toString();
    }

    public static void main(String[] args) {
    }
}
