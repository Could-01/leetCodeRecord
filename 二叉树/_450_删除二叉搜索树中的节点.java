package 二叉树;

public class _450_删除二叉搜索树中的节点 {
    public TreeNode deleteNode(TreeNode root, int key) {
        if (root == null)
            return null;
        //通过递归的方式要先找到要删除的结点
        if (key < root.val) {
            root.left = deleteNode(root.left, key);
        } else if (key > root.val) {
            root.right = deleteNode(root.right, key);
        } else {
            if (root.left == null) {
                return root.right;
            }
            if (root.right == null) {
                return root.left;
            }
            TreeNode maxNode = findMax(root.left);
            root.val = maxNode.val;
            root.left = deleteNode(root.left, root.val);
        }
        return root;
    }

    //找左子树的最大值
    private TreeNode findMax(TreeNode node) {
        while (node.right != null)
            node = node.right;
        return node;
    }

    public static void main(String[] args) {
        Integer[] data = {5, 3, 6, 2, 4, null, 7};
        TreeNode node = new GenergicTree().levelOrderGenergic(data);
        _450_删除二叉搜索树中的节点 n = new _450_删除二叉搜索树中的节点();
        System.out.println(n.deleteNode(node, 3));
    }
}

class Test_450 {
    public TreeNode deleteNode(TreeNode root, int key) {
        if (root == null)
            return null;
        //通过递归的方式要先找到要删除的结点
        if (key < root.val) {
            root.left = deleteNode(root.left, key);
        } else if (key > root.val) {
            root.right = deleteNode(root.right, key);
        } else {
            if (root.left == null) {
                return root.right;
            }
            if (root.right == null) {
                return root.left;
            }
            TreeNode maxNode = findMax(root.left);
            root.val = maxNode.val;
            root.left = deleteNode(root.left, root.val);
        }
        return root;
    }

    //找左子树的最大值
    private TreeNode findMax(TreeNode node) {
        while (node.right != null)
            node = node.right;
        return node;
    }


}