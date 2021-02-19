package 数组;

import java.util.*;

public class _1424_对角线遍历II {
    public int[] findDiagonalOrder(List<List<Integer>> nums) {
        int rows = nums.size(), cols = nums.get(0).size();
        if (cols == 0) return new int[0];
        for (int i = 0; i < rows; i++) {
            cols = Math.max(cols, nums.get(i).size());
        }
        int r = 0, tmpr = 0, index = 0;
        int[] res = new int[rows * cols];
//        for (int i = 0; i < cols + rows - 1; i++) {
//            int c = 1;
//            r = tmpr;
//            if (r < rows) {
//                for (; r > -1; r--) {
//                    c = i - r;
//                    if (c >= cols || c < 0 || c >= nums.get(r).size()) continue;
//                    res[index++] = nums.get(r).get(c);
//                }
//                tmpr++;
//            } else {
//                for (; c < cols; c++) {
//                    r = i - c;
//                    if (r >= rows || r < 0 || c >= nums.get(r).size()) continue;
//                    res[index++] = nums.get(r).get(c);
//                }
//            }
//        }
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < nums.get(i).size(); j++) {

            }
        }
        return Arrays.copyOf(res, index);
    }


    // 大神写
    public int[] findDiagonalOrder1(List<List<Integer>> nums) {
        // 模仿第一的写一个
        int i, j;
        int rowLength = nums.size();
        int maxColumn = 0;
        for (i = 0; i < rowLength; i++) {
            maxColumn = Math.max(maxColumn, nums.get(i).size());
        }

        List<Integer> cur;
        int resultLength = 0;
        // idx是记录每一条对角线的起始索引(这个包含很多信息, 包括对角线的长度)
        int[] idx = new int[rowLength + maxColumn];
        for (i = 0; i < rowLength; i++) {
            cur = nums.get(i);
            resultLength += cur.size();
            for (j = 0; j < cur.size(); j++) {
                // 让(i, j)位置后面需要让出的长度+1(后面的索引后移)
                idx[i + j + 1]++;
            }
        }
        System.out.println(Arrays.toString(idx));

        for (i = 1; i < idx.length; i++) {
            // 计算出第i-1条对角线上的起始位置
            idx[i] += idx[i - 1];
        }

        int[] result = new int[resultLength];
        for (i = rowLength - 1; i >= 0; i--) {
            cur = nums.get(i);
            for (j = 0; j < cur.size(); j++) {
                // 从后遍历, 因为越后面行的值在每一条对角线上越左下, 对角线越左下的就要放在越前面
                result[idx[i + j]++] = cur.get(j);
                // 放好之后, 当前对角线的起始索引位置变化
            }
        }
        return result;
    }


    public static void main(String[] args) {
        _1424_对角线遍历II a = new _1424_对角线遍历II();
        List<List<Integer>> data = new ArrayList<>();

        List<Integer> List1 = Arrays.asList(1, 2, 3, 4, 5);
        List<Integer> List2 = Arrays.asList(6, 7);
        List<Integer> List3 = Arrays.asList(8);
        List<Integer> List4 = Arrays.asList(9, 10, 11);
        List<Integer> List5 = Arrays.asList(12, 13, 14, 15, 16);

        List<Integer> list1 = new ArrayList<>();
        List<Integer> list2 = new ArrayList<>();
        List<Integer> list3 = new ArrayList<>();
        List<Integer> list4 = new ArrayList<>();
        List<Integer> list5 = new ArrayList<>();

        list1.addAll(List1);
        list2.addAll(List2);
        list3.addAll(List3);
        list4.addAll(List4);
        list5.addAll(List5);


        data.add(list1);
        data.add(list2);
        data.add(list3);
        data.add(list4);
        data.add(list5);

        int[] res = a.findDiagonalOrder1(data);
        System.out.println(Arrays.toString(res));
    }
}
