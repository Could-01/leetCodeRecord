package 栈;

public class _880_索引处的解码字符串 {
    public static String decodeAtIndex(String S, int K) {

        char[] s = S.toCharArray();
        int index = -1;
        long size = 0;

        for (char c : S.toCharArray()) {
            index++;
            if (Character.isDigit(c)) {
                size *= c - '0';
            } else {
                size++;
            }
            if (size >= K) break;
        }
        // hahahaha
        for (int i = index; i >= 0; i--) {
            K %= size;
            // K一定比size小,所以当 k==0 时表示已经到达预定地点
            if (K == 0 && Character.isLetter(s[i])) return String.valueOf(s[i]);
            if (Character.isDigit(s[i])) {
                size /= s[i] - '0';
            } else size--;
        }
        return "-1";
    }

    public static void main(String[] args) {
        String res = "leet2code3";
        System.out.println(decodeAtIndex(res, 7));
    }
}