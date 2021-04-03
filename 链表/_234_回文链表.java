package 链表;

public class _234_回文链表 {
    public boolean isPalindrome(ListNode head) {
        if (head.next == null) return true;
        ListNode fast = head;
        ListNode slow = head;
        // 确定中点
        while (fast.next != null) {
            slow = slow.next;
            fast = fast.next;
            if (fast.next == null) {
                break;
            } else {
                fast = fast.next;
            }
        }
        // 反转链表
        ListNode ReverseNode = reverseList(slow);
        while (ReverseNode != null) {
            if (!ReverseNode.val.equals(head.val)) return false;
            head = head.next;
            ReverseNode = ReverseNode.next;
        }
        return true;

    }

    public ListNode reverseList(ListNode head) {
        if (head == null || head.next == null) return head;
        ListNode newHead = null;
        while (head != null) {
            ListNode tmp = head.next;
            head.next = newHead;
            newHead = head;
            head = tmp;
        }
        return newHead;
    }


    public static void main(String[] args) {
        _234_回文链表 a = new _234_回文链表();
        int[] data = {1, 2, 3};
        ListNode node = new GenergicListNode().getListNode(data);
        System.out.println(a.isPalindrome(node));
    }
}
