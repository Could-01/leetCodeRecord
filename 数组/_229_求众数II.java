package 数组;

import java.util.ArrayList;
import java.util.List;

public class _229_求众数II {
    public List<Integer> majorityElement(int[] nums) {
        List<Integer> list = new ArrayList<>();
        int x = 0, y = 0;
        int cx = 0, cy = 0;
        for (int num : nums) {
            if ((cx == 0 || num == x) && num != y) {
                cx++;
                x = num;
            } else if (cy == 0 || num == y) {
                cy++;
                y = num;
            } else {
                cx--;
                cy--;
            }
        }

        int xcount = 0, ycount = 0;
        for (int i : nums) {
            if (x == i) {
                xcount++;
            } else if (y == i) {
                ycount++;
            }
        }

        if (xcount > nums.length / 3) list.add(x);
        if (ycount > nums.length / 3 && x != y) list.add(y);
        return list;
    }

    public static void main(String[] args) {
        _229_求众数II a = new _229_求众数II();
        int[] data = {1, 1, 1, 3, 3, 2, 2, 2};
        System.out.println(a.majorityElement(data));
    }
}

class Moore {
    public int majorityElement(int[] nums) {

        int majority = -1;

        int count = 0;

        for (int num : nums) {
            if (count == 0) {
                majority = num;
                count++;
            } else {
                if (majority == num) {
                    count++;
                } else {
                    count--;
                }
            }
        }

        int counter = 0;
        if (count <= 0) {
            return -1;
        } else {
            for (int num : nums) {
                if (num == majority) counter++;
            }
        }

        if (counter > nums.length / 2) {
            return majority;
        }

        return -1;
    }

    public static void main(String[] args) {
        Moore a = new Moore();
        int[] data = {1, 1, 1, 3, 3, 2, 2, 2};
        System.out.println(a.majorityElement(data));
    }
}