package 链表;

public class _25_K个一组翻转链表 {
    public ListNode reverseKGroup(ListNode head, int k) {
        if (head == null || head.next == null || k <= 1) {
            return head;
        }
        ListNode tmp = new ListNode(0, head);
        ListNode pre = tmp;//翻转开始节点挂载节点
        ListNode end = tmp;//翻转结束节点，挂载在上一区间最后一点
        while (end != null) {//结束节点为空停止翻转
            for (int i = 0; i < k && end != null; i++) {//节点移动k次找到目表
                end = end.next;
            }
            if (end == null) { //说明为翻转区域小于k;
                break;
            }
            ListNode next = end.next;//记录剩下的未翻转区域
            end.next = null;//截断，这次翻转区间 pre.next - end
            ListNode start = pre.next;//指向翻转开始
            pre.next = reverse(start);//链接翻转后的数据，start在链条最末端
            start.next = next;//续上未翻转区域
            //将下一翻转区域挂载这一区域为翻转区域
            pre = start;
            end = start;
        }
        return tmp.next;
    }

    private ListNode reverse(ListNode head) {
        if (head == null || head.next == null) {
            return null;
        }
        ListNode preNode = null;//上一个节点，为翻转后的第一节点
        ListNode newNode = head;//当前节点
        ListNode nextNode = null;//下一个节点
        while (newNode != null) {
            nextNode = newNode.next;//保存下个节点
            newNode.next = preNode;//将翻转的节点接在已翻转节点的前部 -翻转
            preNode = newNode;//将preNode指向翻转后链条的第一个
            newNode = nextNode;//指向下个待翻转节点
        }
        return preNode;
    }

    public static void main(String[] args) {
        _25_K个一组翻转链表 a = new _25_K个一组翻转链表();
        int[] data = {1, 2, 3, 4, 5};
        ListNode node = new GenergicListNode().getListNode(data);
        System.out.println(a.reverseKGroup(node, 3));
    }

}
