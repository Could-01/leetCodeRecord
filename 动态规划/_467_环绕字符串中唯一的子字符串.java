package 动态规划;

public class _467_环绕字符串中唯一的子字符串 {
    /**
     统计以每个字符作为结尾的最长连续序列(可以覆盖掉重复的短序列的情况), 他们的和即为所求
     例如:abcdbcd, 对于以d结尾的有abcd, bcd, cd和d, 而bcd产生的序列都会被abcd所覆盖
     总和即以a、b、c和d结尾的所有连续最长序列1 + 2 + 3 + 4 = 10
     **/
    public int findSubstringInWraproundString(String p) {
        int len = p.length();
        int res = 0;
        int[] count = new int[26];
        int curmaxlen = 1;
        for (int i = 0; i < len; i++) {
            char ch = p.charAt(i);
            if (i > 0 && (ch - p.charAt(i - 1) == 1 || p.charAt(i - 1) - p.charAt(i) == 25)) {
                curmaxlen++;
            } else {
                curmaxlen = 1;
            }
            count[ch - 'a'] = Math.max(count[ch - 'a'], curmaxlen);
        }
        for (int n : count) {
            res += n;
        }
        return res;
    }


    public static void main(String[] args) {
        _467_环绕字符串中唯一的子字符串 a = new _467_环绕字符串中唯一的子字符串();
        String data = "zab";
        System.out.println(a.findSubstringInWraproundString(data));
    }
}
