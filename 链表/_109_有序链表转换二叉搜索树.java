package 链表;

class TreeNode {
    @Override
    public String toString() {
        return val + " " + left + " " + right;
    }

    int val;
    TreeNode left;
    TreeNode right;

    TreeNode() {
    }

    TreeNode(int val) {
        this.val = val;
    }

    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}

public class _109_有序链表转换二叉搜索树 {
    public TreeNode sortedListToBST(ListNode head) {
        //1. 特例处理
        if (head == null) {
            return null;
        } else if (head.next == null) {
            return new TreeNode(head.val);
        }
        //2. 利用快慢指针找链表中间节点
        ListNode slow = head, fast = head;
        ListNode pre = null;
        while (fast != null && fast.next != null) {
            pre = slow;
            slow = slow.next;
            fast = fast.next.next;
        }
        //3. 创建树的根节点，并断开相应连接
        TreeNode root = new TreeNode(slow.val);
        pre.next = null;

        //4. 递归链表中间节点左右两边的子链表
        root.left = sortedListToBST(head);
        root.right = sortedListToBST(slow.next);
        return root;
    }

    public static void main(String[] args) {
        _109_有序链表转换二叉搜索树 a = new _109_有序链表转换二叉搜索树();
        int[] data = {-10, -3, 0, 5, 9};
        ListNode node = new GenergicListNode().getListNode(data);
        System.out.println(a.sortedListToBST(node));
    }
}
