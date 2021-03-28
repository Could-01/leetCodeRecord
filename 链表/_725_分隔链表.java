package 链表;

import java.util.Arrays;

public class _725_分隔链表 {
    public ListNode[] splitListToParts(ListNode root, int k) {
        int n = 0;
        ListNode cur = root;
        while (cur != null) {
            n++;
            cur = cur.next;
        }
        int mod = n % k;
        int size = n / k;
        ListNode[] res = new ListNode[k];
        cur = root;
        for (int i = 0; i < k && cur != null; i++) {
            res[i] = cur;
            int cursize = size + (mod-- > 0 ? 1 : 0);
            for (int j = 0; j < cursize - 1; j++) {
                cur = cur.next;
            }
            ListNode next = cur.next;
            cur.next = null;
            cur = next;
        }
        return res;
    }

    public static void main(String[] args) {
        _725_分隔链表 a = new _725_分隔链表();
        int[] data = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        ListNode node = new GenergicListNode().getListNode(data);
        ListNode[] res = a.splitListToParts(node, 3);
        System.out.println(Arrays.toString(res));
    }
}
