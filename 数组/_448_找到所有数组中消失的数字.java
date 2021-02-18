package 数组;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class _448_找到所有数组中消失的数字 {
    // 4, 2, 3, 7, 8, 2, 3, 1
    //
    public List<Integer> findDisappearedNumbers(int[] nums) {
        List<Integer> list = new ArrayList();
        for (int i = 0; i < nums.length; i++) {
            int num = Math.abs(nums[i]) - 1;
            nums[num] = -Math.abs(nums[num]);
        }

        for (int i = 0; i < nums.length; i++) {
            if (nums[i] > 0) {
                list.add(i + 1);
            }
        }
        return list;
    }

    public List<Integer> findDisappearedNumbers1(int[] nums) {
        int n = nums.length;
        for (int i = 0; i < n; i++) {
            int j = nums[i] - 1;
            while (nums[j] != j + 1) {
                int t = nums[j];
                nums[j] = j + 1;
                j = t - 1;
                System.out.println(Arrays.toString(nums));
            }
        }
        List<Integer> res = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            if (nums[i] != i + 1) {
                res.add(i + 1);
            }
        }
        return res;
    }

    public static void main(String[] args) {
        _448_找到所有数组中消失的数字 a = new _448_找到所有数组中消失的数字();
        int[] data = {4, 3, 2, 7, 8, 2, 3, 1};
        List<Integer> res = a.findDisappearedNumbers(data);
        System.out.println(res);
    }
}
