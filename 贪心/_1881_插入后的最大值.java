package 贪心;

public class _1881_插入后的最大值 {
    public String maxValue(String n, int x) {
        StringBuilder sb = new StringBuilder(n);
        if (n.charAt(0) == '-') { // 负数,从左往右找，找到第一个比他大的，插到大的前面
            for (int i = 0; i < sb.length(); i++) {
                char ch = sb.charAt(i);
                if (ch - '0' > x) {
                    sb.insert(i, x);
                    return sb.toString();
                }
            }
            // 前面的都是比他小的数字，只能吧他安排到最后
            return sb.append(x).toString();
        }


        // 如果是正数，如果下一个数比他小，那就插到它前面
        for (int i = 0; i < sb.length(); i++) {
            char ch = sb.charAt(i);
            if (ch - '0' < x) {
                sb.insert(i, x);
                return sb.toString();
            }
        }

        // 否则插到最后
        return sb.append(x).toString();
    }

    public static void main(String[] args) {
        _1881_插入后的最大值 a = new _1881_插入后的最大值();
        String data = "-99";
        System.out.println(a.maxValue(data, 1));
    }

}
