package 数组;

import java.util.*;

public class _480_滑动窗口中位数 {
    public double[] medianSlidingWindow(int[] nums, int k) {
        int len = nums.length;
        if (len == 1) return new double[]{(double) nums[0]};
        double[] res = new double[len - k + 1];
        if (k == 1) {
            for (int i = 0; i < len; i++) {
                res[i] = (double) nums[i];
            }
            return res;
        }
        int[] Window = new int[k - 1];
        System.arraycopy(nums, 0, Window, 0, k - 1);
        Arrays.sort(Window);
        double num = 0;
        int mid = k / 2; // 限制了不能为1
        if (k % 2 == 0) {
            for (int i = k - 1; i < len; i++) {
                Window = insert(Window, nums[i]);
                num = ((double) Window[mid - 1] + (double) Window[mid]) / 2;
                res[i - k + 1] = num;
                Window = delete(Window, nums[i - k + 1]);
            }
        } else {
            for (int i = k - 1; i < len; i++) {
                Window = insert(Window, nums[i]);
                num = Window[k / 2];
                res[i - k + 1] = num;
                Window = delete(Window, nums[i - k + 1]);
            }
        }
        return res;
    }

    // 确保是有序数列
    private int[] insert(int[] arr, int target) {
        int len = arr.length;
        int[] res = new int[len + 1];
        for (int i = 0; i < len; i++) {
            if (arr[i] >= target) {
                res[i] = target;
                System.arraycopy(arr, i, res, i + 1, len - i);
                break;
            } else {
                res[i] = arr[i];
            }
            if (i == len - 1) res[len] = target;
        }
        return res;
    }

    //删除数
    int[] delete(int[] arr, int target) {
        int[] res = new int[arr.length - 1];
        for (int i = 0; i < res.length; i++) {
            if (arr[i] == target) {
                System.arraycopy(arr, i + 1, res, i, arr.length - i - 1);
                break;
            } else {
                res[i] = arr[i];
            }
        }
        return res;
    }

    public static void main(String[] args) {
        _480_滑动窗口中位数 a = new _480_滑动窗口中位数();
        int[] arr2 = {1, 3};
        int[] arr = {-2147483648, -2147483648, 2147483647, -2147483648};
        double[] res = a.medianSlidingWindow(arr2, 1);
        System.out.println(Arrays.toString(res));
    }
}

class Test_480 {
    public double[] medianSlidingWindow(int[] nums, int k) {
        DualHeap dh = new DualHeap(k);
        for (int i = 0; i < k; ++i) {
            dh.insert(nums[i]);
        }
        double[] ans = new double[nums.length - k + 1];
        ans[0] = dh.getMedian();
        for (int i = k; i < nums.length; ++i) {
            dh.insert(nums[i]);
            dh.erase(nums[i - k]);
            ans[i - k + 1] = dh.getMedian();
        }
        return ans;
    }
}

class DualHeap {
    // 大根堆，维护较小的一半元素
    private PriorityQueue<Integer> small;
    // 小根堆，维护较大的一半元素
    private PriorityQueue<Integer> large;
    // 哈希表，记录「延迟删除」的元素，key 为元素，value 为需要删除的次数
    private Map<Integer, Integer> delayed;

    private int k;
    // small 和 large 当前包含的元素个数，需要扣除被「延迟删除」的元素
    private int smallSize, largeSize;

    public DualHeap(int k) {
        this.small = new PriorityQueue<Integer>(new Comparator<Integer>() {
            public int compare(Integer num1, Integer num2) {
                return num2.compareTo(num1);
            }
        });
        this.large = new PriorityQueue<Integer>(new Comparator<Integer>() {
            public int compare(Integer num1, Integer num2) {
                return num1.compareTo(num2);
            }
        });
        this.delayed = new HashMap<Integer, Integer>();
        this.k = k;
        this.smallSize = 0;
        this.largeSize = 0;
    }

    public double getMedian() {
        return (k & 1) == 1 ? small.peek() : ((double) small.peek() + large.peek()) / 2;
    }

    public void insert(int num) {
        if (small.isEmpty() || num <= small.peek()) {
            small.offer(num);
            ++smallSize;
        } else {
            large.offer(num);
            ++largeSize;
        }
        makeBalance();
    }

    public void erase(int num) {
        delayed.put(num, delayed.getOrDefault(num, 0) + 1);
        if (num <= small.peek()) {
            --smallSize;
            if (num == small.peek()) {
                prune(small);
            }
        } else {
            --largeSize;
            if (num == large.peek()) {
                prune(large);
            }
        }
        makeBalance();
    }

    // 不断地弹出 heap 的堆顶元素，并且更新哈希表
    private void prune(PriorityQueue<Integer> heap) {
        while (!heap.isEmpty()) {
            int num = heap.peek();
            if (delayed.containsKey(num)) {
                delayed.put(num, delayed.get(num) - 1);
                if (delayed.get(num) == 0) {
                    delayed.remove(num);
                }
                heap.poll();
            } else {
                break;
            }
        }
    }

    // 调整 small 和 large 中的元素个数，使得二者的元素个数满足要求
    private void makeBalance() {
        if (smallSize > largeSize + 1) {
            // small 比 large 元素多 2 个
            large.offer(small.poll());
            --smallSize;
            ++largeSize;
            // small 堆顶元素被移除，需要进行 prune
            prune(small);
        } else if (smallSize < largeSize) {
            // large 比 small 元素多 1 个
            small.offer(large.poll());
            ++smallSize;
            --largeSize;
            // large 堆顶元素被移除，需要进行 prune
            prune(large);
        }
    }
}