package 链表;

public class _24_两两交换链表中的节点 {
    public ListNode swapPairs(ListNode head) {
        ListNode nextNode = head.next;
        if (head == null || nextNode == null) {
            return null;
        }
        head.next = swapPairs(nextNode.next);
        nextNode.next = head;
        return nextNode;
    }

    public static void main(String[] args) {
        _24_两两交换链表中的节点 a = new _24_两两交换链表中的节点();

    }
}
