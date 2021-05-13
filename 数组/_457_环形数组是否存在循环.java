package 数组;

public class _457_环形数组是否存在循环 {
    public boolean circularArrayLoop(int[] nums) {
        if (nums.length == 0 || nums.length == 1 || nums == null) return false;//处理特殊情况
        for (int i = 0; i < nums.length; i++) {
            //慢指针j从i的位置开始移动(类似 slow = node)，快指针k从i移动一次以后的位置开始移动（类似 fast =node.next)
            int j = i, k = next(nums, i);
            //保证快慢指针始终向着nums[i]表示的同一个方向移动,>0始终右，反之始终左
            while (nums[i] * nums[j] > 0 && nums[i] * nums[k] > 0 && nums[i] * nums[next(nums, k)] > 0) {
                if (j == k) {//快慢指针相遇(在循环中相遇，类似于在环形链表中相遇)
                    if (j == next(nums, j)) {
                        break;
                    }//循环长度未1不能true
                    return true;
                }
                j = next(nums, j);//移动慢指针 类似于slow=slow.next;
                k = next(nums, next(nums, k));//移动快指针，类似于fast= fast.next.next;
            }
        }
        return false;
    }

    //计算下一个位置时，避免越界
    private int next(int[] nums, int i) {
        int next = i + nums[i];
        if (next >= 0) return next % nums.length; //合并0~nums.length的部分
        else {
            return nums.length + next % nums.length;
        }
    }

    public static void main(String[] args) {
        _457_环形数组是否存在循环 a = new _457_环形数组是否存在循环();
        int[] data1 = {2, -1, 1, 2, 2};
        int[] data = {3, 1, 2};
        System.out.println(a.circularArrayLoop(data));
    }

}