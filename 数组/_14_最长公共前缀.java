package 数组;

public class _14_最长公共前缀 {
    public String longestCommonPrefix(String[] strs) {
        int length = strs.length, StrLength, SbLength;
        if (length == 0) return "";
        StringBuilder sb = new StringBuilder(strs[0]);
        for (int i = 1; i < strs.length; i++) {
            String str = strs[i];
            StrLength = str.length();
            SbLength = sb.length();
            if (SbLength == 0 || StrLength == 0) return "";
            if (StrLength < SbLength) sb.delete(StrLength, SbLength);
            for (int j = 0; j < StrLength; j++) {
                if (str.charAt(j) != sb.charAt(j)) {
                    sb.delete(j, SbLength);
                    break;
                }
                if (j == SbLength - 1) break;
            }
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        _14_最长公共前缀 a = new _14_最长公共前缀();
        String[] data1 = {"a", "", ""};
        String[] data2 = {"flower", "flow", "flight"};
        String[] data = {"a", "b"};
        System.out.println(a.longestCommonPrefix(data1));
    }
}
