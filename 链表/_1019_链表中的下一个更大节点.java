package 链表;

import java.util.Arrays;
import java.util.Stack;

public class _1019_链表中的下一个更大节点 {
    public int[] nextLargerNodes(ListNode head) {
        Stack<int[]> stack = new Stack<>();
        ListNode node = head;
        //获取链表长度
        int index = 0;
        while (node != null) {
            node = node.next;
            index++;
        }
        int[] res = new int[index];

        for (int i = 0; head != null; head = head.next, i++) {
            int[] arr = new int[]{i, head.val};
            while (!stack.isEmpty() && head.val > stack.peek()[1]) {
                int[] ele = stack.pop();
                res[ele[0]] = head.val;
            }
            stack.push(arr);
        }
        return res;
    }

    public static void main(String[] args) {
        _1019_链表中的下一个更大节点 a = new _1019_链表中的下一个更大节点();
        int[] data = {2, 1, 5};
        ListNode node = new GenergicListNode().getListNode(data);
        int[] res = a.nextLargerNodes(node);
        System.out.println(Arrays.toString(res));
    }
}
