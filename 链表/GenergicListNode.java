package 链表;


public class GenergicListNode {
    ListNode getListNode(int[] list) {
        ListNode res = new ListNode(0);
        ListNode tmp = new ListNode(0);
        res.next = tmp;
        for (int i = 0; i < list.length; i++) {
            tmp.val = list[i];
            tmp.next = new ListNode(0);
            if (i == list.length - 1) {
                tmp.next = null;
                return res.next;
            }
            tmp = tmp.next;
        }
        return null;
    }

    String GetListNodeString(int[] list) {
        ListNode node = getListNode(list);
        StringBuilder sb = new StringBuilder(node.toString());
        int length = sb.length();
        sb.delete(length - 8, length);
        return sb.toString();
    }


    void PrintListNodeString(int[] list) {
        System.out.println(GetListNodeString(list));
    }
}
