package 链表;

public class _1669_合并两个链表 {

    public ListNode mergeInBetween(ListNode list1, int a, int b, ListNode list2) {
        ListNode cur = list1;
        ListNode pre = cur;
        for (int i = 0; cur != null; cur = cur.next, i++) {
            if (i == a - 1) {
                //到达b处
                while (i++ < b) {
                    cur = cur.next;
                }
                pre.next = list2;
                //到达list2末尾
                while (pre.next != null) {
                    pre = pre.next;
                }
                pre.next = cur.next;
            }
            pre = pre.next;
        }
        return list1;
    }

    public static void main(String[] args) {
        _1669_合并两个链表 a = new _1669_合并两个链表();
        GenergicListNode g = new GenergicListNode();
        int[] data1 = {0, 1, 2, 3, 4, 5, 6};
        int[] data2 = {1000000, 1000001, 1000002, 1000003, 1000004};
        ListNode node1 = g.getListNode(data1);
        ListNode node2 = g.getListNode(data2);
        System.out.println(a.mergeInBetween(node1, 2, 5, node2));
    }
}
