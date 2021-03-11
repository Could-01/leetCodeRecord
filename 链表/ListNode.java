package 链表;

public class ListNode {
    Integer val;
    ListNode next;

    boolean flag = true; // 用来标记是否到了最后一个

    ListNode() {
    }

    ListNode(int val) {
        this.val = val;
    }

    public int getVal() {
        return val;
    }

    public void setVal(int val) {
        this.val = val;
    }

    public void setNext(ListNode next) {
        this.next = next;
    }

    public ListNode getNext() {
        return next;
    }

    ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }

    @Override
    public String toString() {
        if ((next == null || val == null) && !flag) {
            return null;
        }

        if (next != null && val != null) {
            return val + "->" + next + "->";
        } else if (flag) {
            flag = false;
            return val + "";
        }


        return null;
    }
}
