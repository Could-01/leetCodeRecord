package 链表;

import java.util.HashMap;
import java.util.Map;

public class _1171_从链表中删去总和值为零的连续节点 {
    // 递归解法
    public ListNode removeZeroSumSublists(ListNode head) {
        if (head == null) return null;
        int sum = 0;
        for (ListNode cursor = head; cursor != null; cursor = cursor.next)
            if ((sum += cursor.val) == 0)
                return removeZeroSumSublists(cursor.next);
        head.next = removeZeroSumSublists(head.next);
        return head;
    }

    public ListNode removeZeroSumSublists1(ListNode head) {
        ListNode p = new ListNode(0);
        ListNode pre = p;
        p.next = head;
        while (p != null) {
            ListNode cur = p.next;
            int sum = 0;
            while (cur != null) {
                sum += cur.val;
                cur = cur.next;
                if (sum == 0) {
                    p.next = cur;
                    break;
                }
            }
            if (cur == null) p = p.next;
        }
        return pre.next;
    }

    public ListNode removeZeroSumSublists2(ListNode head) {
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        Map<Integer, ListNode> prefixSumMap = new HashMap<>();
        ListNode p = dummy;
        int prefixSum = 0;
        while (p != null) {
            prefixSum += p.val;
            if (prefixSumMap.containsKey(prefixSum)) {
                p = prefixSumMap.get(prefixSum).next;
                int val = prefixSum + p.val;
                while (val != prefixSum) {
                    prefixSumMap.remove(val);
                    p = p.next;
                    val += p.val;
                }
                prefixSumMap.get(prefixSum).next = p.next;
            } else {
                prefixSumMap.put(prefixSum, p);
            }
            p = p.next;
        }
        return dummy.next;
    }

    public static void main(String[] args) {
        _1171_从链表中删去总和值为零的连续节点 a = new _1171_从链表中删去总和值为零的连续节点();
        int[] data = {1, 2, -3, 3, 1};
        ListNode node = new GenergicListNode().getListNode(data);
        System.out.println(a.removeZeroSumSublists(node));
    }
}
