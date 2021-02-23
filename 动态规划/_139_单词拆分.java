package 动态规划;

import java.util.ArrayList;
import java.util.List;

public class _139_单词拆分 {
    public boolean wordBreak(String s, List<String> wordDict) {
        int n = s.length(), maxlength = 0;
        for (String a : wordDict) {
            maxlength = Math.max(maxlength, a.length());
        }
        // memo[i] 表示 s 中以 i - 1 结尾的字符串是否可被 wordDict 拆分
        boolean[] memo = new boolean[n + 1];
        memo[0] = true;
        for (int i = 1; i <= n; i++) {
            for (int j = i; j >= Math.max(i - maxlength, 0); j--) {
                if (memo[j] && wordDict.contains(s.substring(j, i))) {
                    memo[i] = true;
                    break;
                }
            }
        }
        return memo[n];
    }

    public static void main(String[] args) {
        _139_单词拆分 a = new _139_单词拆分();
        List<String> list = new ArrayList<>();
        list.add("leet");
        list.add("code");
        System.out.println(a.wordBreak("leetcode", list));
    }

}
