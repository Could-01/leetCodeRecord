package 数组;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class _524_通过删除字母匹配到字典里最长单词 {
    public String findLongestWord(String s, List<String> d) {
        if (s.length() == 0 || d.size() == 0) return "";
        char[][] dict = new char[d.size()][1001];
        for (int i = 0; i < d.size(); i++) {
            dict[i] = d.get(i).toCharArray();
        }
        char[] chars = s.toCharArray();
        Arrays.sort(dict, new Comparator<char[]>() {
            @Override
            public int compare(char[] o1, char[] o2) {
                if (o2.length == o1.length) {
                    for (int i = 0; i < o1.length; i++) {
                        if ((o1[i] - 'a') > (o2[i] - 'a')) {
                            return 1;
                        }
                        return -1;
                    }
                }
                return o2.length - o1.length;
            }
        });
        StringBuilder sb = new StringBuilder();
        for (char[] dic : dict) {
            int index = 0;
            for (int i = 0; i < chars.length; i++) {
                if (dic[index] == chars[i]) {
                    index++;
                    if (index == dic.length) {
                        for (char a : dic) {
                            sb.append(a);
                        }
                        return sb.toString();
                    }
                }
            }
        }
        return "";
    }

    public static void main(String[] args) {
        _524_通过删除字母匹配到字典里最长单词 a = new _524_通过删除字母匹配到字典里最长单词();
        List<String> d = new ArrayList<>();
//        d.add("ale");
//        d.add("apple");
//        d.add("monkey");
//        d.add("plea");

        d.add("a");
        d.add("b");
        d.add("c");
        System.out.println(a.findLongestWord("d", d));
    }
}


class Test_524 {
    public String findLongestWord(String s, List<String> d) {
        if (s.length() == 0 || d.size() == 0) return "";
        char[][] dict = new char[d.size()][];
        for (int i = 0; i < d.size(); i++) {
            dict[i] = d.get(i).toCharArray();
        }
        char[] chars = s.toCharArray();
        Arrays.sort(dict, new Comparator<char[]>() {
            @Override
            public int compare(char[] o1, char[] o2) {
                if (o2.length == o1.length) {
                    for (int i = 0; i < o1.length; i++) {
                        if ((o1[i]) > (o2[i])) {
                            return 1;
                        }
                        return -1;
                    }
                }
                return o2.length - o1.length;
            }
        });
        StringBuilder sb = new StringBuilder();
        for (char[] dic : dict) {
            int index = 0;
            for (char aChar : chars) {
                if (dic[index] == aChar) {
                    index++;
                    if (index == dic.length) {
                        for (char a : dic) {
                            sb.append(a);
                        }
                        return sb.toString();
                    }
                }
            }
        }
        return "";
    }

    public static void main(String[] args) {
        Test_524 a = new Test_524();
        List<String> d = new ArrayList<>();
        d.add("ale");
        d.add("abe");
        d.add("apple");
        d.add("monkey");
        d.add("plea");

//        d.add("a");
//        d.add("b");
//        d.add("c");
        System.out.println(a.findLongestWord("abpcplea", d));
    }
}

class Test_524_1 {
    public boolean isSubsequence(String x, String y) {
        int j = 0;
        for (int i = 0; i < y.length() && j < x.length(); i++)
            if (x.charAt(j) == y.charAt(i))
                j++;
        return j == x.length();
    }

    public String findLongestWord(String s, List<String> d) {
        String max_str = "";
        for (String str : d) {
            if (isSubsequence(str, s)) {
                if (str.length() > max_str.length() || (str.length() == max_str.length() && str.compareTo(max_str) < 0))
                    max_str = str;
            }
        }
        return max_str;
    }
}
