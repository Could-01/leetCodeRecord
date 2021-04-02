package 链表;

public class _328_奇偶链表 {
    public ListNode oddEvenList(ListNode head) {
        if (head == null || head.next == null) return head;
        ListNode OddNodeEnd = head;
        ListNode EvenNodeHead = head.next;
        ListNode EvenNodeEnd = EvenNodeHead;
        while (OddNodeEnd.next != null && EvenNodeEnd.next != null) {
            OddNodeEnd.next = EvenNodeEnd.next;
            OddNodeEnd = OddNodeEnd.next;
            EvenNodeEnd.next = OddNodeEnd.next;
            EvenNodeEnd = EvenNodeEnd.next;
        }
        OddNodeEnd.next = EvenNodeHead;
        return head;
    }

    public static void main(String[] args) {
        _328_奇偶链表 a = new _328_奇偶链表();
        int[] data = {1, 2, 3, 4, 5};
        ListNode node = new GenergicListNode().getListNode(data);
        ListNode res = a.oddEvenList(node);
        System.out.println(res);
    }
}
