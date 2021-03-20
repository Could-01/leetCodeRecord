package 数组;

public class _223_矩形面积 {
    public int computeArea(int A, int B, int C, int D, int E, int F, int G, int H) {
        int area1 = (C - A) * (D - B), area2 = (G - E) * (H - F);
        if (C <= E || D <= F || B >= H || A >= G) {
            return area1 + area2; //无重叠
        }
        int topx = Math.min(G, C), topy = Math.min(H, D);
        int height = topy - Math.max(B, F);
        int width = topx - Math.max(A, E);
        return area1 - (width * height) + area2;
    }

    public static void main(String[] args) {
        _223_矩形面积 a = new _223_矩形面积();
        System.out.println(a.computeArea(-1500000001, 0, -1500000000, 1, 1500000000, 0, 1500000001, 1));
    }
}
