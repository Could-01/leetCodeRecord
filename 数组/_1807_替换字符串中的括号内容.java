package 数组;

import java.util.*;

public class _1807_替换字符串中的括号内容 {
    public String evaluate(String s, List<List<String>> knowledge) {
        Map<String, String> map = new HashMap<>();
        StringBuilder res = new StringBuilder();
        for (int i = 0; i < knowledge.size(); i++) {
            List<String> list = knowledge.get(i);
            map.put(list.get(0), list.get(1));
        }
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            if (ch == '(') {
                int end = getEnd(s, i + 1);
                String key = s.substring(i + 1, end);
                res.append(map.getOrDefault(key, "?"));
                i = end;
            } else {
                res.append(ch);
            }
        }
        return res.toString();
    }

    int getEnd(String s, int index) {
        for (int i = index; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c == ')') {
                return i;
            }
        }
        return index;
    }


    public static void main(String[] args) {
        _1807_替换字符串中的括号内容 a = new _1807_替换字符串中的括号内容();
        List<List<String>> list = new ArrayList<>();
        List<String> l = new ArrayList<>();
        List<String> l1 = new ArrayList<>();
        l.add("a");
        l.add("b");
        list.add(l);
        l1.add("b");
        l1.add("a");
        list.add(l1);
        String res = a.evaluate("(a)(b)", list);
        System.out.println(res);
    }

}
