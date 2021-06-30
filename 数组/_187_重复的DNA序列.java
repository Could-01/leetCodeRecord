package 数组;

import java.util.*;

public class _187_重复的DNA序列 {
    public List<String> findRepeatedDnaSequences(String s) {
        Set<String> set = new TreeSet<>();
        List<String> list = new ArrayList<>();
        for (int i = 0; i < s.length() - 9; i++) {
            String str = s.substring(i, i + 10);
            if (set.contains(str)) {
                if (list.contains(str)) break;
                list.add(str);
            } else {
                set.add(str);
            }
        }
        return list;
    }


    private static final int LOW_EIGHTEEN_BIT = (1 << 18) - 1; // 低 18 位全是 1。
    private static final int[] BITWISE = new int[26];

    static {
        BITWISE[0] = 0; // A
        BITWISE[6] = 1; // G
        BITWISE[2] = 2; // C
        BITWISE[19] = 3; // T
    }

    public List<String> findRepeatedDnaSequences1(String s) {
        int n = s.length();
        if (n <= 10) {
            return Collections.emptyList();
        }
        char[] str = s.toCharArray();
        int[] nums = new int[n];
        for (int i = 0; i < n; i++) {
            nums[i] = BITWISE[str[i] - 'A'];
        }
        int bitmask = 0;
        for (int i = 0; i < 9; i++) {
            bitmask = (bitmask << 2) | nums[i];
        }
        HashSet<String> repeatedDna = new HashSet<>();
        boolean[] visited = new boolean[1 << 20];
        for (int i = 9; i < n; i++) {
            bitmask = (bitmask << 2) | nums[i];
            if (visited[bitmask]) {
                repeatedDna.add(new String(str, i - 9, 10));
            }
            visited[bitmask] = true;
            bitmask &= LOW_EIGHTEEN_BIT; // 删除高两位，只留下低 18 位。
        }
        return new ArrayList<>(repeatedDna);
    }

    public static void main(String[] args) {
        _187_重复的DNA序列 a = new _187_重复的DNA序列();
        System.out.println(a.findRepeatedDnaSequences("AAAAACCCCCAAAAACCCCCCAAAAAGGGTTT"));
    }
}
