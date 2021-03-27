package 链表;

public class _61_旋转链表 {
    public ListNode rotateRight(ListNode head, int k) {
        if (head == null || head.next == null || k == 0) return head; // 先把不符合的直接剔除
        ListNode node = head;
        int length = 0;
        // 1,2,3,4,5
        while (node.next != null) {
            length++;
            node = node.next;
        }
        if (k > length + 1) k = k % (length + 1);
        if (k == length + 1) return head;
        node.next = head;
        int pace = length + 1 - k;
        while (pace != 0) {
            head = head.next;
            node = node.next;
            pace--;
        }
        node.next = null;
        return head;
    }

    public static void main(String[] args) {
        _61_旋转链表 a = new _61_旋转链表();
        GenergicListNode g = new GenergicListNode();
        ListNode node = g.getListNode(new int[]{1, 2});
        System.out.println(a.rotateRight(node, 5));
    }
}
