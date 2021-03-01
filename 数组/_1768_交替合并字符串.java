package 数组;

public class _1768_交替合并字符串 {
    public String mergeAlternately(String word1, String word2) {
        int len1 = word1.length(), len2 = word2.length();
        int len = Math.max(len1, len2), index = 0;
        StringBuilder sb = new StringBuilder();
        while (index < len) {
            if (index < len1) sb.append(word1.charAt(index));
            if (index < len2) sb.append(word2.charAt(index));
            index++;
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        _1768_交替合并字符串 a = new _1768_交替合并字符串();
        System.out.println(a.mergeAlternately("ab", "pqrs"));

    }
}
