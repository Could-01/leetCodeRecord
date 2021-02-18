package 链表;

public class _991_坏了的计算器 {
    public static int brokenCalc(int X, int Y) {
        if (X >= Y)
            return X - Y;
        if (Y % 2 == 0)
            return 1 + brokenCalc(X, Y / 2);
        else
            return 1 + brokenCalc(X, Y + 1);


    }


    public static void main(String[] args) {
        System.out.println(brokenCalc(2, 7));
    }
}
