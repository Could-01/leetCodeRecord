package 数组;

import java.util.ArrayList;
import java.util.List;

public class _228_汇总区间 {

    public List<String> summaryRanges(int[] nums) {
        List<String> ans = new ArrayList<String>();
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < nums.length; ++i) {
            if (!(i + 1 < nums.length && nums[i] == nums[i + 1] - 1)) {
                if (sb.length() > 0) sb.append("->");
                sb.append(nums[i]);
                ans.add(sb.toString());
                sb = new StringBuilder();
            } else {
                if (sb.length() == 0) sb.append(nums[i]);
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        _228_汇总区间 a = new _228_汇总区间();
        int[] data = {0, 2, 4, 5, 6, 7};
        System.out.println(a.summaryRanges(data));
    }
}