package 数组;

public class _567_字符串的排列 {
    // 滑动窗口

    public boolean checkInclusion(String s1, String s2) {
        int n = s2.length();
        int[] dict = new int[26];
        int[] freq = new int[26];
        int size = 0;
        for (char c : s1.toCharArray()) {
            if (dict[c - 'a'] == 0) size++;
            dict[c - 'a']++;
        }
        int match = 0;
        int left = 0, right = 0;
        while (right < n) {
            char rc = s2.charAt(right);
            freq[rc - 'a']++;
            if (freq[rc - 'a'] == dict[rc - 'a']) match++;
            while (size == match) {
                if (right - left + 1 == s1.length()) return true;
                char lc = s2.charAt(left);
                freq[lc - 'a']--;
                if (freq[lc - 'a'] < dict[lc - 'a']) match--;
                left++;
            }
            right++;
        }
        return false;
    }

    public static void main(String[] args) {
        _567_字符串的排列 a = new _567_字符串的排列();
        System.out.println(a.checkInclusion("abc", "bbbca"));

    }
}

class Test_567 {
    public boolean checkInclusion(String s1, String s2) {
        char[] charsOfs1 = s1.toCharArray();
        int n = charsOfs1.length;
        int[] CounterOfs1 = new int[26];
        int[] CounterOfs2 = new int[26];
        int size = 0;
        for (int i = 0; i < n; i++) {
            if (CounterOfs1[charsOfs1[i] - 'a']++ == 0) size++;
        }
        char[] charsOfs2 = s2.toCharArray();
        int matches = 0, left = 0, right = 0;
        for (; right < charsOfs2.length; right++) {
            int index = charsOfs2[right] - 'a';
            if (++CounterOfs2[index] == CounterOfs1[index]) matches++;
            while (matches == size) {
                if (right - left + 1 == n) return true;
                if (--CounterOfs2[charsOfs2[left] - 'a'] < CounterOfs1[charsOfs2[left] - 'a']) matches--;
                left++;
            }
        }
        return false;
    }
}

class Test_567_1 {
    public boolean checkInclusion(String s1, String s2) {
        char[] chars = s1.toCharArray();
        int n = chars.length;
        int[] Counter = new int[26];
        for (int i = 0; i < n; i++) {
            Counter[chars[i] - 'a']++;
        }

        char[] charsOfs2 = s2.toCharArray();
        int left = 0, right = 0;
        for (; right < charsOfs2.length; right++) {
            Counter[charsOfs2[right] - 'a']--;
            if (right - left + 1 == n) {
                boolean is = true;
                for (int i = 0; i < 26; i++) {
                    if (Counter[i] != 0) {
                        is = false;
                        break;
                    }
                }
                if (is) return true;
                ++Counter[charsOfs2[left++] - 'a'];
            }
        }
        return false;
    }

    public static void main(String[] args) {
        Test_567_1 a = new Test_567_1();
        System.out.println(a.checkInclusion("abc", "bbbca"));

    }
}