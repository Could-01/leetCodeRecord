package 数组;

public class _3_无重复字符的最长子串 {

    // 经典滑动窗口题
    public int lengthOfLongestSubstring(String s) {
        char[] arr = s.toCharArray();
        if (arr.length == 0) return 0;
        int left = 0, right = 0, res = 0, Rindex = 0, Lindex = 0;
        // 空格是第32个, 最后结尾是126
        boolean[] record = new boolean[95];
        while (right < arr.length) {
            Rindex = arr[right] - ' ';
            if (record[Rindex]) {
                while (arr[left] != arr[right]) {
                    Lindex = arr[left++] - ' ';
                    record[Lindex] = false;
                }
                left++;
            } else {
                record[Rindex] = true;
                res = Math.max(right - left, res);
            }
            right++;
        }
        return res + 1;
    }

    public static void main(String[] args) {
        _3_无重复字符的最长子串 a = new _3_无重复字符的最长子串();
        System.out.println(a.lengthOfLongestSubstring("dvdf"));
    }
}
