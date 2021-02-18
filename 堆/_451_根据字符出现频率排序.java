package 堆;

public class _451_根据字符出现频率排序 {
    public String frequencySort(String s) {
        char[] arr = new char[127];
        for (char a : s.toCharArray()) {
            arr[a]++;
        }
        StringBuilder sb = new StringBuilder();
        int count = 0;
        while (count < 127) {
            int max = 0, maxindex = 0;
            for (int i = 0; i < arr.length; i++) {
                if (arr[i] > max) {
                    max = arr[i];
                    maxindex = i;
                }
            }
            while (arr[maxindex] != 0) {
                sb.append((char) (maxindex));
                arr[maxindex]--;
            }
            count++;
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        _451_根据字符出现频率排序 a = new _451_根据字符出现频率排序();
        System.out.println(a.frequencySort("2a554442f544asfasssffffasss"));
    }
}
