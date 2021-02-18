package 栈;

public class _844_比较含退格的字符串 {
    public boolean backspaceCompare(String S, String T) {
        return getString(S).equals(getString(T));
    }

    public String getString(String S) {
        StringBuilder St = new StringBuilder();
        int flag = 0;
        for (int end = S.length() - 1; end >= 0; end--) {
            if (S.charAt(end) == '#') {
                flag++;
            } else if (flag > 0) {
                flag--;
            } else {
                St.append(S.charAt(end));
            }
        }
        return St.reverse().toString();
    }

    public static void main(String[] args) {
        _844_比较含退格的字符串 a = new _844_比较含退格的字符串();
        System.out.println(a.backspaceCompare("a##c", "ad#c"));
    }
}

class Test_844 {
    // 从后往前进行一次连续的删除(backspace)
    private int backspace(String s, int index, char c) {
        int cnt = 0;

        while (index >= 0) {
            //统计连续的#数量
            while (c == '#') {
                cnt++;
                index--;
                if (index >= 0) {
                    c = s.charAt(index);
                } else {
                    return -1;//删完了
                }
            }

            //删除至多cnt个连续的非#字符
            while (cnt > 0 && c != '#') {
                cnt--;
                index--;
                if (index >= 0) {
                    c = s.charAt(index);
                } else {
                    return -1;//删完了
                }
            }
            if (c != '#' && cnt <= 0) break;
        }
        return index;
    }

    // O(1)空间复杂度的解法，逆向思维
    public boolean backspaceCompare(String S, String T) {
        char c1, c2;
        int idx1 = S.length() - 1;
        int idx2 = T.length() - 1;
        while (idx1 >= 0 && idx2 >= 0) {
            c1 = S.charAt(idx1);
            c2 = T.charAt(idx2);

            if (c1 != '#' && c2 != '#') {
                if (c1 == c2) {
                    idx1--;
                    idx2--;
                    continue;
                } else {
                    return false;
                }
            }

            idx1 = backspace(S, idx1, c1);
            idx2 = backspace(T, idx2, c2);

            if (idx1 < 0 && idx2 < 0) {
                return true;
            }
        }

        if (idx1 >= 0) {
            idx1 = backspace(S, idx1, S.charAt(idx1));
        }
        if (idx2 >= 0) {
            idx2 = backspace(T, idx2, T.charAt(idx2));
        }

        return idx1 == idx2;
    }

    public static void main(String[] args) {
        Test_844 a = new Test_844();
        System.out.println(a.backspaceCompare("a##c", "ad#c"));
    }
}
