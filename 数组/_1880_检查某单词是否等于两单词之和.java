package 数组;

public class _1880_检查某单词是否等于两单词之和 {
    public boolean isSumEqual(String firstWord, String secondWord, String targetWord) {
        int sum_first = 0, sum_second = 0, sum_target = 0;
        for (char ch : firstWord.toCharArray()) {
            sum_first *= 10;
            sum_first += ch - 'a';
        }
        for (char ch : secondWord.toCharArray()) {
            sum_second *= 10;
            sum_second += ch - 'a';
        }
        for (char ch : targetWord.toCharArray()) {
            sum_target *= 10;
            sum_target += ch - 'a';
        }
        return (sum_first + sum_second) == sum_target;
    }


    public static void main(String[] args) {
        _1880_检查某单词是否等于两单词之和 a = new _1880_检查某单词是否等于两单词之和();
        String data1 = "";
        String data2 = "aaa";
        String data3 = "aab";
        System.out.println(a.isSumEqual(data1, data2, data3));
    }
}
