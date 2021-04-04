package 数组;

public class _859_亲密字符串 {
    public boolean buddyStrings(String a, String b) {
        int length = a.length();
        if (b.length() != length || length == 0) return false;
        int[] arr = new int[26];
        char[] ch = a.toCharArray();
        boolean repeat = false;
        for (int i = 0; i < length; i++) {
            int index = a.charAt(i) - 97;
            arr[index]++;
            if (arr[index] > 1) repeat = true;
        }
        if (a.equals(b)) {
            return repeat;
        }

        for (int i = 0; i < length; i++) {
            int ca = a.charAt(i), cb = b.charAt(i);
            if (ca != cb) { // 如果a和b在i处不相同
                if (arr[cb - 97] == 0) { // 如果在a中不存在b的元素
                    return false;
                } else {
                    int pos = i;
                    for (; i < length; i++) {
                        if (ch[i] == cb) {
                            char tmp = ch[i];
                            ch[i] = ch[pos];
                            ch[pos] = tmp;
                            break;
                        }
                    }
                    break;
                }
            }
        }

        for (int i = 0; i < length; i++) {
            if (b.charAt(i) != ch[i]) return false;
        }

        return true;
    }

    public static void main(String[] args) {
        _859_亲密字符串 a = new _859_亲密字符串();
        System.out.println(a.buddyStrings("abcd", "badc"));
    }
}
