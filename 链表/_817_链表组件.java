package 链表;

import java.util.TreeSet;

public class _817_链表组件 {
    public int numComponents(ListNode head, int[] nums) {
        TreeSet<Integer> set = new TreeSet<Integer>();
        for (int x : nums) {
            set.add(x);
        }
        ListNode cur = head;
        int res = 0;
        while (cur != null) {
            if (set.contains(cur.val) && (cur.next == null || !set.contains(cur.next.val))) {
                res++;
            }
            cur = cur.next;
        }
        return res;

    }

    public static void main(String[] args) {
        _817_链表组件 a = new _817_链表组件();
        int[] data = {0};
        ListNode node = new GenergicListNode().getListNode(data);
        int[] G = {0};
        System.out.println(a.numComponents(node, G));
    }

}
