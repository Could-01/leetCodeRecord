package 数组;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
import java.util.Stack;

public class _拉马车 {
    static String wagon(String sA, String sB) {
        char[] A = sA.toCharArray();
        char[] B = sB.toCharArray();
        boolean[] rec = new boolean[14]; // 记录栈中是否出现过
        int length = A.length;
        if (length == 0) return "";
        boolean BIsWin = true;
        Queue<Integer> queueA = new LinkedList<>();
        Queue<Integer> queueB = new LinkedList<>();
        for (int i = 0; i < length; i++) {
            queueA.add(transfer(A[i]));
            queueB.add(transfer(B[i]));
        }
        Stack<Integer> stack = new Stack<>();
        int f = queueA.poll();
        stack.push(f);
        rec[f] = true;
        while (queueA.size() != 0 && queueB.size() != 0) {
            if (BIsWin) {
                int bp = queueB.poll();
                if (rec[bp]) {
                    queueB.add(bp);
                    while (stack.peek() != bp) {
                        int b = stack.pop();
                        rec[b] = false;
                        queueB.add(b);
                    }
                    queueB.add(stack.pop());
                    rec[bp] = false;
                    BIsWin = true;
                } else {
                    stack.push(bp);
                    rec[bp] = true;
                    BIsWin = false;
                }
            } else {
                int ap = queueA.poll();
                if (rec[ap]) {
                    queueA.add(ap);
                    while (stack.peek() != ap) {
                        int a = stack.pop();
                        rec[a] = false;
                        queueA.add(a);
                    }
                    queueA.add(stack.pop());
                    rec[ap] = false;
                    BIsWin = false;
                } else {
                    stack.push(ap);
                    rec[ap] = true;
                    BIsWin = true;
                }
            }
        }
        String res = queueA.size() == 0 ? reversetrans(queueB) : reversetrans(queueA);
        return res;
    }

    static int transfer(char ch) {
        if (Character.isLetter(ch)) {
            if (ch == 'A') return 1;
            if (ch == 'X') return 10;
            if (ch == 'J') return 11;
            if (ch == 'Q') return 12;
            if (ch == 'K') return 13;
        }
        return ch - '0';
    }

    static String reversetrans(Queue<Integer> queue) {
        StringBuilder sb = new StringBuilder();
        while (queue.size() != 0) {
            int num = queue.poll();
            if (num == 1) {
                sb.append("A");
            } else if (num == 10) {
                sb.append("X");
            } else if (num == 11) {
                sb.append("J");
            } else if (num == 12) {
                sb.append("Q");
            } else if (num == 13) {
                sb.append("K");
            } else {
                sb.append(num);
            }
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        // 96J5A898QA
        // 6278A7Q973
        Scanner sc = new Scanner(System.in);
        String A = sc.nextLine();
        String B = sc.nextLine();
        wagon(A, B);
        System.out.println(wagon(A, B));
    }
}
