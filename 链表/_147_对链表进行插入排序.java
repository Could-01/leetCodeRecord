package 链表;

public class _147_对链表进行插入排序 {
    public static ListNode insertionSortList(ListNode head) {
        if (head == null) {
            return null;
        }

        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode temp;
        //每次判断下一个节点head.next是否为空，不为空才进行插入操作
        while (head.next != null) {
            // 若head.val较小，则此节点已在正确的位置，无需后续查找插入
            if (head.val <= head.next.val) {
                head = head.next;
                continue;
            }
            temp = head.next;
            head.next = temp.next;
            temp.next = null;
            insertion(dummy, temp);
        }
        return dummy.next;
    }

    // 查找插入点插入
    public static void insertion(ListNode head, ListNode insert) {
        // 当head.next.val > insert.val时，insert的位置就在head和head.next之间
        while (head.next.val < insert.val) {
            head = head.next;
        }
        insert.next = head.next;
        head.next = insert;
    }

    public static void main(String[] args) {

        ListNode l2 = new ListNode(3);
        ListNode l = new ListNode(2, l2);
        l2.next = new ListNode(4);
        ListNode l3 = l;
        System.out.println(l.toString());
        System.out.println(l3.toString());
    }
}
