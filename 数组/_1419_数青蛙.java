package 数组;

public class _1419_数青蛙 {
    public int minNumberOfFrogs(String croakOfFrogs) {
        int c = 0, r = 0, o = 0, a = 0, k = 0;
        int res = 0, length = croakOfFrogs.length();
        if (length % 5 != 0) return -1;
        for (int i = 0; i < length; i++) {
            char ch = croakOfFrogs.charAt(i);
            switch (ch) {
                case 'c':
                    c++;
                    break;
                case 'r':
                    r++;
                    break;
                case 'o':
                    o++;
                    break;
                case 'a':
                    a++;
                    break;
                default:
                    k++;
                    break;
            }
            if (r > c || o > r || a > o || k > a) {
                res = -1;
                break;
            }
            res = Math.max(res, c - k);
        }
        return c == k ? res : -1;
    }

    public static void main(String[] args) {
        _1419_数青蛙 a = new _1419_数青蛙();
        String data = "crocakcroraoakk";
        System.out.println(a.minNumberOfFrogs(data));
    }
}
