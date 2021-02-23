package 数组;

import java.util.Arrays;

public class _1498_满足条件的子序列数目 {

    // 错误的
    public int numSubseq(int[] nums, int target) {
        int len = nums.length;
        Arrays.sort(nums);
        if (nums[len - 1] * 2 <= target) return (2 << len - 1) - 1;
        if (nums[0] * 2 > target) return 0;
        int left = 0, right = len - 1, sum = 0, cur = 0;
        // 找到 0 -> right 符合的全部子序列
        while (nums[left] + nums[right] > target) {
            right--;
        }
        // 得到最大子序列的个数和
        sum += (2 << (right - left)) - 1;
        // 剔除其中不符合的子序列数目
        cur = right;
        while (nums[cur] + nums[right] > target) {
            cur--;
        }
        if (cur != right) {
            cur += 1;
            sum -= (2 << (right - cur)) - 1;
            if (nums[cur] * 2 <= target) {
                sum += 1;
            }
        }
        return sum % ((int) Math.pow(10, 9) + 7);
    }

    // 大神答案
    static int mod = 1000000007;

    public int numSubseq1(int[] nums, int target) {
        Arrays.sort(nums);
        int res = 0;
        int n = nums.length;
        int[] pow = new int[n];
        pow[0] = 1;
        for (int i = 1; i < n; i++) {
            pow[i] = pow[i - 1] * 2 % mod;
        }
        int left = 0, right = n - 1;
        while (left <= right) {
            if (nums[left] + nums[right] <= target) {
                res += pow[right - left];
                res %= mod;
                left++;
            } else
                right--;
        }
        return res;
    }


    public static void main(String[] args) {
        _1498_满足条件的子序列数目 a = new _1498_满足条件的子序列数目();
        int[] data = {7, 10, 7, 5, 6, 7, 3, 4, 9, 6};
        System.out.println(a.numSubseq1(data, 9));
        System.out.println(10 << 4);
    }
}

// 快速幂
class fast_pow {

    private static int pow(int n, int m) {
        int res = 1;
        int base = n;
        while (m != 0) {
            if ((m & 1) == 1) {
                res = res * base;
            }
            base = base * base;
            m = m >> 1;
        }
        return res;
    }

    public static void main(String[] args) {
        fast_pow f = new fast_pow();
        System.out.println(pow(3, 10));
    }
}
