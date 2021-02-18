package 链表;

public class _83_删除排序链表中的重复元素 {
    public ListNode deleteDuplicates(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        head.next = deleteDuplicates(head.next);
        if(head.val == head.next.val) head = head.next;
        return head;
    }

    public static void main(String[] args) {
        _83_删除排序链表中的重复元素 a = new _83_删除排序链表中的重复元素();
        ListNode l1 = new ListNode(1);
        ListNode l1_ = new ListNode(1);
        ListNode l2 = new ListNode(2);
        ListNode l3 = new ListNode(3);
        ListNode l3_ = new ListNode(3);
        l1.next = l1_;
        l1_.next = l2;
        l2.next = l3;
        l3.next = l3_;
        System.out.println(a.deleteDuplicates(l1));
    }
}
