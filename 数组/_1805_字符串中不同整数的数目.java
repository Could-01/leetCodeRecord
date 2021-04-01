package 数组;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class _1805_字符串中不同整数的数目 {
    public int numDifferentIntegers(String word) {
        Set<String> set = new HashSet<>();
        char[] WordArr = word.toCharArray();
        int length = WordArr.length;
        for (int i = 0; i < length; i++) {
            char c = WordArr[i];
            StringBuilder sb = new StringBuilder();
            if (Character.isDigit(c)) { // 遇到的第一个数字
                for (; i < length; i++) {
                    char ch = WordArr[i];
                    if (Character.isDigit(ch)) {
                        sb.append(ch);
                    } else {
                        break;
                    }
                }
                if (sb.length() == 1) {
                    set.add(sb.toString());
                } else {
                    int end = sb.length();
                    if (sb.charAt(0) == '0') {
                        for (int j = 0; j < sb.length(); j++) {
                            if (sb.charAt(j) != '0') {
                                end = j;
                                break;
                            }
                        }
                        sb.delete(0, end);
                    }
                    if (sb.length() == 0) {
                        set.add("0");
                    } else {
                        set.add(sb.toString());
                    }
                }
            }
        }
        System.out.println(Arrays.toString(set.toArray()));
        return set.size();
    }

    public int numDifferentIntegers1(String word) {
        char[] nums = word.toCharArray();
        HashSet<String> set = new HashSet();
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] - '0' <= 9 && nums[i] - '0' >= 0) {
                //用一个left记录左边的位置，当左边的字符是 '0' 时，更新i，left
                int left = i;
                while (i < nums.length && nums[left] == '0') {
                    left++;
                    i++;
                }
                //遍历到的元素是数字时，i++
                while (i < nums.length && nums[i] - '0' >= 0 && nums[i] - '0' <= 9) {
                    i++;
                }
                //将子字符串保存下来，添加到HashSet中
                String s = word.substring(left, i);
                set.add(s);
            }
        }
        return set.size();
    }

    public static void main(String[] args) {
        _1805_字符串中不同整数的数目 a = new _1805_字符串中不同整数的数目();
        System.out.println(a.numDifferentIntegers("a1b01c001"));
    }
}
