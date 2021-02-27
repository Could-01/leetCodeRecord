package 数组;

import javafx.beans.binding.StringBinding;

import java.util.Arrays;

public class _43_字符串相乘 {
    public String multiply(String num1, String num2) {
        if (num1.charAt(0) == '0' || num2.charAt(0) == '0') return "0";
        int n1len = num1.length(), n2len = num2.length();
        if (n1len > n2len) {
            String tmp = num1;
            num1 = num2;
            num2 = tmp;
            n1len = num1.length();
            n2len = num2.length();
        }
        int[] index = new int[n1len * n2len + 1];
        int flag = index.length - 1;
        // 竖式下面的数
        for (int i = n1len - 1; i >= 0; i--) {
            // 竖式上面的数
            int n1 = num1.charAt(i) - '0';
            flag = index.length - 1 - (n1len - 1 - i);
            for (int j = n2len - 1; j >= 0; j--) {
                int n2 = num2.charAt(j) - '0';
                int sum = n1 * n2;
                if (index[flag] != 0) {
                    sum += index[flag];
                }
                if (sum < 10) {
                    index[flag--] = sum;
                } else {
                    int first = sum / 10;
                    int second = sum % 10;
                    index[flag] = second;
                    index[--flag] += first;
                }
            }
        }

        boolean b = true;
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < index.length; i++) {
            if (b && index[i] == 0) {
                continue;
            } else {
                sb.append(index[i]);
                b = false;
            }
        }
        return sb.toString();
    }


    public String multiply1(String num1, String num2) {
        if (num1.charAt(0) == '0' || num2.charAt(0) == '0') return "0";
        int n1len = num1.length(), n2len = num2.length();
        int[] index = new int[n1len + n2len + 2];
        int flag;
        // 竖式下面的数
        for (int i = n1len - 1; i >= 0; i--) {
            // 竖式上面的数
            int n1 = num1.charAt(i) - '0';
            flag = index.length - 1 - (n1len - 1 - i);
            for (int j = n2len - 1; j >= 0; j--) {
                int sum = n1 * (num2.charAt(j) - '0');
                sum += index[flag];
                index[flag] = sum % 10;
                index[--flag] += sum / 10;
            }
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < index.length; i++) {
            if (index[i] != 0) {
                for (; i < index.length; i++) {
                    sb.append(index[i]);
                }
            }
        }
        return sb.toString();
    }


    public static void main(String[] args) {
        _43_字符串相乘 a = new _43_字符串相乘();
        System.out.println(a.multiply1("99", "123"));
    }

}
