package 栈;

public class _402_移掉K位数字 {
    // 删除高位
    public static String removeKdigits(String num, int k) {
        StringBuilder sb = new StringBuilder(num);
        //1432219
        for (int i = 0; i < k; i++) sb.deleteCharAt(index(sb));
        if (sb.length() == 0) return "0";
        //删除前导0，若全是0，保留最后位
        while (sb.length() != 1 && sb.charAt(0) == '0') {
            sb.deleteCharAt(0);
        }
        return sb.toString();
    }

    public static int index(StringBuilder sb) {//返回有下降趋势的位置，没有返回最后位
        int end = sb.length() - 1;
        for (int i = 0; i < end; i++) {
            if (sb.charAt(i) > sb.charAt(i + 1)) {
                System.out.println(i);
                return i;
            }
        }
        return end;
    }

    public static void main(String[] args) {

        System.out.println(removeKdigits("1432219", 3));
    }

}

