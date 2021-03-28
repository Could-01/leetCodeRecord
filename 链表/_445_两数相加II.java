package 链表;

import java.util.Stack;

public class _445_两数相加II {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        Stack<Integer> stack1 = new Stack<Integer>();
        Stack<Integer> stack2 = new Stack<Integer>();
        while (l1 != null) {
            stack1.push(l1.val);
            l1 = l1.next;
        }

        while (l2 != null) {
            stack2.push(l2.val);
            l2 = l2.next;
        }
        boolean plusone = false;
        ListNode head = null;
        while (!stack1.isEmpty() || !stack2.isEmpty() || plusone) {
            int s1 = stack1.isEmpty() ? 0 : stack1.pop();
            int s2 = stack2.isEmpty() ? 0 : stack2.pop();
            int sum = s1 + s2;
            if (plusone) {
                sum += 1;
                plusone = false;
            }
            if (sum >= 10) {
                sum -= 10;
                plusone = true;
            }
            ListNode node = new ListNode(sum);
            node.next = head;
            head = node;
        }
        return head;
    }

    public static void main(String[] args) {
        _445_两数相加II a = new _445_两数相加II();
        GenergicListNode g = new GenergicListNode();
        int[] data1 = {5};
        int[] data2 = {5};
        ListNode l1 = g.getListNode(data1);
        ListNode l2 = g.getListNode(data2);
        System.out.println(a.addTwoNumbers(l1, l2));
    }
}
