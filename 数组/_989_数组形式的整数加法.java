package 数组;

import 链表.ListNode;

import java.util.*;

public class _989_数组形式的整数加法 {
    public List<Integer> addToArrayForm(int[] A, int K) {
        // 使用LinkedList，相对ArrayList而言不需要调整数组位置
        LinkedList<Integer> linkedList = new LinkedList<>();
        int i = A.length - 1;
        while (i >= 0 || K > 0) {
            if (i >= 0) {
                K += A[i--];
                System.out.println("K的值是:" + K);
            }
            linkedList.addFirst(K % 10);
            System.out.println(Arrays.toString(linkedList.toArray()));
            K /= 10;
        }
        return linkedList;
    }

    public static void main(String[] args) {
        _989_数组形式的整数加法 a = new _989_数组形式的整数加法();
        //List<Integer> list = a.addToArrayForm(new int[]{9, 9, 9, 9}, 1);
        List<Integer> list = a.addToArrayForm(new int[]{1, 2, 0, 0}, 34);
    }
}
