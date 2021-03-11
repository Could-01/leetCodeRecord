package 数组;

public class _859_亲密字符串 {
    public boolean buddyStrings(String a, String b) {
        int lena = a.length(), lenb = b.length();
        if (lena != lenb) return false;
        int[] arr_a = new int[lena];
        int[] arr_b = new int[lenb];
        int count = 0, index = 0;
        for (int i = 0; i < lena; i++) {
            arr_a[i] = a.charAt(i) - 97;
        }
        for (int i = 0; i < lena; i++) {
            arr_b[i] = b.charAt(i) - 97;
        }
        while (index < lena) {
            if (arr_a[index] != arr_b[index]) count++;
            index++;
            if (index == lena - 1 && count > 2) return false;
        }
        return true;
    }

    public static void main(String[] args) {
        _859_亲密字符串 a = new _859_亲密字符串();
        System.out.println(a.buddyStrings("aaaaaaabc", "aaaaaaacb"));
    }
}
