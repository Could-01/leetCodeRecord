package 链表;

import java.util.List;

public class _203_移除链表元素 {
    public ListNode removeElements(ListNode head, int val) {
        if(head == null) return null;
        head.next = removeElements(head.next, val);
        return head.val == val ? head.next : head;
    }

    public static void main(String[] args) {
        _203_移除链表元素 a = new _203_移除链表元素();

    }
}
