package 数组;

import java.util.ArrayList;
import java.util.List;

public class _442_数组中重复的数据 {
    public List<Integer> findDuplicates(int[] nums) {
        List<Integer> list = new ArrayList();
        for (int i = 0; i < nums.length; i++) {
            int index = Math.abs(nums[i]) - 1;
            if (nums[index] < 0) {
                list.add(index + 1);
            }
            nums[index] = -Math.abs(nums[index]);
        }
        return list;
    }

    public static void main(String[] args) {
        _442_数组中重复的数据 a = new _442_数组中重复的数据();
        int[] data = {1, 3, 2};
        System.out.println(a.findDuplicates(data));
    }
}
