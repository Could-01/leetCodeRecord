package 链表;

public class _86_分隔链表 {
    public ListNode partition(ListNode head, int x) {
        if (head == null) return null;
        ListNode listNode = new ListNode(-1);
        listNode.next = head;
        ListNode cur, pre, tmp;
        pre = cur = listNode;
        while (cur.next != null) {
            while (pre.next != null && pre.next.val < x) {
                cur = cur.next;
                pre = pre.next;
            }

            if (pre.next == null) {
                return listNode.next;
            } else if (cur.next.val >= x) {
                cur = cur.next;
            } else {
                tmp = cur.next;
                cur.next = tmp.next;
                tmp.next = pre.next;
                pre.next = tmp;
                pre = pre.next;
            }
        }
        return listNode.next;
    }

    public static void main(String[] args) {
        _86_分隔链表 a = new _86_分隔链表();
        int[] data = {1, 4, 3, 2, 5, 2};
        ListNode node = new GenergicListNode().getListNode(data);
        System.out.println(a.partition(node, 6));
    }
}

class Test_86 {
    public ListNode partition(ListNode head, int x) {
        if (head == null) return null;
        ListNode p, slow, fast;
        p = slow = new ListNode(0);
        fast = head.next;
        slow.next =  head;
        while (fast != null) {
            if (slow.next.val < x) {
                slow = slow.next;
                head = fast;
            } else if (fast.val < x) {
                head.next = fast.next;
                fast.next = slow.next;
                slow = slow.next = fast;
            } else {
                head = fast;
            }
            fast = head.next;
        }
        return p.next;
    }

    public static void main(String[] args) {
        Test_86 a = new Test_86();
        int[] data = {1, 4, 3, 2, 5, 2};
        ListNode node = new GenergicListNode().getListNode(data);
        System.out.println(a.partition(node, 3));
    }
}