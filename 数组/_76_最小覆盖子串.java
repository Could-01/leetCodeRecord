package 数组;

public class _76_最小覆盖子串 {
    public String minWindow(String s, String t) {
        String res = "";
        int len1 = s.length(), len2 = t.length();
        int[] window = new int[128], chars = new int[128];
        for (int i = 0; i < len2; i++)
            chars[t.charAt(i)]++;
        //count用来记录是否满足包含条件
        int left = 0, right = 0, count = 0, min = Integer.MAX_VALUE;
        while (right < len1) {
            char ch1 = s.charAt(right);
            window[ch1]++;
            //这个小于等于就很巧妙
            if (chars[ch1] > 0 && window[ch1] <= chars[ch1])
                count++;
            //字母个数满足条件
            while (count == len2) {
                //尝试求更小的子字符
                if ((right - left + 1) < min) {
                    min = right - left + 1;
                    res = s.substring(left, right + 1);
                }
                char ch2 = s.charAt(left);
                if (window[ch2] > 0 && window[ch2] <= chars[ch2])
                    count--;
                window[ch2]--;
                left++;
            }
            right++;
        }
        return res;
    }


    public static void main(String[] args) {
        _76_最小覆盖子串 a = new _76_最小覆盖子串();
//        System.out.println(a.minWindow("ADOBECODEBANC", "ABC"));
        System.out.println(a.minWindow("ABBAC", "BAC"));
    }
}
