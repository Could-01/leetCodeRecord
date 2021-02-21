package 数组;

public class _395_至少有K个重复字符的最长子串 {
    // 1. 分治
    // 前提：若当前子串中存在总出现次数<k的字符，该子串一定不满足题目要求
    // 此时以该字符为界，递归前后子串
    public int longestSubstring(String s, int k) {
        int[] cnt = new int[26];
        int n = s.length();
        if (n < k) {
            return 0;
        }
        for (int i = 0; i < s.length(); i++) {
            cnt[s.charAt(i) - 'a']++;
        }
        int l = 0;
        int res = 0;
        for (int r = 0; r < n; r++) {
            if (cnt[s.charAt(r) - 'a'] < k) {
                res = Math.max(res, longestSubstring(s.substring(l, r), k));
                l = r + 1;
            }
        }
        return l == 0 ? n : Math.max(res, longestSubstring(s.substring(l, n), k));
    }

    public static void main(String[] args) {
        _395_至少有K个重复字符的最长子串 a = new _395_至少有K个重复字符的最长子串();
        System.out.println(a.longestSubstring("ababbc", 2));
    }
}
