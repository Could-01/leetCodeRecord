package 数组;

public class _1629_按键持续时间最长的键 {
    public char slowestKey(int[] releaseTimes, String keysPressed) {
        int ans = 0, max = releaseTimes[0], n = releaseTimes.length;
        char word = keysPressed.charAt(0);
        for (int i = 1; i < n; i++) {
            int tt = releaseTimes[i] - releaseTimes[i - 1];
            if (tt > max) {
                word = keysPressed.charAt(i);
                ans = i;
                max = tt;
            } else if (tt == max) {
                if (keysPressed.charAt(i) > word) {
                    ans = i;
                }
            }
        }
        return keysPressed.charAt(ans);
    }


    public static void main(String[] args) {
        _1629_按键持续时间最长的键 a = new _1629_按键持续时间最长的键();
        int[] data = {1, 2, 3};
        String keysPressed = "dce";
        System.out.println(a.slowestKey(data, keysPressed));
    }
}