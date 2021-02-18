package 数组;

import java.util.Arrays;

public class _6_Z字形变换 {
    public String convert(String s, int numRows) {
        String[] stringArr = s.split("");
        if (numRows >= s.length()) return s;
        StringBuilder sb = new StringBuilder();
        boolean flag = true;
        int sp = (numRows - 1) * 2;
        int a = 0;
        while (a <= stringArr.length) {
            sb.append(stringArr[a]);
            a += sp;
        }
        for (int i = 1; i < numRows - 1; i++) {
            sb.append(stringArr[i]);
            int row = i + (numRows - (i + 1)) * 2;
            int tmp = row - i;
            while (row < stringArr.length) {
                sb.append(stringArr[row]);
                if (flag) {
                    row += 2 * i;
                    flag = false;
                } else {
                    row += tmp;
                    flag = true;
                }
            }
            flag = true;
        }
        int b = numRows - 1;
        while (b < stringArr.length) {
            sb.append(stringArr[b]);
            b += sp;
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        _6_Z字形变换 a = new _6_Z字形变换();
        //System.out.print(a.convert("012345678901234567890", 5));
        System.out.print(a.convert("PAYPALISHIRING", 4));
//        String string = "abc";
//        String[] stringArr = string.split("");
//        System.out.print(Arrays.toString(stringArr));
    }
}

class Test_6 {
    public String convert(String s, int numRows) {
        if (numRows <= 1) return s;
        StringBuffer stringBuffer = new StringBuffer();
        for (int i = 0; i < numRows; i++) {
            int index = 0;
            while (index - i < s.length()) {
                if (i != 0 && i != (numRows - 1)) {
                    if (index - i > 0) {
                        stringBuffer.append(s.charAt(index - i));
                    }
                }
                if (index + i < s.length()) {
                    stringBuffer.append(s.charAt(index + i));
                }
                index = index + (2 * (numRows - 1));
            }
        }
        return stringBuffer.toString();
    }

    public static void main(String[] args) {
        Test_6 a = new Test_6();
        System.out.println(a.convert("PAYPALISHIRING", 3));
    }
}