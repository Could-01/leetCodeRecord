package 数组;

public class _1785_构成特定和需要添加的最少元素 {
    public int minElements(int[] nums, int limit, int goal) {
        long sum = 0;
        for (int item : nums) {
            sum += item;
        }
        long diff = sum - goal;
        return diff % limit == 0 ? (int) Math.abs(diff / limit) : (int) Math.abs(diff / limit) + 1;
    }

    public static void main(String[] args) {
        _1785_构成特定和需要添加的最少元素 a = new _1785_构成特定和需要添加的最少元素();
        int[] data = {1, -1, 1};
        System.out.println(a.minElements(data, 3, -4));
    }

}
