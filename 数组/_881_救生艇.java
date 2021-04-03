package 数组;

import java.util.Arrays;

public class _881_救生艇 {
    public int numRescueBoats(int[] people, int limit) {
        Arrays.sort(people);
        int right = people.length - 1, left = 0, remain = 0;
        int res = 0;
        while (left <= right) {
            if (left == right) {
                remain++;
                break;
            }
            if (people[left] + people[right] <= limit) {
                left++;
                right--;
                res++;
            } else {
                right--;
                remain++;
            }
        }
        return res + remain;
    }

    public static void main(String[] args) {
        _881_救生艇 a = new _881_救生艇();
        int[] data = {3};
        System.out.println(a.numRescueBoats(data, 3));
    }
}
