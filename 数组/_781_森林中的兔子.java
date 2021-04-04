package 数组;

public class _781_森林中的兔子 {
    public int numRabbits(int[] answers) {
        int length = answers.length;
        int max = 0, res = 0;
        for (int i = 0; i < length; i++) {
            max = Math.max(answers[i], max);
        }
        int[] arr = new int[max + 1];
        for (int i = 0; i < length; i++) {
            arr[answers[i]]++;
        }
        for (int i = 0; i <= max; i++) {
            int colors = arr[i];
            if (colors % (i + 1) == 0) {
                res += (colors / (i + 1)) * (i + 1);
            } else {
                res += (colors / (i + 1) + 1) * (i + 1);
            }
        }
        return res;
    }

    public static void main(String[] args) {
        _781_森林中的兔子 a = new _781_森林中的兔子();
        int[] data = {0, 0, 1, 1, 1};
        System.out.println(a.numRabbits(data));
    }
}
