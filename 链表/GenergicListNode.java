package 链表;


public class GenergicListNode {

    private ListNode dummy = new ListNode(-1);

    ListNode getListNode(int[] nums) {
        ListNode preNode = dummy;
        for (int i = 0; i < nums.length; i++) {
            ListNode currNode = new ListNode(nums[i]);
            preNode.next = currNode;
            preNode = preNode.next;
        }
        return dummy.next;
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


    public static void main(String[] args) {
        GenergicListNode g = new GenergicListNode();
        System.out.println(g.getListNode(new int[]{1, 2, 3, 4, 5}));
    }
}
