package 链表;

public class _21_合并两个有序链表 {
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if (l1 == null) {
            return l2;
        }
        if (l2 == null) {
            return l1;
        }
        if (l1.val <= l2.val) {
            l1.next = mergeTwoLists(l1.next, l2);
            return l1;
        }
        l2.next = mergeTwoLists(l1, l2.next);
        return l2;
    }

    public static void main(String[] args) {
        ListNode l1 = new ListNode(1);
        ListNode l2 = new ListNode(2);
        ListNode l4 = new ListNode(4);
        l1.next = l2;
        l2.next = l4;
        ListNode l1_ = new ListNode(1);
        ListNode l3_ = new ListNode(3);
        ListNode l4_ = new ListNode(4);
        l1_.next = l3_;
        l3_.next = l4_;
        _21_合并两个有序链表 a = new _21_合并两个有序链表();
        ListNode c = a.mergeTwoLists(l1, l1_);
        System.out.println(c);
    }
}