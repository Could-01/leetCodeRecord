package 数组;

import java.util.ArrayList;
import java.util.List;

public class _118_杨辉三角 {
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        List<Integer> tmp = new ArrayList();
        if (numRows == 0) return res;
        tmp.add(1);
        res.add(tmp);
        for (int i = 1; i < numRows; i++) {
            List<Integer> list = new ArrayList();
            list.add(1);
            if (i > 1) {
                for (int j = 0; j < tmp.size() - 1; j++) {
                    list.add(tmp.get(j) + tmp.get(j + 1));
                }
            }
            list.add(1);
            tmp = list;
            res.add(list);
        }
        return res;
    }

    public static void main(String[] args) {
        _118_杨辉三角 a = new _118_杨辉三角();
        System.out.println(a.generate(5));
    }
}
