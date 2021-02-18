package 贪心;

import java.util.Arrays;

public class _455_分发饼干 {
    public int findContentChildren(int[] g, int[] s) {
        if (s.length == 0) return 0;
        Arrays.sort(g);
        Arrays.sort(s);
        int child = 0;
        for (int i = 0; i < g.length; i++) {
            for (int j = 0; j < s.length; j++) {
                if (s[j] >= g[i]) {
                    s[j] = 0;
                    child++;
                    break;
                }
            }
        }
        return child;
    }

    public static void main(String[] args) {
        _455_分发饼干 a = new _455_分发饼干();
        int[] g = {1};
        int[] s = {1, 2, 3};
        System.out.println(a.findContentChildren(g, s));
    }
}
