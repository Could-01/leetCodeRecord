package 贪心;

public class _1750_删除字符串两端相同字符后的最短长度 {
    public int minimumLength(String s) {
        char[] chars = s.toCharArray();
        int length = s.length();
        int left = 0, right = length - 1;
        char tmp = chars[0];
        while (left < right) {
            if (chars[left] == chars[right]) {
                tmp = chars[left];
                while (chars[left] == tmp) {
                    left++;
                    if (left == length) break;
                }
                if (left > right) break;
                while (chars[right] == tmp) {
                    right--;
                }
                if (left > right) break;
            } else {
                break;
            }
        }
        return right - left + 1 > 0 ? right - left + 1 : 0;
    }

    public static void main(String[] args) {
        _1750_删除字符串两端相同字符后的最短长度 a = new _1750_删除字符串两端相同字符后的最短长度();
        System.out.println(a.minimumLength("bbbbbbbbbbbbbbbbbbb"));
    }
}
