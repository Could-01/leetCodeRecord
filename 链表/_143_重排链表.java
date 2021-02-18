package 链表;

public class _143_重排链表 {
    public void reorderList(ListNode head) {
        if (head == null || head.next == null) return;
        ListNode fast = head;
        ListNode slow = head;
        while (fast != null) {
            if (fast.next != null) {
                fast = fast.next.next;
            } else {
                break;
            }
            slow = slow.next;
        }
        ListNode re = reverseList(slow);
        insert(head, re);
    }

    void insert(ListNode node1, ListNode node2) {
        if (node2.next == null) {
            return;
        }
        ListNode n2next = node2.next;
        ListNode n1next = node1.next;
        node2.next = null;
        node1.next = node2;
        node2.next = n1next;
        insert(n1next, n2next);
    }

    public ListNode reverseList(ListNode head) {
        if (head == null || head.next == null) return head;
        ListNode newHead = reverseList(head.next);
        head.next.next = head;
        head.next = null;
        return newHead;
    }

    public static void main(String[] args) {
        _143_重排链表 a = new _143_重排链表();
        ListNode n1 = new ListNode(1);
        ListNode n2 = new ListNode(2);
        ListNode n3 = new ListNode(3);
        ListNode n4 = new ListNode(4);
        ListNode n5 = new ListNode(5);
        ListNode n6 = new ListNode(6);
        ListNode n7 = new ListNode(7);
        ListNode n8 = new ListNode(8);
        ListNode n9 = new ListNode(9);
        ListNode n10 = new ListNode(10);
        n1.next = n2;
        n2.next = n3;
        n3.next = n4;
        n4.next = n5;
        n5.next = n6;
        n6.next = n7;
        n7.next = n8;
        n8.next = n9;
//        n9.next = n10;

        a.reorderList(n1);
        System.out.println(n1);
    }
}
