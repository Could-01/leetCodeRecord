package 栈;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class _68_文本左右对齐 {
    public List<String> fullJustify(String[] words, int maxWidth) {
        List<String> res = new ArrayList<>();
        int[] Space = new int[words.length];
        int arrlength = words.length;
        int length = 0, flag = 0;
        for (int i = 0; i < arrlength; i++) {
            int len = words[i].length() + 1; // 追加一个空格计数
            int gap = 0, extra = 0, count = 0;
            length += len;
            if (length - 1 >= maxWidth) {
                if (length - 1 > maxWidth) {
                    length -= len;// 回退这个字符的长度
                    count = i-- - flag; // 算出字符数量
                } else {
                    count = i - flag + 1; // 算出字符数量
                }
                if (count != 1) {
                    length--; // 最后一个字符后面空格
                    gap = (maxWidth - length) / (count - 1);
                    extra = maxWidth - length - (gap * (count - 1));
                } else {
                    Space[i] = maxWidth - words[i].length() - 1;
                    length = 0;
                    flag = i + 1;
                    continue;
                }
                for (; flag < i; flag++) {
                    Space[flag] = gap; //每个后面最少应该加多少
                    if (extra > 0) {//前几个多一个空格
                        Space[flag]++;
                        extra--;
                    }
                }
                flag = i + 1;
                length = 0;
            } else if (i == arrlength - 1) { //已经到了最后一个，仍然没有触发
                int last = maxWidth - length;
                Space[arrlength - 1] = last;
            }
        }
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < arrlength; i++) {
            sb.append(words[i]);
            if (sb.length() == maxWidth) {
                res.add(sb.toString());
                sb.delete(0, maxWidth);
                continue;
            }
            if (sb.length() == 0) continue;
            for (int j = 0; j <= Space[i]; j++) {
                sb.append(" ");
            }
            if (i == arrlength - 1 || sb.length() == maxWidth) {
                res.add(sb.toString());
                sb.delete(0, maxWidth);
            }
        }
        return res;
    }

    // ["My    momma   always","said, \"Life was like","a box of chocolates.","You  never know what","you're gonna get.   "]
    public static void main(String[] args) {
        _68_文本左右对齐 a = new _68_文本左右对齐();
        String[] data1 = {"This", "is", "an", "example", "of", "text", "justification."};
        String[] data2 = {"What", "must", "be", "acknowledgment", "shall", "be"};
        String[] data3 = {"Science", "is", "what", "we", "understand", "well", "enough", "to", "explain", "to", "a", "computer.", "Art", "is", "everything", "else", "we", "do"};
        String[] data = {"My", "momma", "always", "said,", "\"Life", "was", "like", "a", "box", "of", "chocolates.", "You", "never", "know", "what", "you're", "gonna", "get."};
        System.out.println(a.fullJustify(data, 20));
    }
}