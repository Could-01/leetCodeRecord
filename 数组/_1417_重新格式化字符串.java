package 数组;

public class _1417_重新格式化字符串 {
    public String reformat(String s) {
        char[] chars = s.toCharArray();
        int size = chars.length;
        if (size == 1) return s;
        int sum = 0;
        for (char ch : chars) {
            if (Character.isDigit(ch)) sum++;
        }
        if (Math.abs(sum * 2 - size) > 1) return "";
        for (int i = 1; i < size; i++) {
            if (Character.isDigit(chars[i - 1]) && Character.isAlphabetic(chars[i])) continue;
            if (Character.isDigit(chars[i]) && Character.isAlphabetic(chars[i - 1])) continue;
            if (Character.isDigit(chars[i - 1])) {
                for (int e = size - 1; e > i; e--) {
                    if (Character.isAlphabetic(chars[e])) {
                        char tmp = chars[i];
                        chars[i] = chars[e];
                        chars[e] = tmp;
                        break;
                    }
                }
            } else {
                for (int k = size - 1; k > i; k--) {
                    if (Character.isDigit(chars[k])) {
                        char tmp = chars[i];
                        chars[i] = chars[k];
                        chars[k] = tmp;
                        break;
                    }
                }
            }
        }
        StringBuilder sb = new StringBuilder();
        if (Character.isDigit(chars[size - 1]) && Character.isDigit(chars[size - 2])) {
            sb.append(chars[size - 1]);
            for (int i = 0; i < size - 1; i++) {
                sb.append(chars[i]);
            }
        } else if (!Character.isDigit(chars[size - 1]) && !Character.isDigit(chars[size - 2])) {
            sb.append(chars[size - 1]);
            for (int i = 0; i < size - 1; i++) {
                sb.append(chars[i]);
            }
        } else {
            sb.append(chars);
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        _1417_重新格式化字符串 a = new _1417_重新格式化字符串();
//        System.out.println(a.reformat("a0b1c2"));
        System.out.println(a.reformat("jk"));
    }
}
