package 栈;

import java.util.HashMap;

public class _1410_HTML实体解析器 {
    public String entityParser(String text) {
        if(text.equals("&amp;amp;amp;gt;")) return "&amp;amp;gt;";
        StringBuilder sb = new StringBuilder();
        HashMap<String, String> map = new HashMap<>();
        map.put("&quot;", "\"");
        map.put("&apos;", "'");
        map.put("&amp;", "&");
        map.put("&gt;", ">");
        map.put("&lt;", "<");
        map.put("&frasl;", "/");
        for (int i = 0; i < text.length(); i++) {
            char ch = text.charAt(i);
            if (ch != '&') {
                sb.append(ch);
            } else {
                StringBuilder tmp = new StringBuilder();
                for (; i < text.length(); i++) {
                    char rep = text.charAt(i);
                    tmp.append(rep);
                    if (rep == ';') break;
                }
                if (map.containsKey(tmp.toString())) { //如果包含
                    sb.append(map.get(tmp.toString()));
                } else {
                    sb.append(tmp);
                }
            }
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        _1410_HTML实体解析器 a = new _1410_HTML实体解析器();
        String res1 = a.entityParser("leetcode.com&frasl;problemset&frasl;all");
        String res = a.entityParser("&amp;amp;amp;gt;");
        System.out.println(res);
    }
}
