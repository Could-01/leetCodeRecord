package 数组;

public class _1816_截断句子 {
    public String truncateSentence(String s, int k) {
        for (int i = 0; i < s.length(); i++)
            if (s.charAt(i) == ' ' && --k == 0)
                return s.substring(0, i);
        return s;
    }

    public static void main(String[] args) {
        _1816_截断句子 a = new _1816_截断句子();
        System.out.println(a.truncateSentence("What is the solution to this problem", 4));
    }
}
