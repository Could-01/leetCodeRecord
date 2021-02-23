package 链表;

public class _2_两数相加 {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        return dfs(l1, l2, 0);
    }

    ListNode dfs(ListNode l, ListNode r, int i) {
        if (l == null && r == null && i == 0) return null;
        int sum = (l != null ? l.val : 0) + (r != null ? r.val : 0) + i;
        ListNode node = new ListNode(sum % 10);
        node.next = dfs(l != null ? l.next : null, r != null ? r.next : null, sum / 10);
        return node;
    }


    public static int fbnq(int n) {
        System.out.print(n);
        if (n == 2 || n == 1)
            return 1;
        else
            return fbnq(n - 1) + fbnq(n - 2);
        /**
         * 4 3 2
         * 3 1 1
         * 2 1
         *
         *
         * */
    }

    public static void permutation(char[] ch, int n) {//ch表示重新排列后的字符数组，n表示处理第几个坑位
        if (n == ch.length)//基准情形
            System.out.println(String.valueOf(ch));
        else {
            for (int i = n; i < ch.length; i++) {//把n赋值给i用于前面说到的除却已使用的字符
                //以下操作其实是进行了字符交换
                char temp = ch[n];//把要处理的位置的数据拿出来，防止覆盖
                ch[n] = ch[i]; //对第n个坑位进行赋值
                ch[i] = temp;//赋值结束之后需要把前面存储的数据赋值给替换的
                System.out.println("temp为" + temp + ", ch[n]为" + ch[n] + ", i为" + i + ", n为" + n + "现在结果为：" + String.valueOf(ch));
                permutation(ch, n + 1);//继续下个坑位赋值
                //因为上面的交换导致ch数组顺序出错，递归以后需要矫正,不然遍历会出错
                temp = ch[i];
                ch[i] = ch[n];
                ch[n] = temp;
            }
        }
    }

    public static void main(String[] args) {
        //ListNode l1 = new ListNode(2, new ListNode(4, new ListNode(3)));
        //ListNode l2 = new ListNode(5, new ListNode(6, new ListNode(4)));
        //ListNode result = addTwoNumbers(l1, l2);
        //System.out.println(result.toString());
//        System.out.println("递归：" + fbnq(4));
        permutation("abc".toCharArray(), 0);
    }
}
