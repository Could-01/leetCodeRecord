package 数组;

import java.util.Arrays;

public class _75_颜色分类 {
    public void sortColors(int[] nums) {
        int left = 0, right = nums.length - 1, TmpL = 0, TmpR = nums.length - 1;
        if (right == 0) return;
        //先对 0 排序
        while (left < nums.length) {
            if (nums[left] == 0) {
                while (nums[TmpL] == 0 && TmpL < left) {
                    TmpL++;
                }
                int L = nums[TmpL];
                if (L != 0) {
                    nums[left] = L;
                    nums[TmpL] = 0;
                }
            }
            left++;
        }
        // 对 2 排序
        while (right >= TmpL) {
            if (nums[right] == 2) {
                while (nums[TmpR] == 2 && TmpR > right) {
                    TmpR--;
                }
                int R = nums[TmpR];
                if (R != 2) {
                    nums[right] = R;
                    nums[TmpR] = 2;
                }
            }
            right--;
        }

    }

    public void sortColors1(int[] nums) {
        int num0 = 0, num1 = 0, num2 = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 0) {
                nums[num2++] = 2;
                nums[num1++] = 1;
                nums[num0++] = 0;
            } else if (nums[i] == 1) {
                nums[num2++] = 2;
                nums[num1++] = 1;
            } else {
                nums[num2++] = 2;
            }
        }
    }

    public void sortColors2(int[] nums) {
        int p0 = 0, p2 = nums.length - 1;
        for (int i = 0; i <= p2; i++) {
            if (nums[i] == 0) {
                int temp = nums[i];
                nums[i] = nums[p0];
                nums[p0] = temp;
                p0++;
            }
            if (nums[i] == 2) {
                int temp = nums[i];
                nums[i] = nums[p2];
                nums[p2] = temp;
                p2--;
                if (nums[i] != 1) {
                    i--;
                }
            }

        }
    }


    public static void main(String[] args) {
        _75_颜色分类 a = new _75_颜色分类();
        int[] data = {2, 1};
        a.sortColors(data);
        System.out.println(Arrays.toString(data));
    }
}
