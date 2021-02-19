package 堆;

import java.util.Arrays;

public class _767_重构字符串 {
    public String reorganizeString(String S) {
        int[] arr = new int[26];
        for (char t : S.toCharArray()) {
            arr[t - 'a']++;
        }
        int len = S.length(), even = 0, odd = 1, count = 0;
        int max = Arrays.stream(arr).max().getAsInt();
        if ((max - 1) > (len - max)) {
            return "";
        }
        char[] re = new char[len];
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < 520; i++) {
            if (arr[i] == 0) {
                continue;
            }
            // arr[i] < (len / 2 + 1) 直接决定是否继续排列数量最多的字符
            while (arr[i] > 0 && arr[i] < (len / 2 + 1) && odd < len) {
                re[odd] = (char) (97 + i);
                count++;
                arr[i]--;
                odd += 2;
            }
            while (arr[i] > 0) {
                re[even] = (char) (97 + i);
                count++;
                arr[i]--;
                even += 2;
            }
            if (count == len) {
                break;
            }
        }
        for (char c : re) {
            sb.append(c);
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        _767_重构字符串 a = new _767_重构字符串();
        System.out.println(a.reorganizeString("aab"));
        // a a a a b b b c
        // 4 3 1
    }
}

class Test_767 {

    public String reorganizeString(String S) {
        int[] arr = new int[26];
        for (char t : S.toCharArray()) {
            arr[t - 'a']++;
        }
        int len = S.length(), even = 0, odd = 1, count = 0;
        int max = Arrays.stream(arr).max().getAsInt();
        if ((max - 1) > (len - max)) {
            return "";
        }
        char[] re = new char[len];
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < 520; i++) {
            if (arr[i] == 0) {
                continue;
            }
            while (arr[i] > 0 && arr[i] < (len / 2 + 1) && odd < len) {
                re[odd] = (char) (97 + i);
                count++;
                arr[i]--;
                odd += 2;
            }

            while (arr[i] > 0) {
                re[even] = (char) (97 + i);
                count++;
                arr[i]--;
                even += 2;
            }
            if (count == len) {
                break;
            }
        }
        for (char c : re) {
            sb.append(c);
        }
        return sb.toString();
    }


    public char[] reorganizeString1(String S) {
        int[] arr = new int[10];
        for (char barcode : S.toCharArray()) {
            arr[barcode - 'a']++;
        }
        int len = S.length(), even = 0, odd = 1, count = 0;
        char[] re = new char[len];
        for (int i = 0; i < 10001; i++) {
            if (arr[i] == 0) {
                continue;
            }
            while (arr[i] > 0 && arr[i] < (len / 2 + 1) && odd < len) {
                re[odd] = (char) (97 + i);
                count++;
                arr[i]--;
                odd += 2;
            }

            while (arr[i] > 0) {
                re[even] = (char) (97 + i);
                count++;
                arr[i]--;
                even += 2;
            }
            if (count == len) {
                break;
            }
        }
        return re;
    }


    public static void main(String[] args) {
        Test_767 a = new Test_767();
        System.out.println(a.reorganizeString("aab"));
    }
}
