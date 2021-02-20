package 链表;

public class GenergicListNode {
    ListNode getListNode(int[] list) {
        if (list.length == 0) return new ListNode();
        ListNode res = new ListNode(list[0]);
        ListNode tmp = new ListNode();
        res.next = tmp;
        for (int i = 1; i < list.length; i++) {
            tmp.next = new ListNode(list[i]);
            tmp = tmp.next;
        }
        ListNode l = res.next.next;
        res.next = l;
        return res;
    }
}
