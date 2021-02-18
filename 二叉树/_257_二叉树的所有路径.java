package 二叉树;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class _257_二叉树的所有路径 {

    public List<String> binaryTreePaths(TreeNode root) {
        LinkedList<String> res = new LinkedList<String>();
        if (root == null) return res;
        getPath(root, new StringBuilder(), res);
        return res;
    }

    private void getPath(TreeNode root, StringBuilder cur, LinkedList<String> linked) {
        if (root == null) return;
        cur.append(root.val);
        if (root.left == null && root.right == null) {
            linked.add(cur.toString());
        } else {
            getPath(root.left, new StringBuilder().append(cur).append("->"), linked);
            getPath(root.right, new StringBuilder().append(cur).append("->"), linked);
        }
    }

    public void solve(TreeNode root, String cur, LinkedList<String> res) {
        if (root == null) return;
        cur += root.val;
        if (root.left == null && root.right == null)
            res.add(cur);
        else {
            solve(root.left, cur + "->", res);
            solve(root.right, cur + "->", res);
        }
    }


    // 深度优先
    public static List<String> getBinaryTreePaths(TreeNode root) {
        List<String> paths = new ArrayList<String>();
        treePaths(root, "", paths);
        return paths;
    }

    public static void treePaths(TreeNode root, String path, List<String> paths) {
        if (root != null) {
            StringBuffer pathBuff = new StringBuffer(path);
            pathBuff.append(root.val);
            if (root.left == null && root.right == null) {
                paths.add(pathBuff.toString());
            } else {
                pathBuff.append("->");
                treePaths(root.left, pathBuff.toString(), paths);
                treePaths(root.right, pathBuff.toString(), paths);
            }
        }
    }


    public static void main(String[] args) {
        _257_二叉树的所有路径 a = new _257_二叉树的所有路径();
        Integer[] data = {4, 2, 6, 1, 3, 5, 7};
        TreeNode node = new GenergicTree().levelOrderGenergic(data);

        System.out.println(a.binaryTreePaths(node));
        System.out.println(getBinaryTreePaths(node));
    }

}

class Test_257 {
    public List<String> binaryTreePaths(TreeNode root) {
        List<String> res = new ArrayList();
        if (root == null) return res;
        getPaths(root, "", res);
        return res;
    }

    private void getPaths(TreeNode root, String s, List<String> res) {
        if (root.left == null && root.right == null) {
            s = s + root.val;
            res.add(s);
            return;
        }
        s = s + root.val;
        getPaths(root.left, s + "->", res);
        getPaths(root.right, s + "->", res);
    }

    public static void main(String[] args) {
        Integer[] data = {4, 2, 6, 1, 3, 5, 7};
        TreeNode node = new GenergicTree().levelOrderGenergic(data);
        Test_257 t = new Test_257();
        System.out.println(t.binaryTreePaths(node));
    }
}